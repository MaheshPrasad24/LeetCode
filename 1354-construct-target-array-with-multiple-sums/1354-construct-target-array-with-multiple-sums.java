import java.util.*;

class Solution {

    public boolean isPossible(int[] target) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long sum = 0;

        for (int num : target) {
            pq.offer(num);
            sum += num;
        }

        while (true) {

            int largest = pq.poll();
            long rest = sum - largest;

            if (largest == 1 || rest == 1) {
                return true;
            }

            if (rest == 0 || largest < rest || largest % rest == 0) {
                return false;
            }

            int previous = (int)(largest % rest);

            sum = rest + previous;

            pq.offer(previous);
        }
    }
}