package week;

import java.util.HashSet;
import java.util.Set;

public class P100185 {
    class Solution {
        public int maximumLength(String s) {
            int maxLength = -1;
            int n = s.length();

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    String sub = s.substring(i, j);
                    if(!isSpecialSubstring(sub)){
                        break;
                    }
                    if (countOccurrences(s, sub) >= 3) {
                        System.out.println("sub = " + sub);
                        maxLength = Math.max(maxLength, sub.length());
                    }
                }
            }

            return maxLength;
        }
        private boolean isSpecialSubstring(String sub) {
            int n = sub.length();

            for (int i = 0; i < n - 1; i++) {
                if (sub.charAt(i) != sub.charAt(i + 1)) {
                    return false;
                }
            }

            return true;
        }
        private int countOccurrences(String s, String sub) {
            int count = 0;
            int index = s.indexOf(sub);

            while (index != -1) {
                count++;
                index = s.indexOf(sub, index + 1);
            }

            return count;
        }
    }
}
