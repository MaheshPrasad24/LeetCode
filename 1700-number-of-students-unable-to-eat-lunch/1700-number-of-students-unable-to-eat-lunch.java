import java.util.*;

class Solution {

    public int countStudents(int[] students, int[] sandwiches) {

        Queue<Integer> queue = new LinkedList<>();

        for (int student : students) {
            queue.offer(student);
        }

        int index = 0;
        int count = 0;

        while (!queue.isEmpty()) {

            if (queue.peek() == sandwiches[index]) {

                queue.poll();
                index++;
                count = 0;

            } else {

                queue.offer(queue.poll());
                count++;

                if (count == queue.size()) {
                    break;
                }
            }
        }

        return queue.size();
    }
}