// Last updated: 7/15/2026, 3:21:31 PM
1class Solution {
2    public int singleNonDuplicate(int[] nums) {
3
4        int low = 0;
5        int high = nums.length - 1;
6
7        while (low < high) {
8
9            int mid = low + (high - low) / 2;
10
11            // Make mid even
12            if (mid % 2 == 1) {
13                mid--;
14            }
15
16            if (nums[mid] == nums[mid + 1]) {
17                low = mid + 2;
18            } else {
19                high = mid;
20            }
21        }
22
23        return nums[low];
24    }
25}