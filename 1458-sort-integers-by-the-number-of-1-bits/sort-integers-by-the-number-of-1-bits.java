class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] nums = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }

        Arrays.sort(nums, (a, b) -> {
            int bitcompare = Integer.compare(Integer.bitCount(a), Integer.bitCount(b));
            if (bitcompare != 0) {
                return bitcompare;
            }
            return Integer.compare(a, b);
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }
        return arr;
    }
}