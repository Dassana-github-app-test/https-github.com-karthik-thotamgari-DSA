class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        ArrayList<TreeNode> q1 = new  ArrayList();
        ArrayList<TreeNode> q2 = new  ArrayList();
        boolean yes =  find(root,p,false,q1);
        yes = find(root,q,false,q2);
        TreeNode last = null;
         if(q1.size()<q2.size()){
            for(int i=0;i<q1.size();i++){
                for(int j=0;j< q2.size();j++){
                    if(q1.get(i)==q2.get(j)){
                        last = q1.get(i);
                    }
                }
            }
        }
        else{
            for(int i=0;i<q2.size();i++){
                for(int j=0;j< q1.size();j++){
                    if(q2.get(i)==q1.get(j)){
                        last = q1.get(i);
                    }
                }
            }
        }
        return last;
        
    }
     public boolean find(TreeNode head,TreeNode k,boolean found,ArrayList<TreeNode> q){
        if(head==null){
            return false;
        }
        if(head==k&&!found){
            q.add(head);
            found = true;
            return true;
        }
        q.add(head);
        boolean left = find(head.left,k,found,q);
        boolean right =find(head.right,k,found,q);
        if(left||right){
            return true;
        }
        if(!left&&!right){
            q.remove(q.size()-1);
        }
        return false;
    }
}
// class Solution {

//     private TreeNode ans;

//     public Solution() {
//         // Variable to store LCA node.
//         this.ans = null;
//     }

//     private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

//         // If reached the end of a branch, return false.
//         if (currentNode == null) {
//             return false;
//         }

//         // Left Recursion. If left recursion returns true, set left = 1 else 0
//         int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

//         // Right Recursion
//         int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

//         // If the current node is one of p or q
//         int mid = (currentNode == p || currentNode == q) ? 1 : 0;


//         // If any two of the flags left, right or mid become True
//         if (mid + left + right >= 2) {
//             this.ans = currentNode;
//         }

//         // Return true if any one of the three bool values is True.
//         return (mid + left + right > 0);
//     }

//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         // Traverse the tree
//         this.recurseTree(root, p, q);
//         return this.ans;
//     }
// }