import java.util.*;
class Solution {
    public int[] numberOfPairs(int[] nums) {
        HashMap<Integer,Integer> hmap = new HashMap();
        for(int i=0;i<nums.length;i++){
            if(hmap.containsKey(nums[i])){
                hmap.put(nums[i],(hmap.get(nums[i]))+1);
            }
            else{
                hmap.put(nums[i],1);
            }
        }
        int pcount =0;
        int scount=0;
        for(int i:hmap.keySet()){
            if(hmap.get(i)>1){
                pcount += hmap.get(i)/2;
                hmap.put(i,hmap.get(i)%2);
            }
        }
        for(int i:hmap.keySet()){
            if(hmap.get(i)==1){
                scount++;
            }
        }
        int[] arr = {pcount,scount};
        return arr;
    }
}