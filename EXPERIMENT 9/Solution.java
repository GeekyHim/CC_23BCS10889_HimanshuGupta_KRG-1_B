class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        
        // Step 1: LCS DP table
        int[][] dp = new int[n + 1][m + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        
        // Step 2: Build SCS from dp table
        StringBuilder result = new StringBuilder();
        int i = n, j = m;
        
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                result.append(str1.charAt(i - 1));
                i--; j--;
            } 
            else if (dp[i - 1][j] > dp[i][j - 1]) {
                result.append(str1.charAt(i - 1));
                i--;
            } 
            else {
                result.append(str2.charAt(j - 1));
                j--;
            }
        }
        
        // Add remaining characters
        while (i > 0) result.append(str1.charAt(--i));
        while (j > 0) result.append(str2.charAt(--j));
        
        return result.reverse().toString();
    }
}