// Last updated: 7/8/2026, 4:58:49 PM
class Solution {
    public boolean isAdjacentDiffAtMostTwo(String s) {
        for(int i=0;i<s.length()-1;i++){
            int n1 = Character.getNumericValue(s.charAt(i));
            int n2 = Character.getNumericValue(s.charAt(i+1));
            if(Math.abs(n1-n2) > 2){
                return false;
            }
        }
        return true;
    }
}