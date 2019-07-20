import java.util.Stack;

public class MirrorBinary {
    //循环实现二叉树镜像
    public TreeNode Mirror(TreeNode root){
        if(root == null)
            return root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()){
            if(node != null){
                stack.push(node);
                if(node.left != null || node.right != null)
                    swapBinary(node);
                node = node.left;
            }else {
                node = stack.pop();
                node = node.right;
            }
        }
        return root;
    }

    public void swapBinary(TreeNode node){
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    public static void preOrderRecursive(TreeNode root){
        System.out.print(root.val);

        if(root.left != null)
            preOrderRecursive(root.left);
        if(root.right != null)
            preOrderRecursive(root.right);
    }

    public static void main(String[] args) {
        TreeNode R3 = new TreeNode(6);
        TreeNode R2 = new TreeNode(5);
        TreeNode L2 = new TreeNode(4);
        TreeNode L1 = new TreeNode(2);
        TreeNode R1 = new TreeNode(3);
        TreeNode T = new TreeNode(1);
        T.left = L1;
        T.right = R1;
        L1.left = L2;
        L1.right = R2;
        R2.right = R3;
        MirrorBinary mirrorBinary = new MirrorBinary();
        TreeNode root = mirrorBinary.Mirror(T);
        preOrderRecursive(root);
    }
}
