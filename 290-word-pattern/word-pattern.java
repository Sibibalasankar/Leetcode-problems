class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if (pattern.length() != arr.length) {
            return false;
        }
        HashSet<String> set = new HashSet<>();
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = arr[i];
            if (map.containsKey(c)) {
                if (!map.get(c).equals(w)) {
                    return false;
                }
            } else {
                if (set.contains(w)) {
                    return false;
                }
                set.add(w);
                map.put(c, w);
            }

        }
        return true;
    }
}