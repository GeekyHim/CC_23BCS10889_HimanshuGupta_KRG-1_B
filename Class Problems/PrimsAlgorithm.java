import java.util.*;

public class PrimsAlgorithm {

    static class Pair {
        int node, wt;
        Pair(int n, int w){
            node = n;
            wt = w;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int i = 0; i < m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        boolean[] vis = new boolean[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.wt-b.wt);

        pq.add(new Pair(0, 0));
        int sum = 0;

        while(!pq.isEmpty()){
            Pair cur = pq.poll();

            if(vis[cur.node]) continue;

            vis[cur.node] = true;
            sum += cur.wt;

            for(Pair nei : adj.get(cur.node)){
                if(!vis[nei.node]){
                    pq.add(new Pair(nei.node, nei.wt));
                }
            }
        }

        System.out.println(sum);
    }
}