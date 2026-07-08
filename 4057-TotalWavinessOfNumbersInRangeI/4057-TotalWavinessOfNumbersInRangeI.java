// Last updated: 7/8/2026, 4:59:19 PM
class Solution {
    public int totalWaviness(int num1, int num2) {
        int wave = 0;
        for(int i=num1;i<=num2;i++){
            char[] nums = String.valueOf(i).toCharArray();
            for(int j=0;j<nums.length-2;j++){
                int a = nums[j] - '0';
                int b = nums[j+1] - '0';
                int c = nums[j+2] - '0';

                if((a>b && b<c) || (a<b && b>c)){
                    wave++;
                }
            }
        }

        return wave;

    }
}