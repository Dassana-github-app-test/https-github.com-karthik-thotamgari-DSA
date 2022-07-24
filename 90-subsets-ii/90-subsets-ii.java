class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> res = new ArrayList();
        Arrays.sort(nums);
        HashSet<List<Integer>> hset =  new HashSet();
        hset = getsubsets(nums,0,res);
        List<List<Integer>> rest = new ArrayList();
        for(List<Integer> l1:hset){
            rest.add(new ArrayList(l1));
        }
        return rest;
    }
     public HashSet<List<Integer>> getsubsets(int[] nums,int i,List<Integer> res) {
         if(i==nums.length){
             HashSet<List<Integer>> temp = new HashSet();
             temp.add(new ArrayList(res));
             return temp;
         }
         res.add(nums[i]);
         HashSet<List<Integer>> with = getsubsets(nums,i+1,res);
         res.remove(res.size()-1);
         HashSet<List<Integer>> without = getsubsets(nums,i+1,res);
         for(List<Integer> i1:without){
             with.add(i1);
         }
         return with;
     }
}