
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class code {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] f : flights) {
            int from = f[0];
            int to = f[1];
            int price = f[2];
            graph[from].add(new int[]{to, price});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0});

        int stops = 0;

        //  k stops
        while (!q.isEmpty() && stops <= k) {

            int size = q.size();
            int[] temp = dist.clone();   

            for (int i = 0; i < size; i++) {

                int[] curr = q.poll();
                int node = curr[0];
                int cost = curr[1];

                for (int[] nei : graph[node]) {
                    int next = nei[0];
                    int price = nei[1];

                    // Relax
                    if (cost + price < temp[next]) {
                        temp[next] = cost + price;
                        q.offer(new int[]{next, temp[next]});
                    }
                }
            }

            dist = temp;   // update 
            stops++;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
