import java.util.*;

public class L1468 {

    static HashSet<Integer> primeFactors(int n){
        HashSet<Integer> res = new HashSet<>();
        for(int p = 2; (long)p * p <= n; p++){
            if(n % p == 0){
                res.add(p);
                while(n % p == 0) n /= p;
            }
        }
        if(n > 1) res.add(n);
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0){
            int k = sc.nextInt();

            int[] a = new int[k];
            for(int i = 0; i < k; i++) a[i] = sc.nextInt();

            HashMap<Integer,Integer> primeCnt = new HashMap<>();

            for(int x : a){
                HashSet<Integer> factors = primeFactors(x);
                for(int p : factors){
                    primeCnt.put(p, primeCnt.getOrDefault(p, 0) + 1);
                }
            }

            boolean ideal = true;

            for(int cnt : primeCnt.values()){
                if(cnt == 1){
                    ideal = false;
                    break;
                }
            }

            System.out.println(ideal ? "Ideal" : "Not ideal");
        }
    }
}