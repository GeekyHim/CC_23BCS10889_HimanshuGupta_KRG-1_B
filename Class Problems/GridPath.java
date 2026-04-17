import java.util.*;

public class GridPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        char[][] arr = new char[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.next().charAt(0);
            }
        }

        final int MOD = (int)1e9 + 7;

        int[][] dp = new int[n][n];

        if(arr[0][0] == '.') {
            dp[0][0] = 1;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

                if(arr[i][j] == '*') {
                    dp[i][j] = 0;
                    continue;
                }

                if(i == 0 && j == 0) continue;

                int up = (i > 0) ? dp[i - 1][j] : 0;
                int left = (j > 0) ? dp[i][j - 1] : 0;

                dp[i][j] = (up + left) % MOD;
            }
        }

        System.out.println(dp[n - 1][n - 1]);

        sc.close();
    }
}