class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Map<Integer,Integer> hmap = new HashMap();        
        List<Integer> arr = new ArrayList();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(hmap.containsKey(nums[i])){
                hmap.put(nums[i],hmap.get(nums[i])+1);
            }
            else{
                hmap.put(nums[i],1);
            }
        }
        getpermutations(arr,res,nums,0,hmap);
        return res;
    }
    public void getpermutations(List<Integer> arr,List<List<Integer>> res,int[] nums,int i, Map<Integer,Integer> hmap){
        if(i==nums.length){
            System.out.print(arr);
            res.add(new ArrayList(arr));
            return;
        }
        for(int i1:hmap.keySet()){
            if(hmap.get(i1)==0){
                continue;
            }
            arr.add(i1);
            hmap.put(i1,hmap.get(i1)-1);
            getpermutations(arr,res,nums,i+1,hmap);
            hmap.put(i1,hmap.get(i1)+1);
            arr.remove(arr.size()-1);
        }
}
}