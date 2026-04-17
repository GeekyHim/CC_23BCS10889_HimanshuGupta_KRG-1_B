import java.util.*;

public class JobSch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {

            long s = sc.nextLong();
            long m = sc.nextLong();

            ArrayList<Integer> positions = new ArrayList<>();
            int index = 0;
            long temp = m;

            // Store set bit positions of m
            while(temp > 0) {
                if((temp & 1L) != 0) {
                    positions.add(index);
                }
                temp >>= 1;
                index++;
            }

            int i = positions.size() - 1;
            long count = 0;

            while(i >= 0 && s > 0) {

                long value = (1L << positions.get(i));

                if(value <= s) {
                    s -= value;
                    count++;
                } else {
                    i--;
                }
            }

            if(s == 0) {
                System.out.println(count);
            } else {
                System.out.println(-1);
            }
        }

        sc.close();
    }
}