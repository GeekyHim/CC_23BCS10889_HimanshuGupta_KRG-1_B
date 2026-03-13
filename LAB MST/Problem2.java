import java.util.Arrays;

public class Problem2 {
    public static int bagOfTokensScore(int[] tokens, int power) {

        Arrays.sort(tokens);

        int left = 0;
        int right = tokens.length - 1;

        int score = 0;
        int maxScore = 0;

        while (left <= right) {

            if (power >= tokens[left]) {
                power -= tokens[left];
                score++;
                left++;

                maxScore = Math.max(maxScore, score);

            } else if (score > 0) {
                power += tokens[right];
                score--;
                right--;

            } else {
                break;
            }
        }

        return maxScore;
    }

    public static void main(String[] args) {
        int[] tokens = {100};
        int power = 50;
        System.out.println("TestCase 1\n" + bagOfTokensScore(tokens, power));
        int[] tokens2 = {100, 200};
        int power2 = 150;   
        System.out.println("TestCase 2\n" + bagOfTokensScore(tokens2, power2)); 
    }
}