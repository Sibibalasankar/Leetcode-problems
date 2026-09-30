// Last updated: 9/30/2026, 10:08:00 PM
1class Solution {
2    public int[] maxDepthAfterSplit(String s) {
3        int n = s.length();
4        int[] res = new int[n];
5        
6        for (int i = 0; i < n; i++)
7            res[i] = (i ^ s.charAt(i)) & 1;
8            
9        return res;
10    }
11}