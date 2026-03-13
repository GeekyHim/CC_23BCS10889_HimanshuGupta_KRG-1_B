public class Problem1 {

    public static int singleNumber(int[] nums) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int sum = 0;

            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    sum++;
                }
            }

            if (sum % 3 != 0) {
                result |= (1 << i);
            }
        }

        return result;
    }   


    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 2};
        System.out.println("TestCase 1\n" + singleNumber(nums)); 
        int [] nums2 = {0, 1, 0, 1, 0, 1, 99};
        System.out.println("TestCase 2\n" + singleNumber(nums2));    
    }
}