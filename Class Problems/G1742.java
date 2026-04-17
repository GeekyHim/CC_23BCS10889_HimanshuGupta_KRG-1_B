import java.util.*;

public class G1742 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();

            int[] a = new int[n];
            for(int i = 0; i < n; i++) a[i] = sc.nextInt();

            boolean[] used = new boolean[n];
            ArrayList<Integer> res = new ArrayList<>();

            int cur = 0;

            while(res.size() < n){
                int bestVal = cur, bestIdx = -1;

                for(int i = 0; i < n; i++){
                    if(!used[i] && (cur | a[i]) > bestVal){
                        bestVal = cur | a[i];
                        bestIdx = i;
                    }
                }

                if(bestIdx == -1) break;

                used[bestIdx] = true;
                cur = bestVal;
                res.add(a[bestIdx]);
            }

            for(int i = 0; i < n; i++)
                if(!used[i]) res.add(a[i]);

            for(int i = 0; i < n; i++){
                System.out.print(res.get(i));
                if(i + 1 < n) System.out.print(" ");
            }
            System.out.println();
        }
    }
}