import java.util.ArrayList;
import java.util.Scanner;

public class A305 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] arr = new int[n];

        ArrayList<Integer> with0 = new ArrayList<>();
        ArrayList<Integer> without0 = new ArrayList<>();

        int count0 = 0, count = 0, temp;

        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
            temp = arr[i]/10;
            if(temp*10 == arr[i]) {
                with0.add(arr[i]);
                count0++;
            }
            else {
                count++;
                without0.add(arr[i]);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        if(count0>=count) {
            count0 -= count;
            list.addAll(without0);
            list.addAll(with0);
            if(count0%2==1) list.removeLast();
        }
        else{
            list.addAll(with0);
            int idx = 0;
            while(idx < count0) list.add(without0.get(idx++));
        }
        System.out.println(list.size());
        for(int x : list){
            System.out.print(x+" ");
        }
    }
}
