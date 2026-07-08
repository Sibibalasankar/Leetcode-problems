// Last updated: 7/8/2026, 5:04:34 PM
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set=new HashSet<Integer>();
        HashSet<Integer> result=new HashSet<Integer>();
        for(int i:nums1){
            set.add(i);
        }
        for(int i:nums2){
            if(set.contains(i)){
                result.add(i);
            }
        }
        int k=0;
        int[] arr=new int[result.size()];
        for(int i:result){
            arr[k++]=i;
        }
        return arr;
    }
}