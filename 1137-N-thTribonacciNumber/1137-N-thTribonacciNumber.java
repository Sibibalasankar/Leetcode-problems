// Last updated: 7/15/2026, 1:31:46 PM
1class Solution {
2
3    public int tribonacci(int n) {
4
5        if(n==0)
6            return 0;
7
8        if(n==1 || n==2)
9            return 1;
10
11        int[] dp=new int[n+1];
12
13        dp[0]=0;
14        dp[1]=1;
15        dp[2]=1;
16
17        for(int i=3;i<=n;i++){
18
19            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
20
21        }
22
23        return dp[n];
24
25    }
26
27}