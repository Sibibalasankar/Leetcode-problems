// Last updated: 7/8/2026, 4:58:47 PM
class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
         int idx =0;

        for(int num:nums){
            if(idx<k||num!=nums[idx-k]){
                nums[idx] = num;
                idx++;
            }
        }


        int[] res=new int[idx];


        for(int i=0;i<idx;i++){
            res[i]=nums[i];
        }
        return res;
    }
}