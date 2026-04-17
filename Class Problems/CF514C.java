import java.util.*;

public class CF514C {

    static HashSet<String> set = new HashSet<>();
    static char[] letters = {'a','b','c'};

    static boolean check(String s){
        char[] arr = s.toCharArray();

        for(int i = 0; i < arr.length; i++){
            char original = arr[i];

            for(char c : letters){
                if(c == original) continue;

                arr[i] = c;
                if(set.contains(new String(arr))) return true;
            }

            arr[i] = original;
        }
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 0; i < n; i++){
            set.add(sc.next());
        }

        while(m-- > 0){
            String q = sc.next();
            System.out.println(check(q) ? "YES" : "NO");
        }
    }
}