// Last updated: 9/20/2026, 8:11:39 PM
1class Solution {
2    public int reverseDegree(String s) {
3
4        int ans = 0;
5        
6        for(int i = 0; i < s.length(); i++){
7
8            ans += ('z' - s.charAt(i) + 1) * (i+1);
9        }
10
11        return ans;
12    }
13}