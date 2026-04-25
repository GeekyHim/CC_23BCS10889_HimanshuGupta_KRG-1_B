public class question1 {
    // Recursive function 
    public static int uniquePaths(int m, int n, int[][] dp) {
        // Base case
        if (m == 1 || n == 1) {
            return 1;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        dp[m][n] = uniquePaths(m - 1, n, dp) + uniquePaths(m, n - 1, dp);

        return dp[m][n];
    }

    public static void main(String[] args) {
        int m = 3; // rows
        int n = 2; // columns

        // DP array initialization
        int[][] dp = new int[m + 1][n + 1];

        // Fill with -1 (means not computed)
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        int result = uniquePaths(m, n, dp);

        System.out.println("Number of unique paths: " + result);
    }
}