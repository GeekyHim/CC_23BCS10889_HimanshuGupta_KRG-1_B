import java.util.Scanner;

public class A1901 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){
            int n = scn.nextInt();
            int x = scn.nextInt();
            int [] arr = new int[n];

            for(int i=0; i<n;i++){
                arr[i] = scn.nextInt();
            }

            int maxGap = arr[0], gap = arr[0];

            for(int i=1; i<n;i++){
                gap = Math.abs(arr[i] - arr[i-1]);
                maxGap = Math.max(gap, maxGap);
            }

            gap = Math.abs(arr[n-1] - x) * 2;
            maxGap = Math.max(gap, maxGap);

            System.out.println(maxGap);

        }
    }
}
