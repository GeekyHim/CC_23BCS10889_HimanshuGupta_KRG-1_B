import java.util.*;

public class D1661 {

    static class BIT {
        int n;
        long[] t;

        BIT(int n){
            this.n = n;
            t = new long[n+2];
        }

        void upd(int i, long v){
            for(; i <= n; i += i & -i) t[i] += v;
        }

        long qry(int i){
            long s = 0;
            for(; i > 0; i -= i & -i) s += t[i];
            return s;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        long[] a = new long[n+1];
        for(int i = 1; i <= n; i++) a[i] = sc.nextLong();

        BIT B = new BIT(n);
        BIT C = new BIT(n);

        while(q-- > 0){
            int t = sc.nextInt();

            if(t == 1){
                int l = sc.nextInt(), r = sc.nextInt();
                long b = sc.nextLong(), c = sc.nextLong();

                B.upd(l, b);
                B.upd(r+1, -b);

                C.upd(l, c - (long)l*b);
                C.upd(r+1, -(c - (long)l*b));
            } else {
                int i = sc.nextInt();
                long sb = B.qry(i), scv = C.qry(i);
                System.out.println(a[i] + sb*i + scv);
            }
        }
    }
}