// Last updated: 7/8/2026, 5:04:33 PM
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr=new  int[26];
        for(char c:magazine.toCharArray()){
            arr[c-'a']++;
        }

        for(char c:ransomNote.toCharArray()){
            if(arr[c-'a'] == 0){
                return false;
            }
            arr[c-'a']--;
        }
        return true;
    }
}