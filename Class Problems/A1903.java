import java.util.Scanner;

public class A1903 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){
            int n = scn.nextInt();
            int k = scn.nextInt();

            int [] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = scn.nextInt();
            }

            boolean flag = true;
            if(k<2){
                for(int i=0;i<n-1;i++){
                    if(arr[i+1]<arr[i]){
                        flag = false;
                    }
                }
            }

            if(flag){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }


        }
    }
}
