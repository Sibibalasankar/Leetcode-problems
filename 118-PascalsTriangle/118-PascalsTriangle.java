// Last updated: 7/8/2026, 5:05:43 PM
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for(int row = 0;row<numRows;row++){
            List<Integer> currRow = new ArrayList<>();
            for(int col=0;col<=row;col++){

                if(col == 0 || col == row){
                    currRow.add(1);
                }else{
                    List<Integer> prevRow = result.get(row-1);
                    currRow.add(prevRow.get(col-1) + prevRow.get(col));
                }
            }
            result.add(currRow);
        }
        return result;
    }
}