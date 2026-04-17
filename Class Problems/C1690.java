import java.util.Scanner;

public class C1690 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        //long ans;
        // for(int test=0; test<t; test++){
            
        // }
        while(t-- >0){
            int n = scn.nextInt();
            int [] start = new int[n]; 
            int [] end = new int[n];             
            for(int i=0; i<n ; i++){
                start[i] = scn.nextInt();
            }
            for(int i=0; i<n ; i++){
                end[i] = scn.nextInt();
            }

            int [] ans = new int[n];
            ans[0] = end[0] - start[0];
            for(int i=1;i<n;i++){
                ans[i] = end[i] - Math.max(end[i-1], start[i]);
            }
            for(int x : ans){
                System.out.print(ans + " ");
            }
            System.out.println();


        }
    }
}
