// Last updated: 7/8/2026, 5:03:57 PM
class Solution {
    public int countBinarySubstrings(String s) {
        int res = 0, prev = 0, strk = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) strk++;
            else {
                prev = strk;
                strk = 1;
            }
            if (strk <= prev) res++;
        }
        return res;
    }
}
