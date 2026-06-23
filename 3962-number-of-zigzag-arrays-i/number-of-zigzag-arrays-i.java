class Solution {
    static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[] up = new long[m];
        long[] down = new long[m];

        // Length = 2 initialization
        for (int i = 0; i < m; i++) {
            up[i] = i;           // previous value < current value
            down[i] = m - 1 - i; // previous value > current value
        }

        for (int len = 3; len <= n; len++) {
            long[] nextUp = new long[m];
            long[] nextDown = new long[m];

            long[] prefDown = new long[m];
            prefDown[0] = down[0];
            for (int i = 1; i < m; i++) {
                prefDown[i] = (prefDown[i - 1] + down[i]) % MOD;
            }

            long[] suffUp = new long[m];
            suffUp[m - 1] = up[m - 1];
            for (int i = m - 2; i >= 0; i--) {
                suffUp[i] = (suffUp[i + 1] + up[i]) % MOD;
            }

            for (int i = 0; i < m; i++) {
                // To end with an UP move, previous move must be DOWN
                if (i > 0) {
                    nextUp[i] = prefDown[i - 1];
                }

                // To end with a DOWN move, previous move must be UP
                if (i < m - 1) {
                    nextDown[i] = suffUp[i + 1];
                }
            }

            up = nextUp;
            down = nextDown;
        }

        long ans = 0;

        if (n == 2) {
            for (int i = 0; i < m; i++) {
                ans = (ans + up[i] + down[i]) % MOD;
            }
            return (int) ans;
        }

        for (int i = 0; i < m; i++) {
            ans = (ans + up[i] + down[i]) % MOD;
        }

        return (int) ans;
    }
}