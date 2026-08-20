# Last updated: 8/20/2026, 10:15:13 PM
1class Solution:
2    def resultArray(self, nums: List[int]) -> List[int]:
3        A=([nums[0]], [nums[1]])
4        for x in nums[2:]:
5            A[A[0][-1]<=A[1][-1]].append(x)
6        return A[0]+A[1]        