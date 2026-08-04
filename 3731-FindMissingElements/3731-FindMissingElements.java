// Last updated: 8/4/2026, 9:22:37 PM
1class Solution {
2    public List<Integer> findMissingElements(int[] nums) {
3       Arrays.sort(nums);
4        List<Integer>ans=new ArrayList<>();
5        int end=nums[nums.length-1],index=0,cur=nums[0];
6        while(cur<end){
7            if(nums[index]==cur){
8                cur++;
9                index++;
10                continue;
11            }
12            else{
13                while(cur<nums[index]){
14                    ans.add(cur++);
15                }
16                index++;
17                cur++;
18            }
19        }
20        return ans;
21    }
22}   