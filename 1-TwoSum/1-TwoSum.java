// Last updated: 7/24/2026, 8:28:29 PM
1class Solution {
2    public int[] twoSum(int[] nums, int target) {
3
4        for (int i = 0; i < nums.length; i++) {
5
6            for (int j = i + 1; j < nums.length; j++) {
7
8                if (nums[i] + nums[j] == target) {
9                    return new int[]{i, j};
10                }
11
12            }
13        }
14
15       
16        return new int[]{};
17    }
18}