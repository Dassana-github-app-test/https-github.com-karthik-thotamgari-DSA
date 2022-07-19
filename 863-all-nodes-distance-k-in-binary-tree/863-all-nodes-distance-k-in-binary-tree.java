class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> hmap = new HashMap();
        fillmap(hmap,root);
        HashMap<TreeNode,Boolean> visited = new HashMap();
        visited.put(target,true);
        Queue<TreeNode> q = new LinkedList();
        q.add(target);
        q.add(null);
        int level = 0;
        while(!q.isEmpty()){
            if(level==k){
                break;
            }
            
            TreeNode curr = q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    level++;
                    q.add(null);
                }
            }
            else{
            if(curr.left!=null&&!visited.containsKey(curr.left)){
                q.add(curr.left);
                visited.put(curr.left,true);
            }
            if(curr.right!=null&&!visited.containsKey(curr.right)){
                q.add(curr.right);
                visited.put(curr.right,true);
        }
            TreeNode parent = hmap.get(curr);
            if(parent!=null&&!visited.containsKey(parent)){
                q.add(parent);
                visited.put(parent,true);
            }
            }
           // level++;
    }
        List<Integer> res = new ArrayList();
        System.out.print(q);
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr!=null){
            res.add(curr.val);
            }
            }
        return res;
    }
    
    public void fillmap(HashMap<TreeNode,TreeNode> hmap,TreeNode root){
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr.left!=null){
                q.add(curr.left);
                hmap.put(curr.left,curr);
            }
            if(curr.right!=null){
                q.add(curr.right);
                hmap.put(curr.right,curr);
            
        }
    }
    }
}