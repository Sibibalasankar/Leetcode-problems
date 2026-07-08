// Last updated: 7/8/2026, 5:04:51 PM
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n >0 && (n & (n-1))==0){
            return true;
        }
        return false;
    }
}