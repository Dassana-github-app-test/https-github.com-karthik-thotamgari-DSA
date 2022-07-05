class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        int lh = height(root.left);
        int rh = height(root.right);
        if(Math.abs(lh-rh)>1){
            return false;
        }
        if(!left||!right){
            return false;
        }
        return true;
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left,right)+1;
    }
}