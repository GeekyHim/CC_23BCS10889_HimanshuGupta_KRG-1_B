import java.util.*;

public class A17 {

    static boolean isPrime(int n){
        if(n < 2) return false;
        for(int i = 2; i * i <= n; i++)
            if(n % i == 0) return false;
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        ArrayList<Integer> primes = new ArrayList<>();
        for(int i = 2; i <= n; i++)
            if(isPrime(i)) primes.add(i);

        HashSet<Integer> primeSet = new HashSet<>(primes);

        int cnt = 0;
        for(int i = 0; i + 1 < primes.size(); i++){
            int candidate = primes.get(i) + primes.get(i+1) + 1;
            if(candidate <= n && primeSet.contains(candidate))
                cnt++;
        }

        System.out.println(cnt >= k ? "YES" : "NO");
    }
}