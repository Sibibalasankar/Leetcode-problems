// Last updated: 7/8/2026, 5:03:43 PM
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
      
        for(char c:letters){
      if(c>target){
        return c;
      }
        }
return letters[0];
     
    }
}