class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        // Process subarrays from right to left (bottom-up)
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = nums[i]; // Subarray of length 1: player gets nums[i] points
            for (int j = i + 1; j < n; j++) {
                // Choice 1 (pick nums[i]): nums[i] - opponent's max score from subarray [i+1, j] (currently dp[j])
                // Choice 2 (pick nums[j]): nums[j] - opponent's max score from subarray [i, j-1] (currently dp[j-1])
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }

        // dp[n - 1] stores the max score advantage Player 1 can guarantee for subarray [0, n - 1]
        return dp[n - 1] >= 0;
    }
}
