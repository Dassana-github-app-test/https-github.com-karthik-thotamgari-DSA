class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> temp = new ArrayList<>();
         List<Integer> ar = new ArrayList<>();
        Arrays.sort(arr);
        return generatesum(arr,target,0,ar);
    }
    public  List<List<Integer>> generatesum(int[] arr,int target, int i,List<Integer> ar) {
        if(target==0){
            List<List<Integer>> temp = new ArrayList<>();
            temp.add(new ArrayList<>(ar));
            return temp;
        } 
        if(i==arr.length){
              List<List<Integer>> temp = new ArrayList<>();
                return temp;
        }
        
        if(arr[i]>target){
            List<List<Integer>> temp = new ArrayList<>();
            return temp;
        }
        ar.add(arr[i]);
        List<List<Integer>> with = generatesum(arr,target-arr[i],i,ar);
        ar.remove(ar.size()-1);
        List<List<Integer>> without = generatesum(arr,target,i+1,ar);
        List<List<Integer>> temp = new ArrayList<>();
        for(List<Integer> i1:with){
            temp.add(new ArrayList<>(i1));
        }
        for(List<Integer> i1:without){
            temp.add(new ArrayList<>(i1));
        }
        return temp;
    }
}