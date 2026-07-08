// Last updated: 7/8/2026, 5:04:23 PM
class Solution {

    public boolean isvalid(String s, String p) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        for (char ch : p.toCharArray()) {
            freq[ch - 'a']--;
        }
        for (int x : freq) {
            if (x != 0) return false;
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> l = new ArrayList<>();
        if (s.length() < p.length()) return l;
        for (int i = 0; i <= s.length() - p.length(); i++) {
        String dup = s.substring(i, i + p.length());

        if (isvalid(dup, p)) {
                l.add(i);
            }
        }

        return l;
    }
}