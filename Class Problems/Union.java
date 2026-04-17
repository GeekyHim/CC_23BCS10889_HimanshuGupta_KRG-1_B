import java.util.*;

public class Union {

    static int[] parent = new int[1000];
    static int[] Size = new int[1000];

    static void nodeInit(int n) {
        parent[n] = n;
        Size[n] = 1;
    }

    static int find(int u) {
        if(parent[u] == u) return u;
        return parent[u] = find(parent[u]);
    }

    static void Union(int u, int v) {
        int p1 = find(u);
        int p2 = find(v);

        if(p1 != p2) {
            if(Size[p1] < Size[p2]) {
                int temp = p1;
                p1 = p2;
                p2 = temp;
            }

            parent[p2] = p1;
            Size[p1] += Size[p2];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            nodeInit(i);
        }

        for(int i = 1; i <= m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            Union(u, v);
        }

        int ans = 0;

        for(int i = 1; i <= n; i++) {
            if(parent[i] == i) ans++;   // count components
        }

        System.out.println("Total number of components : " + ans);

        sc.close();
    }
}