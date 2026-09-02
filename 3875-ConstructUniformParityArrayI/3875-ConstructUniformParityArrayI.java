// Last updated: 9/2/2026, 9:31:29 PM
1class Solution {
2    public boolean uniformArray(int[] nums1) {
3        int n = nums1.length;
4        boolean odd = true, even = true;
5
6        for(int i=0; i<n; i++){
7            if(nums1[i]%2==0){
8                // check for odd
9                boolean valid = false;
10                for(int j=0; j<n; j++){
11                    if(i!=j && Math.abs(nums1[i]-nums1[j])%2==1){
12                        valid = true;
13                    }
14                }
15                if(!valid) odd = false;
16            }
17            else {
18                // check for even
19                boolean valid = false;
20                for(int j=0; j<n; j++){
21                    if(i!=j && Math.abs(nums1[i]-nums1[j])%2==0){
22                        valid = true;
23                    }
24                }
25                if(!valid) even = false;
26            }
27        }
28
29        return odd | even;
30    }
31}