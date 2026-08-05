import java.util.*;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        // Store which methods are called by each method
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] x : invocations) {
            graph.get(x[0]).add(x[1]);
        }

        // Find suspicious methods
        boolean[] suspicious = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.add(k);
        suspicious[k] = true;

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int next : graph.get(current)) {
                if (!suspicious[next]) {
                    suspicious[next] = true;
                    q.add(next);
                }
            }
        }

        // Check if a normal method calls a suspicious method
        for (int[] x : invocations) {
            int from = x[0];
            int to = x[1];

            if (!suspicious[from] && suspicious[to]) {
                // Cannot remove suspicious methods
                List<Integer> answer = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    answer.add(i);
                }

                return answer;
            }
        }

        // Remove suspicious methods
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                answer.add(i);
            }
        }

        return answer;
    }
}