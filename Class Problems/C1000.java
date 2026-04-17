import java.util.*;

public class C1000 {

    static class Pair {
        long x;
        int d;

        Pair(long x, int d) {
            this.x = x;
            this.d = d;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Pair> events = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            long l = sc.nextLong();
            long r = sc.nextLong();

            events.add(new Pair(l, 1));
            events.add(new Pair(r + 1, -1));
        }

        Collections.sort(events, (a, b) -> Long.compare(a.x, b.x));

        long ans = 0;
        int cur = 0;
        long prev = 0;
        boolean first = true;

        for(Pair p : events) {
            long x = p.x;
            int d = p.d;

            if(!first && cur > 0) {
                ans += (x - prev) * cur;
            }

            cur += d;
            prev = x;
            first = false;
        }

        System.out.println(ans);

        sc.close();
    }
}