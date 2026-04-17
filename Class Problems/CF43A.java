import java.util.*;

public class CF43A {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            String s = sc.next();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        String ans = "";
        int max = 0;

        for(String key : map.keySet()){
            if(map.get(key) > max){
                max = map.get(key);
                ans = key;
            }
        }

        System.out.println(ans);
    }
}