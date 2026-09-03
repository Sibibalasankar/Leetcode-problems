// Last updated: 9/3/2026, 11:05:17 AM
1class Solution {
2    public boolean uniformArray(int[] nums) {
3        int smallestOdd = Integer.MAX_VALUE;
4
5        for (int num : nums) {
6            if (num % 2 == 1)
7                smallestOdd = Math.min(smallestOdd, num);
8        }
9
10        // Already all even
11        if (smallestOdd == Integer.MAX_VALUE)
12            return true;
13
14        // Check whether every even number can become odd
15        for (int num : nums) {
16            if (num % 2 == 0 && num <= smallestOdd)
17                return false;
18        }
19
20        return true;
21    }
22}