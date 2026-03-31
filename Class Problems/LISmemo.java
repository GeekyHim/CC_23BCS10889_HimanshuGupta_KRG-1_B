class LISmemo {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][n + 1];
        return solve(0, -1, nums, dp);
    }

    private int solve(int i, int prevIndex, int[] nums, Integer[][] dp) {
        if (i == nums.length) return 0;

        if (dp[i][prevIndex + 1] != null)
            return dp[i][prevIndex + 1];

        // Option 1: Skip
        int notTake = solve(i + 1, prevIndex, nums, dp);

        // Option 2: Take
        int take = 0;
        if (prevIndex == -1 || nums[i] > nums[prevIndex]) {
            take = 1 + solve(i + 1, i, nums, dp);
        }

        return dp[i][prevIndex + 1] = Math.max(take, notTake);
    }
}
