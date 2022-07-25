class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> arr = new ArrayList();
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        getsubsets(nums,0,arr,res);
        return res;
    }
    public void getsubsets(int[] nums,int i,List<Integer> arr,List<List<Integer>> res) {
        res.add(new ArrayList(arr));
        for(int i1=i;i1<nums.length;i1++){
            if(i1>i&&nums[i1]==nums[i1-1]){
                continue;
            }
            arr.add(nums[i1]);
            getsubsets(nums,i1+1,arr,res);
            arr.remove(arr.size()-1);
        }
}
}