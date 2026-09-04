// Last updated: 9/4/2026, 9:47:43 PM
1class Solution {
2    public int firstStableIndex(int[] nums, int k) {
3        int n = nums.length;
4        int[] suffix = new int[n];
5 
6        int mn = Integer.MAX_VALUE;
7        // Build suffix minimum
8        for (int i = n - 1; i >= 0; i--) {
9            mn = Math.min(mn, nums[i]);
10            suffix[i] = mn;
11        }
12 
13        int mx = 0;
14        // Find first index with score <= k
15        for (int i = 0; i < n; i++) {
16            mx = Math.max(mx, nums[i]);
17            int score = mx - suffix[i];
18            if (score <= k)
19                return i;
20        }
21 
22        return -1;
23    }
24}