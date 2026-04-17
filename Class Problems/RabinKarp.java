import java.util.*;

public class RabinKarp {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String text = sc.next();
        String pattern = sc.next();

        int n = text.length(), m = pattern.length();
        int base = 31, mod = (int)1e9+7;

        long hashP = 0, hashT = 0, power = 1;

        for(int i = 0; i < m; i++){
            hashP = (hashP * base + pattern.charAt(i)) % mod;
            hashT = (hashT * base + text.charAt(i)) % mod;
            if(i > 0) power = (power * base) % mod;
        }

        for(int i = 0; i <= n - m; i++){
            if(hashP == hashT){
                if(text.substring(i, i+m).equals(pattern))
                    System.out.println("Match at " + i);
            }

            if(i < n - m){
                hashT = (hashT - text.charAt(i) * power % mod + mod) % mod;
                hashT = (hashT * base + text.charAt(i+m)) % mod;
            }
        }
    }
}