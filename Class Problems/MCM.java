import java.util.*;

public class MCM {

    static int solve(int[] arr, int i, int j, int[][] dp) {

        if(i == j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int ans = (int)1e9;

        for(int k = i; k < j; k++) {

            int steps = arr[i - 1] * arr[k] * arr[j]
                    + solve(arr, i, k, dp)
                    + solve(arr, k + 1, j, dp);

            if(steps < ans) ans = steps;
        }

        return dp[i][j] = ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        // from 1 to avoid arr[-1]
        int ans = solve(arr, 1, n - 1, dp);

        System.out.println(ans);

        sc.close();
    }
}