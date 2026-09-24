// Last updated: 9/24/2026, 7:17:41 PM
1class Solution {
2    public int smallestIndex(int[] nums) {
3
4        for (int i = 0; i < nums.length; i++) {
5            int x = nums[i];
6            int sum = 0;
7
8            while (x > 0) {
9                sum += x % 10;
10                x /= 10;
11            }
12
13            if (sum == i)
14                return i;
15        }
16
17        return -1;
18    }
19}