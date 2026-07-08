// Last updated: 7/8/2026, 5:06:16 PM
class Solution {
    public int mySqrt(int x) {
        long r=x;
        while(r*r >x){
         r =  (r + x/r) / 2;

     }
        return (int) r;
    }
}