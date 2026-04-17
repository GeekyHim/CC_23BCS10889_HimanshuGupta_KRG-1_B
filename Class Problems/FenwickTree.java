import java.util.*;

public class FenwickTree {

    static int[] bit;
    static int n;

    static void update(int i, int val){
        for(; i <= n; i += i & -i)
            bit[i] += val;
    }

    static int query(int i){
        int sum = 0;
        for(; i > 0; i -= i & -i)
            sum += bit[i];
        return sum;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        bit = new int[n+1];

        int[] arr = new int[n+1];

        for(int i = 1; i <= n; i++){
            arr[i] = sc.nextInt();
            update(i, arr[i]);
        }

        int q = sc.nextInt();

        while(q-- > 0){
            int type = sc.nextInt();

            if(type == 1){
                int i = sc.nextInt();
                int val = sc.nextInt();
                update(i, val);
            } else {
                int i = sc.nextInt();
                System.out.println(query(i));
            }
        }
    }
}