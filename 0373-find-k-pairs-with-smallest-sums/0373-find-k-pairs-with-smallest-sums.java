import java.util.*;

class Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> ans = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (a[0] + a[1]) - (b[0] + b[1])
        );

        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }

        while (k > 0 && !pq.isEmpty()) {

            int[] pair = pq.poll();

            ans.add(Arrays.asList(pair[0], pair[1]));

            if (pair[2] + 1 < nums2.length) {
                pq.offer(new int[]{
                    pair[0],
                    nums2[pair[2] + 1],
                    pair[2] + 1
                });
            }

            k--;
        }

        return ans;
    }
}