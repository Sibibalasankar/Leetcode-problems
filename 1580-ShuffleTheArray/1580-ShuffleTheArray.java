// Last updated: 7/8/2026, 5:02:39 PM
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int arr[] =new int[nums.length];
        int j=0;
        for(int i=0;i<nums.length;i+=2){
            arr[i] = nums[j++]; 
        }
        for(int i=1;i<nums.length;i+=2){
            arr[i]=nums[j++];
        }
        return arr;
    }
}