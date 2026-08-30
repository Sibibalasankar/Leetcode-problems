// Last updated: 8/30/2026, 9:37:29 PM
1class Solution {
2    public int minimumDeletions(int[] nums) {
3        int n = nums.length;
4
5        int minIndex = 0, maxIndex = 0;
6
7        for(int i = 0; i < n; i++){
8            if(nums[i] < nums[minIndex]) minIndex = i;
9            if(nums[i] > nums[maxIndex]) maxIndex = i;
10        }
11
12        int left = Math.min(minIndex, maxIndex);
13        int right = Math.max(minIndex, maxIndex);
14
15        // Remove both from the front
16        int front = right + 1;
17
18        // Remove both from the back
19        int back = n - left;
20
21        // Remove one from each side
22        int frontBack = (left + 1) + (n - right);
23
24        return Math.min(front, Math.min(back, frontBack));
25    }
26}