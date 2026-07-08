// Last updated: 7/8/2026, 5:03:18 PM
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> {
            if (a[0] == b[0])
                return b[1]-a[1];
            return a[0]-b[0];
        });

        int count =0;
        int maxcount = -1;

        for(int[] interval:intervals){
            if(interval[1]>maxcount){
                maxcount = interval[1];
                count++;
            }
        }
        return count;
    }
}