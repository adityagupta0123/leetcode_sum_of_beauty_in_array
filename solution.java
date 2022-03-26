class Solution {
     public int sumOfBeauties(int[] nums) {
        int len = nums.length - 1, sum = 0;
        int[] rightMin = new int[nums.length];
        int lMax = nums[0], rMin = nums[nums.length - 1];
        for (int i = 1; i < nums.length - 1; i++) {
            rightMin[len - i] = rMin;
            if (nums[len - i] < rMin) rMin = nums[len - i];
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (lMax < nums[i] && nums[i] < rightMin[i]) {
                sum += 2;
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                sum += 1;
            }
            if (nums[i] > lMax) lMax = nums[i];
        }
        return sum;
    }
}
