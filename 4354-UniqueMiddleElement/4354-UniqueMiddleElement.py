# Last updated: 7/8/2026, 4:58:46 PM
class Solution:
    def isMiddleElementUnique(self, nums: list[int]) -> bool:
        
        mid = len(nums) // 2

        return nums.count(nums[mid]) == 1