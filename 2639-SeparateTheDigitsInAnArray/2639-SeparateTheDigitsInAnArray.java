// Last updated: 7/8/2026, 5:01:12 PM
class Solution {
    public int[] separateDigits(int[] nums) {
        
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {

            String s = String.valueOf(num);

            for (char ch : s.toCharArray()) {

                list.add(ch - '0');
            }
        }

        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}