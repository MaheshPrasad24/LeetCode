public class Solution {
    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int m = n / 2;
        int INF = k + 1;

        int[][] C = new int[m + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            C[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                long sum = (long) C[i - 1][j - 1] + C[i - 1][j];
                C[i][j] = (int) Math.min((long) INF, sum);
            }
        }

        int[] totalFreq = new int[26];
        for (char c : s.toCharArray()) {
            totalFreq[c - 'a']++;
        }

        int[] halfFreq = new int[26];
        char midChar = 0;
        for (int i = 0; i < 26; i++) {
            if (totalFreq[i] % 2 != 0) {
                midChar = (char) ('a' + i);
            }
            halfFreq[i] = totalFreq[i] / 2;
        }

        long totalWays = countWays(halfFreq, m, C, INF);
        if (totalWays < k) {
            return "";
        }

        StringBuilder firstHalf = new StringBuilder();
        int remLen = m;

        for (int i = 0; i < m; i++) {
            for (int c = 0; c < 26; c++) {
                if (halfFreq[c] > 0) {
                    halfFreq[c]--;
                    long ways = countWays(halfFreq, remLen - 1, C, INF);

                    if (k <= ways) {
                        firstHalf.append((char) ('a' + c));
                        remLen--;
                        break;
                    } else {
                        k -= ways;
                        halfFreq[c]++;
                    }
                }
            }
        }

        String half = firstHalf.toString();
        String revHalf = firstHalf.reverse().toString();

        if (n % 2 != 0) {
            return half + midChar + revHalf;
        } else {
            return half + revHalf;
        }
    }

    private long countWays(int[] freq, int length, int[][] C, int INF) {
        long ways = 1;
        int rem = length;

        for (int count : freq) {
            if (count == 0) continue;
            ways = ways * C[rem][count];
            if (ways >= INF) {
                return INF;
            }
            rem -= count;
        }

        return ways;
    }
}