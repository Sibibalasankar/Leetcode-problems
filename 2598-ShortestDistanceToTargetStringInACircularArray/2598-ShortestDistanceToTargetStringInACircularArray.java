// Last updated: 7/8/2026, 5:01:16 PM
class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int clockwise = (i - startIndex + n) % n;
                int anticlockwise = (startIndex - i + n) % n;
                ans = Math.min(ans, Math.min(clockwise, anticlockwise));
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}