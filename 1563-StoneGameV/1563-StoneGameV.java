// Last updated: 8/17/2026, 6:29:46 PM
1class Solution {
2    int[] prefixSum;
3    private int f(int start, int end , int[][] dp){
4        int score = 0;
5        if(dp[start][end] != -1)return dp[start][end];
6        for(int idx = start + 1; idx <= end ; ++idx){
7            int curr = 0;
8            int leftSum = prefixSum[idx-1] - (start - 1 >= 0 ? prefixSum[start-1] : 0);
9            int rightSum = prefixSum[end] - prefixSum[idx-1];
10            if(leftSum < rightSum)curr = leftSum + f(start,idx-1,dp);
11            else if(rightSum < leftSum)curr = rightSum + f(idx,end,dp);
12            else curr = leftSum + Math.max(f(start,idx-1,dp),f(idx,end,dp));
13            score = Math.max(curr,score);
14        }
15        return dp[start][end] = score;
16    }
17    public int stoneGameV(int[] stoneValue) {
18        int n = stoneValue.length;
19        prefixSum = new int[n];
20        int dp[][] = new int[n][n];
21        for (int[] row : dp) {
22            Arrays.fill(row, -1);
23        }
24        prefixSum[0] = stoneValue[0];
25        for(int i = 1 ; i < n ; ++i){
26            prefixSum[i] = prefixSum[i-1] + stoneValue[i];
27        }
28        return f(0,n-1,dp);
29
30    }
31}