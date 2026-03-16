import java.util.*;

public class TopSortBFS {

    static void topoSort(int V, ArrayList<ArrayList<Integer>> adj){

        int[] indegree = new int[V];

        for(int i = 0; i < V; i++){
            for(int neighbor : adj.get(i)){
                indegree[neighbor]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < V; i++){
            if(indegree[i] == 0)
                q.add(i);
        }

        while(!q.isEmpty()){

            int node = q.poll();
            System.out.print(node + " ");

            for(int neighbor : adj.get(node)){
                indegree[neighbor]--;

                if(indegree[neighbor] == 0){
                    q.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args){

        int V = 6;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());

        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        topoSort(V, adj);
    }
}