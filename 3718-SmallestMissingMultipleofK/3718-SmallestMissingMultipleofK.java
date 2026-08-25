// Last updated: 8/25/2026, 9:24:50 AM
1class Solution {
2    public int missingMultiple(int[] nums, int k) {
3        Set<Integer> seen = new HashSet<>();
4        for (int num : nums) {
5            seen.add(num);
6        }
7
8        int cur = k;
9        while (seen.contains(cur)) {
10            cur += k;
11        }
12
13        return cur;
14    }
15}