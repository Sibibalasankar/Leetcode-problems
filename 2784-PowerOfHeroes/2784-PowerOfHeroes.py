# Last updated: 7/8/2026, 5:01:03 PM
class Solution:
    def sumOfPower(self, nums: List[int]) -> int:
        ans, t, base = 0, 0, 10**9 + 7
        for c in sorted(nums):
            ans = (ans + (t + c) * c * c) % base
            t = (2 * t + c) % base
        return ans