// Last updated: 7/8/2026, 5:00:20 PM
class Solution {
    public int minElement(int[] nums) {
        int[] res=new int[nums.length];
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int temp = nums[i];
            int sum =0;
            while(temp>0){
                int r = temp %10;
                sum +=r;
                temp = temp /10;
            }
            res[i] = sum;
            min = Math.min(min,sum);
        }
        return min;
    }
}