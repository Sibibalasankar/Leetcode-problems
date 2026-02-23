class Solution {
    public boolean prime_num(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            String num = Integer.toBinaryString(i);
            int once = 0;
            for (char ch : num.toCharArray()) {
                if (ch == '1') {
                    once++;

                }
            }

            if (prime_num(once)) {
                count++;
            }

        }
        return count;
    }
}