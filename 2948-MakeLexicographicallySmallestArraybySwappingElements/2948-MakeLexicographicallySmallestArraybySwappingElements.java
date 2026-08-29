// Last updated: 8/29/2026, 7:39:08 PM
1class Solution {
2    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
3        int n = nums.length;
4
5        int[] sorted = nums.clone();
6        Arrays.sort(sorted);
7
8        Map<Integer, List<Integer>> group = new HashMap<>();
9        Map<Integer, Integer> groupId = new HashMap<>();
10        Map<Integer, Integer> pos = new HashMap<>();
11
12        int id = 1;
13        group.computeIfAbsent(id, k -> new ArrayList<>()).add(sorted[0]);
14        groupId.put(sorted[0], id);
15
16        for(int i = 1; i < n; i++){
17            if(sorted[i] - sorted[i - 1] > limit){
18                id++;
19            }
20
21            group.computeIfAbsent(id, k -> new ArrayList<>()).add(sorted[i]);
22            groupId.put(sorted[i], id);
23        }
24
25        // Rebuild nums using the smallest
26        // available value from its group
27        for(int i = 0; i < n; i++){
28            int grp = groupId.get(nums[i]);
29            int p = pos.getOrDefault(grp, 0);
30
31            nums[i] = group.get(grp).get(p);
32            pos.put(grp, p + 1);
33        }
34
35        return nums;
36    }
37}