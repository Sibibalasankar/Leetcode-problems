// Last updated: 7/9/2026, 7:07:52 PM
1class Solution {
2    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
3        int[] comp = new int[n];
4        comp[0] = 0;
5
6        for (int i = 1; i < n; i++) {
7            if (nums[i] - nums[i - 1] <= maxDiff) {
8                comp[i] = comp[i - 1];
9            } else {
10                comp[i] = comp[i - 1] + 1;
11            }
12        }
13
14        boolean[] ans = new boolean[queries.length];
15
16        for (int i = 0; i < queries.length; i++) {
17            int u = queries[i][0];
18            int v = queries[i][1];
19            ans[i] = (comp[u] == comp[v]);
20        }
21
22        return ans;
23    }
24}