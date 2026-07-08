// Last updated: 7/8/2026, 5:02:20 PM
class Solution {
    public int largestAltitude(int[] gain) {
        int[] res = new int[gain.length+1];
        for(int i=0;i<gain.length;i++){
            res[i+1] = res[i] +gain[i];
        }
        int max = res[0];
        for(int i:res){
            max = Math.max(max,i);
        }
        return max;
    }
}