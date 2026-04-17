import java.util.*;

public class F1742 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0){
            int q = sc.nextInt();

            HashMap<Character, Long> scnt = new HashMap<>();
            HashMap<Character, Long> tcnt = new HashMap<>();

            scnt.put('a', 1L);
            tcnt.put('a', 1L);

            long sLen = 1, tLen = 1;

            while(q-- > 0){
                int type = sc.nextInt();
                long k = sc.nextLong();
                String x = sc.next();

                if(type == 1){
                    for(char c : x.toCharArray())
                        scnt.put(c, scnt.getOrDefault(c, 0L) + k);
                    sLen += k * x.length();
                } else {
                    for(char c : x.toCharArray())
                        tcnt.put(c, tcnt.getOrDefault(c, 0L) + k);
                    tLen += k * x.length();
                }

                char sMin = 'z', tMax = 'a';

                for(char c : scnt.keySet())
                    if(scnt.get(c) > 0) sMin = (char)Math.min(sMin, c);

                for(char c : tcnt.keySet())
                    if(tcnt.get(c) > 0) tMax = (char)Math.max(tMax, c);

                if(sMin < tMax) System.out.println("YES");
                else if(sMin > tMax) System.out.println("NO");
                else System.out.println(sLen < tLen ? "YES" : "NO");
            }
        }
    }
}