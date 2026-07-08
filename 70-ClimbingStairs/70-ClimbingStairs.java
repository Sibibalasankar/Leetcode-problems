// Last updated: 7/8/2026, 5:06:14 PM
class Solution {
    public int climbStairs(int n) {
        int a=0;
        int b=1;
        for (int i=0;i<n;i++){
            int result = a+b;
            a=b;
            b=result;
            
        }
        return b;
    }
}