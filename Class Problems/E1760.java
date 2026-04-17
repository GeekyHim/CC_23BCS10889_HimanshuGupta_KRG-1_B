import java.util.*;

public class E1760 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();

            int[] a = new int[n];
            for(int i = 0; i < n; i++) a[i] = sc.nextInt();

            long totalOnes = 0;
            for(int x : a) totalOnes += x;

            long base = 0;
            long ones = 0;

            for(int i = 0; i < n; i++){
                if(a[i] == 0) base += ones;
                else ones++;
            }

            long ans = base;

            long ones_before = 0;

            for(int i = 0; i < n; i++){
                long ones_after = totalOnes - ones_before - a[i];
                long zeros_after = (n - i - 1) - ones_after;

                if(a[i] == 0){
                    ans = Math.max(ans, base + ones_before - ones_after);
                } else {
                    ans = Math.max(ans, base - ones_before + zeros_after);
                }

                if(a[i] == 1) ones_before++;
            }

            System.out.println(ans);
        }
    }
}