class Solution {

    public int[] shuffle(int[] nums, int n) {

        int[] answer = new int[2 * n];

        int index = 0;

        for (int i = 0; i < n; i++) {

            answer[index] = nums[i];
            index++;

            answer[index] = nums[i + n];
            index++;
        }

        return answer;
    }
}