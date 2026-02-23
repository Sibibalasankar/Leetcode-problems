import  java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        Scanner sc = new Scanner(System.in);
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        Arrays.sort(sa);
        Arrays.sort(ta);  
        return  Arrays.equals(sa,ta);
    }
}