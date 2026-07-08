// Last updated: 7/8/2026, 5:00:29 PM
class Solution {
    public int numberOfSpecialChars(String w) {
        int x = 0;
        Set<Character> a = new HashSet<>(), b = new HashSet<>();

        for (char c : w.toCharArray())
            if (Character.isLowerCase(c)) a.add(c);
            else b.add(Character.toLowerCase(c));
        for (char c : a)
            if (b.contains(c)) x++;

        return x;
    }
}