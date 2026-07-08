// Last updated: 7/8/2026, 4:58:53 PM
class Solution {
    public static boolean isprime(int num){
        if(num<=1) return false;

        for(int i=2;i*i<=num;i++){
            if(num%i==0) return false;
        }

        return true;
    }
    
    public int sumOfPrimesInRange(int n) {
        int temp = n;
        int reverse = 0; 
        while(temp>0){
            int r = temp%10;
            reverse = reverse*10+r;
            temp = temp/10;
            
        }
        int start = Math.min(n,reverse);
        int end  = Math.max(n,reverse);
        int sum=0;
        for(int i=start;i<=end;i++){
            if(isprime(i)){
                sum+=i;
            }
        }

        return sum;
    }
}