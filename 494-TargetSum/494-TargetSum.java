// Last updated: 7/8/2026, 5:04:17 PM
class Solution {
    private int[][] dp;
    private int OFFSET;

    private int solve(int[] nums, int target, int idx) {

        if (idx == nums.length)
            return target == 0 ? 1 : 0;

        if (target < -OFFSET || target > OFFSET)
            return 0;

        if (dp[idx][target + OFFSET] != -1)
            return dp[idx][target + OFFSET];

        int plus = solve(nums, target - nums[idx], idx + 1);

        int minus = solve(nums, target + nums[idx], idx + 1);

        return dp[idx][target + OFFSET] = plus + minus;
    }

    public int findTargetSumWays(int[] nums, int target) {

        int total = 0;

        for (int x : nums)
            total += x;

        if (Math.abs(target) > total)
            return 0;

        OFFSET = total;

        dp = new int[nums.length][2 * total + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(nums, target, 0);
    }
}