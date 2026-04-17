import java.util.*;

public class E1352 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {

            int n = sc.nextInt();

            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int[] freq = new int[n + 1];
            for(int x : a) {
                freq[x]++;
            }

            boolean[] special = new boolean[n + 1];

            for(int l = 0; l < n; l++) {
                int sum = a[l];

                for(int r = l + 1; r < n; r++) {
                    sum += a[r];

                    if(sum > n) break;

                    special[sum] = true;
                }
            }

            int ans = 0;

            for(int v = 1; v <= n; v++) {
                if(special[v]) {
                    ans += freq[v];
                }
            }

            System.out.println(ans);
        }

        sc.close();
    }
}