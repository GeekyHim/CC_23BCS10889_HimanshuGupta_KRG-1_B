import java.util.*;

public class CF165C {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        String s = sc.next();

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        long ans = 0;

        for(char c : s.toCharArray()){
            if(c == '1') sum++;

            if(map.containsKey(sum - k)){
                ans += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        System.out.println(ans);
    }
}