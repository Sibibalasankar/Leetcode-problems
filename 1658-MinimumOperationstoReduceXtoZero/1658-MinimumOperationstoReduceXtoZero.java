// Last updated: 9/23/2026, 10:06:50 PM
1class Solution {
2    public int minOperations(int[] nums, int x) {
3
4        int n = nums.length;
5        int total = 0;
6        for (int num : nums) total += num;
7
8        int target = total - x;
9
10        if (target < 0) return -1;
11        if (target == 0) return n;
12
13        int left = 0;
14        int sum = 0;
15        int longest = -1;
16
17        for (int right = 0; right < n; right++) {
18            sum += nums[right];
19
20            while (left <= right && sum > target)
21                sum -= nums[left++];
22
23            if (sum == target)
24                longest = Math.max(longest, right - left + 1);
25        }
26
27        return longest == -1 ? -1 : n - longest;
28    }
29}