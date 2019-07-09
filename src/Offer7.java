import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Offer7 {
    public static TreeNode reConstructBinaryTree(int [] pre, int [] in){
        if(pre == null || pre.length == 0 || in == null || in.length == 0 || pre.length != in.length)
            return null;
        return reConstructBinaryTreeCore(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public static TreeNode reConstructBinaryTreeCore(int [] pre, int startPre, int endPre, int [] in, int startIn, int endIn){
        int rootValue = pre[startPre];
        TreeNode root = new TreeNode(rootValue);
        if(startPre == endPre && startIn == endIn && pre[startPre] == pre[startIn])
            return root;
        int rootOrder = startIn;
        while (rootOrder <= endIn){
            if(in[rootOrder] == rootValue)
                break;
                ++rootOrder;
        }
        if(rootOrder == endIn + 1)
            return null;
        int leftLength = rootOrder - startIn ;
        int rightLength = endIn - rootOrder;
        if(leftLength > 0)
            root.left = reConstructBinaryTreeCore(pre, startPre + 1, startPre + leftLength, in, startIn, rootOrder - 1);
        if(rightLength > 0)
            root.right = reConstructBinaryTreeCore(pre, startPre + leftLength + 1, endPre, in, rootOrder + 1, endIn);
        return root;
    }

    public static void postOrderRecursive(TreeNode root){
        TreeNode temp = root;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int left = 1;
        int right = 2;
        while (temp != null || !stack1.isEmpty()){
            while (temp != null){
                stack1.push(temp);
                stack2.push(left);
                temp = temp.left;
            }

            while (!stack1.isEmpty() && stack2.peek() == 2){
                System.out.print(stack1.pop().val);
                stack2.pop();
            }
            if(!stack1.isEmpty() && stack2.peek() == 1){
                stack2.pop();
                stack2.push(right);
                temp = stack1.peek().right;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入前序遍历：");
        int[] pre = Arrays.stream(sc.nextLine().trim().split(" ")).mapToInt(Integer::valueOf).toArray();
        System.out.println("请输入中序遍历：");
        int[] in = Arrays.stream(sc.nextLine().trim().split(" ")).mapToInt(Integer::valueOf).toArray();
        TreeNode root = reConstructBinaryTree(pre, in);
        postOrderRecursive(root);
    }
}
