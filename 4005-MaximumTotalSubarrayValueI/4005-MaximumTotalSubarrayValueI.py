# Last updated: 7/8/2026, 4:59:32 PM
class Solution:
    def maxTotalValue(self, nums: List[int], k: int) -> int:
        return (max(nums) - min(nums)) * k