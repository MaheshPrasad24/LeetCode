import java.util.Arrays;

class Solution {

    public int maxProduct(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;

        int first = nums[n - 1];

        int second = nums[n - 2];

        return (first - 1) * (second - 1);
    }
}