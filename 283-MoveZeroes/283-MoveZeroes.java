// Last updated: 7/8/2026, 5:04:43 PM
class Solution {
    public void moveZeroes(int[] nums) {
        int[] dummy = new int[nums.length];
        int count=0;
        int j=0;
        for(int i:nums){
            if(i==0){
                count++;
            }else{
                dummy[j++]=i;
            }
        }
        int range = nums.length-count;
        for(int i=range;i<dummy.length;i++){
            dummy[i]=0;
        }
        for(int i=0;i<dummy.length;i++){
            nums[i]=dummy[i];
        }
    }
}