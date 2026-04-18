class Solution {

    public static int reverse(int n){
        int temp=0;
        while(n>0){
            int r = n%10;
            temp = temp * 10 + r;
            n=n/10;
        }
        return temp;
    }
    public int mirrorDistance(int n) {
        return Math.abs(n-(reverse(n)));
    }
}