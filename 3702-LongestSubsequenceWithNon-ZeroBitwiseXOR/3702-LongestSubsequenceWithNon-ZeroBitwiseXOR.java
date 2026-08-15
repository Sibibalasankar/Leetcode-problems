// Last updated: 8/15/2026, 9:01:58 PM
1class Solution {
2    public int longestSubsequence(int[] nums) {
3        int xorValue = 0;
4        boolean hasNonZero = false;
5
6        for (int x : nums) {
7            xorValue ^= x;
8
9            if (x != 0) {
10                hasNonZero = true;
11            }
12        }
13
14        if (xorValue != 0) {
15            return nums.length;
16        }
17
18        if (hasNonZero) {
19            return nums.length - 1;
20        }
21
22        return 0;
23    }
24}