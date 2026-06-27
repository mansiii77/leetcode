import java.util.*;

class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> freq = new HashMap<>();

        for (int x : nums) {
            freq.put((long) x, freq.getOrDefault((long) x, 0) + 1);
        }

        int ans = 1;

        // Special case for 1
        if (freq.containsKey(1L)) {
            int cnt = freq.get(1L);
            ans = Math.max(ans, (cnt % 2 == 0) ? cnt - 1 : cnt);
        }

        for (long start : freq.keySet()) {
            if (start == 1) continue;

            long cur = start;
            int len = 0;

            while (true) {
                Integer cnt = freq.get(cur);
                if (cnt == null) break;

                // Can continue only if current has >=2 copies
                // AND next square exists.
                if (cnt >= 2) {
                    if (cur > 1000000000L || cur > Long.MAX_VALUE / cur)
                        break;

                    long next = cur * cur;

                    if (freq.containsKey(next)) {
                        len += 2;
                        cur = next;
                        continue;
                    }
                }

                // Current becomes the center
                len++;
                break;
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}