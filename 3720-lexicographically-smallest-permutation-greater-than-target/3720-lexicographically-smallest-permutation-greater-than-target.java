class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        char[] t = target.toCharArray();

        for (int i = 0; i < t.length; i++) {
            int x = t[i] - 'a';

            if (count[x] > 0) {
                count[x]--;
            } else {
                for (int j = i; j >= 0; j--) {
                    if (j < i) {
                        count[t[j] - 'a']++;
                    }

                    for (int c = t[j] - 'a' + 1; c < 26; c++) {
                        if (count[c] > 0) {
                            StringBuilder ans = new StringBuilder();

                            for (int p = 0; p < j; p++) {
                                ans.append(t[p]);
                            }

                            ans.append((char) ('a' + c));
                            count[c]--;

                            for (int p = 0; p < 26; p++) {
                                while (count[p] > 0) {
                                    ans.append((char) ('a' + p));
                                    count[p]--;
                                }
                            }

                            return ans.toString();
                        }
                    }
                }

                return "";
            }
        }

        for (int j = t.length - 1; j >= 0; j--) {
            count[t[j] - 'a']++;

            for (int c = t[j] - 'a' + 1; c < 26; c++) {
                if (count[c] > 0) {
                    StringBuilder ans = new StringBuilder();

                    for (int p = 0; p < j; p++) {
                        ans.append(t[p]);
                    }

                    ans.append((char) ('a' + c));
                    count[c]--;

                    for (int p = 0; p < 26; p++) {
                        while (count[p] > 0) {
                            ans.append((char) ('a' + p));
                            count[p]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}