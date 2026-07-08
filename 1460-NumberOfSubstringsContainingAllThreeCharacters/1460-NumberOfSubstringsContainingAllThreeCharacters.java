// Last updated: 7/8/2026, 5:02:57 PM
class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int left = 0;
        int ans = 0;
        for(int i=0;i<s.length();i++){

            count[s.charAt(i) - 'a']++;

            while(count[0] > 0 && count[1] > 0 && count[2] > 0){
                ans += s.length()-i;
                count[s.charAt(left) - 'a']--;
                left++;
            } 
        }

        return ans;
    }
}