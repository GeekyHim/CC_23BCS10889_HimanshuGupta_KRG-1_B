import java.util.*;

public class RoadConstruction {

    static int N = (int)1e5 + 5;
    static int[] parent = new int[N];
    static int[] sz = new int[N];

    static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void unite(int a, int b, int[] maxSizeRef) {
        a = find(a);
        b = find(b);

        if(a != b) {
            if(sz[a] < sz[b]) {
                int temp = a;
                a = b;
                b = temp;
            }

            parent[b] = a;
            sz[a] += sz[b];

            maxSizeRef[0] = Math.max(maxSizeRef[0], sz[a]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            parent[i] = i;
            sz[i] = 1;
        }

        int components = n;
        int[] maxSizeRef = new int[1];
        maxSizeRef[0] = 1;

        while(m-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(find(a) != find(b)) {
                unite(a, b, maxSizeRef);
                components--;
            }

            System.out.println(components + " " + maxSizeRef[0]);
        }

        sc.close();
    }
}
