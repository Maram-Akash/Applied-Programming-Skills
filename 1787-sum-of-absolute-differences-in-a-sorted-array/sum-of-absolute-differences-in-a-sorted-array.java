class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            int leftSum = 0;
            int rightSum = 0;   
            if (i > 0) {
                leftSum = nums[i] * i - prefix[i - 1];
            }
            rightSum = (prefix[n - 1] - prefix[i]) - nums[i] * (n - i - 1);
            result[i] = leftSum + rightSum;
        }
        return result;
    }
}
