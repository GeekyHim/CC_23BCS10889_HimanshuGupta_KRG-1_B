import java.util.*;

class LISBS {
    public int lengthOfLIS(int[] nums) {
        List<Integer> tails = new ArrayList<>();

        for (int num : nums) {
            int left = 0, right = tails.size();

            // Binary search
            while (left < right) {
                int mid = (right-left)/2 +  left;
                if (tails.get(mid) < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            // Update tails
            if (left == tails.size()) {
                tails.add(num);
            } else {
                tails.set(left, num);
            }
        }

        return tails.size();
    }
}