class exp8 {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            int maxVal = 0;
            
            for (int len = 1; len <= k && i - len + 1 >= 0; len++) {
                maxVal = Math.max(maxVal, arr[i - len + 1]);
                
                int prev = (i - len >= 0) ? dp[i - len] : 0;
                dp[i] = Math.max(dp[i], prev + maxVal * len);
            }
        }

        return dp[n - 1];
    }
}