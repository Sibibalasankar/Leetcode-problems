// Last updated: 7/8/2026, 4:58:55 PM
class Solution {
    public int[] countOppositeParity(int[] nums) {
        int[]  arr= new int[nums.length];
        for(int i=0;i<nums.length;i++){
        int count = 0;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]%2!=nums[i]%2){
                    count++;
                }
            }
            arr[i] = count;
        }
        return arr;
    }
}