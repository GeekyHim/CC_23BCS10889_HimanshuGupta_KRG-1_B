import java.util.Scanner;

public class B1841 {
     public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){
            int n = scn.nextInt();
            StringBuilder sb = new StringBuilder();
            int [] arr = new int[n];
            arr[0] = scn.nextInt();
            int first = arr[0];
            sb.append(1);
            boolean flag = true;
            int curr = first;
            for(int i=1;i<n;i++){
                arr[i] = scn.nextInt();
                if(arr[i]>=curr && flag) {
                    sb.append(1);
                    curr = arr[i];
                }

                else {
                    if(flag && arr[i]<=first) {
                        sb.append(1);
                        curr = arr[i];
                        flag = false;
                    }
                    else if(arr[i]<=first && arr[i]>=curr) {
                        sb.append(1);
                        curr = arr[i];
                    }
                    else sb.append(0);
                } 
            }
            System.out.println(sb);
        }
        scn.close();
    }
}

// public class B1841 {
//      public static void main(String[] args) {
//         Scanner scn = new Scanner(System.in);
//         int t = scn.nextInt();
//         long ans;
//         while(t-- > 0){
//             int n = scn.nextInt();
//             StringBuilder sb = new StringBuilder();
//             int [] arr = new int[n];
//             boolean flag1 = true, flag2 = true, flag3 =true;
//             arr[0] = scn.nextInt();
//             int first = arr[0];
//             sb.append(1);
      
//         boolean flag = true;
//         int curr = first;
//             for(int i=1;i<n;i++){
//                 arr[i] = scn.nextInt();
//                 if(arr[i]>=curr && flag) {
//                     sb.append(1);
//                     curr = arr[i];
//                 }

//                 else {
//                     if(flag && arr[i]<=first) {
//                         sb.append(1);
//                         curr = arr[i];
//                         flag = false;
//                     }
//                     else if(arr[i]<=first && arr[i]>=curr) {
//                         sb.append(1);
//                         curr = arr[i];
//                     }
//                     else sb.append(0);
//                 } 
//             }
//             System.out.println(sb);
//         }

//     }
// }


  //     for(int i=1;i<n;i++){
        //         arr[i] = scn.nextInt();
        //         if(flag3 && arr[i]<arr[i-1]) flag1 = false;
        //         if(!flag1){
        //             if(arr[i]>arr[0]) flag2 = false;
        //         }
        //         if(flag2) {sb.append(1); flag3=false;}
        //         else {
        //             sb.append(0);
                    
        //         }
        //         flag2 = true;
        //     }
        //     System.out.println(sb);
        // }

// package Sheet;

// import java.util.Scanner;

// public class B1841 {
//      public static void main(String[] args) {
//         Scanner scn = new Scanner(System.in);
//         int t = scn.nextInt();
//         long ans;
//         while(t-- > 0){
//             int n = scn.nextInt();
//             StringBuilder sb = new StringBuilder();
//             int [] arr = new int[n];
//             boolean flag1 = true, flag2 = true,flag3 =true;
//             arr[0] = scn.nextInt();
//             for(int i=1;i<n;i++){
//                 arr[i] = scn.nextInt();
//                 if(flag3 && arr[i]<arr[i-1]) flag1 = false;
//                 if(!flag1){
//                     if(arr[i]>arr[0]) flag2 = false;
//                 }
//                 if(flag2) {
//                     sb.append(1);
//                     flag3 = false;
//                 }
//                 else {
//                     sb.append(0);
//                 }
//                 flag2 = true;
//             }
//             System.out.println(sb);
//         }
//     }
// }
