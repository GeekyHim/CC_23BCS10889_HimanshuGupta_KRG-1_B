import java.util.Scanner;

public class A1498 {

    public static long sum(long num){
        long sum = 0;
        while(num>0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }

    public static long gcd(long a, long b){
        if(a == 0) return b;
        return gcd(b%a, a);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        long ans;
        while(t-- > 0){
            long num = scn.nextLong();
            long sum = sum(num);
            ans = gcd(num, sum);

            while(ans<=1){
                num += 1;
                sum = sum(num);
                ans = gcd(num,sum);
            }

            System.out.println(num);
        }
        
    }
}
