class Solution {
    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        String result = "";

        for (int i = 0; i < s1.length; i++) {
            StringBuilder str = new StringBuilder(s1[i]);
            if (s1.length-1 != i) {
                result += str.reverse().toString() + " ";
            } else {
                result += str.reverse().toString();
            }
        }
        return result;
    }
}