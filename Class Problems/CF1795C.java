import java.util.*;

public class CF1795C {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();

            long[] a = new long[n+1];
            long[] b = new long[n+1];

            for(int i = 1; i <= n; i++) a[i] = sc.nextLong();
            for(int i = 1; i <= n; i++) b[i] = sc.nextLong();

            long[] pref = new long[n+1];
            for(int i = 1; i <= n; i++) pref[i] = pref[i-1] + b[i];

            long[] cnt = new long[n+2];
            long[] extra = new long[n+2];

            for(int i = 1; i <= n; i++){
                long total = a[i] + pref[i-1];

                int l = i, r = n, pos = i-1;

                while(l <= r){
                    int mid = (l + r) / 2;
                    if(pref[mid] <= total){
                        pos = mid;
                        l = mid + 1;
                    } else r = mid - 1;
                }

                cnt[i]++;
                cnt[pos+1]--;

                if(pos+1 <= n){
                    extra[pos+1] += total - pref[pos];
                }
            }

            long cur = 0;

            for(int i = 1; i <= n; i++){
                cur += cnt[i];
                long ans = cur * b[i] + extra[i];
                System.out.print(ans + " ");
            }
            System.out.println();
        }
    }
}