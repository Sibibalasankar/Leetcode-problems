// Last updated: 7/18/2026, 8:45:54 PM
1class Solution {
2    public int findGCD(int[] nums) {
3        int mn = 1001, mx = 0;
4
5        for (int num : nums) {
6            if (num < mn)
7                mn = num;
8            if (num > mx)
9                mx = num;
10        }
11
12        return gcd(mn, mx);
13    }
14
15    private int gcd(int a, int b) {
16        while (b != 0) {
17            int rem = a % b;
18            a = b;
19            b = rem;
20        }
21        return a;
22    }
23}