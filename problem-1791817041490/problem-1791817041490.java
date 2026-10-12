// Last updated: 10/12/2026, 8:27:21 PM
1class Solution {
2    public int maxSum(List<Integer> nums, int k) {
3        int[] b = new int[30];
4        long ans = 0, mod = 1000000007;
5
6        // Step 1: count the 1-bits in every bit position
7        for (int x : nums)
8            for (int i = 0; i < 30; i++)
9                if ((x & (1 << i)) != 0) b[i]++;
10
11        // Step 2: build k numbers, each takes one 1-bit from every position that still has one
12        while (k-- > 0) {
13            long x = 0;
14            for (int i = 0; i < 30; i++)
15                if (b[i] > 0) {
16                    x |= 1L << i;
17                    b[i]--;
18                }
19            ans = (ans + x * x) % mod;
20        }
21
22        return (int) ans;
23    }
24}