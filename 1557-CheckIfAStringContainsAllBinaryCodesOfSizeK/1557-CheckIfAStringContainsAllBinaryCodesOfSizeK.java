// Last updated: 7/8/2026, 5:02:41 PM
class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            set.add(s.substring(i, i + k));
        }
        return (set.size() == Math.pow(2, k));
    }
}