import java.util.Scanner;

public class A1900 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){
            int n = scn.nextInt();
            scn.nextLine();
            String s = scn.nextLine();
            int consec = 0;
            int empty = 0;
//            for(int i=0;i<n;i++){
//                if(consec >= 3) {
//                    empty = 2;
//                    break;
//                }
//                if(s.charAt(i) == '.'){
//                    consec++;
//                    empty++;
//                }
//                else{
//                    consec = 0;
//                }
//            }
//            if(consec>=3){
//                empty = 2;
//            }

            for(int i=0;i<n;i++){

                if(s.charAt(i) == '.'){
                    consec++;
                    empty++;
                }
                else{
                    consec = 0;
                }

                if(consec >= 3) {
                    empty = 2;
                    break;
                }
            }


            System.out.println(empty);
        }
    }
}
