public class Offer55_2 {
    public boolean IsBalanced_Solution(TreeNode root) {
        return (isBalanced(root) == -1) ? false : true;
    }

    public int isBalanced(TreeNode root){
        if(root == null)
            return 0;
        int left = isBalanced(root.left);//左子树的高度
        if(left == -1)
            return -1;//发现左子树不是平衡二叉树，直接跳过下面代码，返回-1
        int right = isBalanced(root.right);//右子树的高度
        if(right == -1)
            return -1;//发现右子树不是平衡二叉树，直接跳过下面代码，返回-1
        int diff = left - right;
        if(diff >= -1 && diff <= 1){
            int height = (left > right) ? left + 1 : right + 1;
            return height;
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode L3 = new TreeNode(7);
        TreeNode R3 = new TreeNode(6);
        TreeNode L2 = new TreeNode(4);
        TreeNode R2 = new TreeNode(5);
        TreeNode L1 = new TreeNode(2);
        TreeNode R1 = new TreeNode(3);
        TreeNode T = new TreeNode(1);
        T.left = L1;
        T.right = R1;
        L1.left = L2;
        L1.right = R2;
        R1.right = R3;
        R2.left = L3;
        Offer55_2 offer55_2 = new Offer55_2();
        System.out.println(offer55_2.IsBalanced_Solution(T));
    }
}
