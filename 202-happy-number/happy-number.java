class Solution {
    public boolean isHappy(int n) {
        Set<Integer> st = new HashSet<>();
        while (!st.contains(n)) {
            st.add(n);
            n = check(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    public int check(int n) {
        int output = 0;
        while (n > 0) {
            int r = n % 10;
            output += r * r;
            n = n / 10;
        }
        return output;
    }
}