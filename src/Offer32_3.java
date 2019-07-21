import java.util.ArrayList;
import java.util.Stack;

public class Offer32_3 {
    //按“之”字形打印二叉树
    public ArrayList<ArrayList<Integer>> print(TreeNode root){
        if(root == null)
            return null;

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        Stack<TreeNode> [] levels = new Stack[2];
        levels[0] = new Stack<TreeNode>();
        levels[1] = new Stack<TreeNode>();
        int current = 0;
        int next = 1;
        levels[0].push(root);
        while (!levels[current].isEmpty() || !levels[next].isEmpty()){
            TreeNode node = levels[current].peek();
            list1.add(node.val);
            levels[current].pop();

            if(current == 0){
                if (node.left != null)
                    levels[next].add(node.left);
                if(node.right != null)
                    levels[next].add(node.right);
            }else {
                if (node.right != null)
                    levels[next].add(node.right);
                if(node.left != null)
                    levels[next].add(node.left);
            }

            if(levels[current].isEmpty()){
                list.add(list1);
                list1 = new ArrayList<Integer>();
                current = 1 - current;
                next = 1 - next;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Offer32_3 offer32_3 = new Offer32_3();
        TreeNode T = new TreeNode(1);
        TreeNode L1 = new TreeNode(2);
        TreeNode R1 = new TreeNode(3);
        TreeNode L2 = new TreeNode(4);
        TreeNode R2 = new TreeNode(5);
        TreeNode L3 = new TreeNode(6);
        TreeNode R3 = new TreeNode(7);
        TreeNode L4 = new TreeNode(8);
        TreeNode R4 = new TreeNode(9);
        TreeNode L5 = new TreeNode(10);
        TreeNode R5 = new TreeNode(11);
        TreeNode L6 = new TreeNode(12);
        TreeNode R6 = new TreeNode(13);
        TreeNode L7 = new TreeNode(14);
        TreeNode R7 = new TreeNode(15);
        T.left = L1;
        T.right = R1;
        L1.left = L2;
        L1.right = R2;
        R1.left = L3;
        R1.right = R3;
        L2.left = L4;
        L2.right = R4;
        R2.left = L5;
        R2.right = R5;
        L3.left = L6;
        L3.right = R6;
        R3.left = L7;
        R3.right = R7;
        ArrayList<ArrayList<Integer>> list = offer32_3.print(T);
        System.out.println(list);
    }
}
