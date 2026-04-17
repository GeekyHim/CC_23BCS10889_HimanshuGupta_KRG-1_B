import java.util.*;

public class TSP {

    static int n;
    static int[][] dist;
    static int[][] dp;

    static int solve(int mask, int pos){
        if(mask == (1<<n) - 1) return dist[pos][0];

        if(dp[mask][pos] != -1) return dp[mask][pos];

        int ans = Integer.MAX_VALUE;

        for(int city = 0; city < n; city++){
            if((mask & (1<<city)) == 0){
                int cost = dist[pos][city] +
                        solve(mask | (1<<city), city);
                ans = Math.min(ans, cost);
            }
        }

        return dp[mask][pos] = ans;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        dist = new int[n][n];

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                dist[i][j] = sc.nextInt();

        dp = new int[1<<n][n];
        for(int[] row : dp) Arrays.fill(row, -1);

        System.out.println(solve(1, 0));
    }
}