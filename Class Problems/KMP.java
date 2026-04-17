import java.util.*;

public class KMP {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String text = sc.next();
        String pattern = sc.next();

        int n = pattern.length();
        int[] lps = new int[n];

        int j = 0;
        for(int i = 1; i < n; i++){
            while(j > 0 && pattern.charAt(i) != pattern.charAt(j))
                j = lps[j-1];

            if(pattern.charAt(i) == pattern.charAt(j)) j++;

            lps[i] = j;
        }

        j = 0;
        for(int i = 0; i < text.length(); i++){
            while(j > 0 && text.charAt(i) != pattern.charAt(j))
                j = lps[j-1];

            if(text.charAt(i) == pattern.charAt(j)) j++;

            if(j == n){
                System.out.println("Match found at index " + (i - n + 1));
                j = lps[j-1];
            }
        }
    }
}