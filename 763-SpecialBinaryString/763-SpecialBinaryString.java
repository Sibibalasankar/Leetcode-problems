// Last updated: 7/8/2026, 5:03:41 PM
class Solution {
    public String rec(String s) {
        if (s.isEmpty()) return "";
        List<String> chunks = new ArrayList<>();
        int count = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            count += (s.charAt(i) == '1') ? 1 : -1;
            if (count == 0) {
                String inner = rec(s.substring(start + 1, i));
                chunks.add("1" + inner + "0");
                start = i + 1;
            }
        }
        Collections.sort(chunks, Collections.reverseOrder());
        StringBuilder res = new StringBuilder();
        for (String c : chunks) res.append(c);
        return res.toString();
    }

    public String makeLargestSpecial(String s) {
        return rec(s);
    }
};