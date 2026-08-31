// Last updated: 8/31/2026, 10:01:22 PM
1class Solution {
2    public int[] nodesBetweenCriticalPoints(ListNode head) {
3        List<Integer> nums = new ArrayList<>();
4
5        while(head != null){
6            nums.add(head.val);
7            head = head.next;
8        }
9
10        List<Integer> criticalPoints = new ArrayList<>();
11
12        int n = nums.size();
13
14        for(int i = 1; i < n - 1; i++){
15            if(nums.get(i) > nums.get(i - 1) && nums.get(i) > nums.get(i + 1)){
16                criticalPoints.add(i);
17            }
18            else if(nums.get(i) < nums.get(i - 1) && nums.get(i) < nums.get(i + 1)){
19                criticalPoints.add(i);
20            }
21        }
22
23        int m = criticalPoints.size();
24
25        if(m < 2){
26            return new int[]{-1, -1};
27        }
28
29        int minDist = Integer.MAX_VALUE;
30
31        int maxDist = criticalPoints.get(m - 1) - criticalPoints.get(0);
32
33        for(int i = 1; i < m; i++){
34            minDist = Math.min(
35                minDist,
36                criticalPoints.get(i) - criticalPoints.get(i - 1)
37            );
38        }
39
40        return new int[]{minDist, maxDist};
41    }
42}