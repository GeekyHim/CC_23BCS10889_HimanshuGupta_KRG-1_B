import java.util.*;

public class C812 {

    static long[] a;
    static int n;
    static long S;

    static Pair check(int k){
        long[] cost = new long[n+1];
        for(int i = 1; i <= n; i++)
            cost[i] = a[i] + (long)i * k;

        Arrays.sort(cost, 1, n+1);

        long total = 0;
        for(int i = 1; i <= k; i++) total += cost[i];

        return new Pair(total <= S, total);
    }

    static class Pair {
        boolean ok;
        long val;
        Pair(boolean ok, long val){
            this.ok = ok;
            this.val = val;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        S = sc.nextLong();

        a = new long[n+1];
        for(int i = 1; i <= n; i++) a[i] = sc.nextLong();

        int lo = 0, hi = n;

        while(lo < hi){
            int mid = (lo + hi + 1) / 2;
            if(check(mid).ok) lo = mid;
            else hi = mid - 1;
        }

        System.out.println(lo + " " + check(lo).val);
    }
}