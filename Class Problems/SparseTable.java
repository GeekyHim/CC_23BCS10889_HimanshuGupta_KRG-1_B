import java.util.*;

public class SparseTable {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int log = 20;
        int[][] st = new int[n][log];

        for(int i = 0; i < n; i++) st[i][0] = arr[i];

        for(int j = 1; j < log; j++){
            for(int i = 0; i + (1<<j) <= n; i++){
                st[i][j] = Math.min(st[i][j-1],
                        st[i + (1<<(j-1))][j-1]);
            }
        }

        int q = sc.nextInt();

        while(q-- > 0){
            int l = sc.nextInt();
            int r = sc.nextInt();

            int len = r - l + 1;
            int j = 31 - Integer.numberOfLeadingZeros(len);

            int ans = Math.min(st[l][j],
                    st[r - (1<<j) + 1][j]);

            System.out.println(ans);
        }
    }
}