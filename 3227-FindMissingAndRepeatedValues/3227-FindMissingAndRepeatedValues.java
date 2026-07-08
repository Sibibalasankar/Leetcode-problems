// Last updated: 7/8/2026, 5:00:48 PM
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] freq = new int[(grid.length * grid.length)+1];

        for(int[] row:grid){
            for(int num:row){
                freq[num]++;
            }
        }

        int[] ans = new int[2];

        for(int i=1;i<(grid.length * grid.length)+1;i++){
            if(freq[i] == 2){
                ans[0] = i;
            }
            
            if(freq[i] == 0){
                ans[1] = i;
            }
            
        }
        return ans;
    }
}