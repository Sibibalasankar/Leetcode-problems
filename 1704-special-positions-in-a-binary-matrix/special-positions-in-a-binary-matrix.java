class Solution {
    public int numSpecial(int[][] mat) {
        int[] rowcount = new int[mat.length];
        int[] colcount = new int[mat[0].length];
        int count=0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    rowcount[i]++;
                    colcount[j]++;
                }
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j]==1 && rowcount[i] == 1 && colcount[j]==1){
                    count++;
                }
            }
        }
        return count;
    }
}