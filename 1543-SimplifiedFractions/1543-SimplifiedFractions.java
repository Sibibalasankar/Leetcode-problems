// Last updated: 7/8/2026, 5:02:42 PM
class Solution {

    private int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }

    public List<String> simplifiedFractions(int n) {
        List<String> result = new ArrayList<>();
        for(int denominator = 2; denominator <= n; denominator++) {
            for(int numerator = 1; numerator <= denominator; numerator++) {
                if(gcd(numerator, denominator) == 1) result.add(numerator + "/" + denominator);
            }
        }
        return result;
    }
}