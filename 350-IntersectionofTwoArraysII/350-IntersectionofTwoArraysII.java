// Last updated: 7/8/2026, 10:20:24 PM
1class Solution {
2    public int[] intersect(int[] nums1, int[] nums2) {
3        HashMap<Integer,Integer> map = new HashMap<>();
4
5        for(int num:nums2){
6            map.put(num,map.getOrDefault(num,0)+1);
7        }
8
9        ArrayList<Integer> list = new ArrayList<>();
10
11        for(int num:nums1){
12            if(map.getOrDefault(num ,0) > 0){
13                list.add(num);
14                map.put(num,map.get(num)-1);
15            }
16        }
17
18        int[] arr = new int[list.size()];
19
20        for(int i=0;i<arr.length;i++){
21            arr[i] = list.get(i);
22        }
23
24        return arr;
25    }
26}