class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res= new ArrayList();
         getpermutations(res,nums,0,0);
        return res;
    }
    public void getpermutations(List<List<Integer>> res,int[] nums,int start,int end){
        if(end==nums.length||start==nums.length){
            List<Integer> arr = new ArrayList();
            for(int i=0;i<nums.length;i++){
                arr.add(nums[i]);
            }
            res.add(new ArrayList(arr));
            return;
        }
        for(int i=end;i<nums.length;i++){
           // System.out.println("start : "+ start+" end: "+end );
            swap(start,i,nums);
            getpermutations(res,nums,start+1,end+1);
            swap(start,i,nums);
        }
    }
    public void swap(int start,int end,int[] nums){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}