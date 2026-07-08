// Last updated: 7/8/2026, 5:03:31 PM
class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        return (s+s).contains(goal);
    }
}