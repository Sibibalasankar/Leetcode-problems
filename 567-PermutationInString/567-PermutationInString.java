// Last updated: 7/8/2026, 5:04:09 PM
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        int[] need = new int[26];
        int[] window = new int[26];

        for(int i=0;i<s1.length();i++){
            need[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(need,window)){
            return true;
        }

        for(int i=s1.length();i<s2.length();i++){
            window[s2.charAt(i) - 'a']++;
            window[s2.charAt(i-s1.length()) - 'a']--;

            if(Arrays.equals(need,window)){
                return true;
            }

        }
        return false;
    }
}