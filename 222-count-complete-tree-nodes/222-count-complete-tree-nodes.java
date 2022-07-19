class Solution {
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left  = heightleft(root);
        int right = heightright(root);
        if(left==right){
            return (int)Math.pow(2,left)-1;
        }
        else{
            return 1 + countNodes(root.left)+countNodes(root.right);
        }
    }
    public int heightleft(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1 + heightleft(root.left);
    }
    public int heightright(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1 + heightright(root.right);
    }
}