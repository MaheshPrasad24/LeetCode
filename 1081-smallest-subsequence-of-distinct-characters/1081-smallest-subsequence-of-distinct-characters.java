class Solution {

    public String smallestSubsequence(String s) {

        int[] count = new int[26];
        boolean[] visited = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            count[ch - 'a']--;

            if (visited[ch - 'a']) {
                continue;
            }

            while (!stack.isEmpty()
                    && stack.peek() > ch
                    && count[stack.peek() - 'a'] > 0) {

                visited[stack.pop() - 'a'] = false;
            }

            stack.push(ch);
            visited[ch - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();

        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.reverse().toString();
    }
}