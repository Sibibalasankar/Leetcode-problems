// Last updated: 7/8/2026, 5:03:09 PM
class Solution {
    public int maxNumberOfBalloons(String text) {
        char[] arr = text.toCharArray();
        int ans = 0;

        while (true) {
            String word = "balloon";

            for (char c : word.toCharArray()) {
                boolean found = false;

                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] == c) {
                        arr[i] = '#';
                        found = true;
                        break;
                    }
                }

                if (!found) return ans;
            }

            ans++;
        }
    }
}