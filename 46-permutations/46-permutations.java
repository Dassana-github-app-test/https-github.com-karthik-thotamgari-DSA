class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> arr = new ArrayList();
        Set<Integer> hmap = new HashSet();
        List<List<Integer>> res= new ArrayList();
         getpermutations(nums,0,arr,res,hmap);
        return res;
    }
    public void getpermutations(int[] nums,int i,List<Integer> arr,List<List<Integer>> res,Set<Integer> hmap) {
        if(hmap.size()==nums.length){
            res.add(new ArrayList((arr)));
            return;
        }
        for(int i1=0;i1<nums.length;i1++){
           
            if(hmap.contains(nums[i1])){
                continue;
            }
                hmap.add(nums[i1]);
                arr.add(nums[i1]);
                getpermutations(nums,i1+1,arr,res,hmap);
                hmap.remove(arr.get(arr.size()-1));
                arr.remove(arr.size()-1);
        }
    }
}
// class Solution{
// public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> ret = new ArrayList<>();

//         backtrack(0,ret, new ArrayList<>(), new HashSet<>(), nums);

//         return ret;

//     }
    
//     private void backtrack(int i1,List<List<Integer>> ret, List<Integer> tmpList, Set<Integer> tmpSet, int[] nums) {
//         if (i1 == nums.length) {
//             ret.add(new ArrayList<>((tmpList)));
//             return;
//         }

//         for (int i = 0; i < nums.length; i++) {
//             if (tmpSet.contains(nums[i])) continue;
            
//             tmpSet.add(nums[i]);
//             tmpList.add(nums[i]);
            
//             backtrack(i+1,ret, tmpList, tmpSet, nums);
            
//             tmpSet.remove(tmpList.get(tmpList.size()-1));
//             tmpList.remove(tmpList.size()-1);
//         }
//     }
// }