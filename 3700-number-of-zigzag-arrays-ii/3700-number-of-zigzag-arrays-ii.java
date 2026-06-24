class Solution {
    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        if (n == 2) {
            return (int)((long)m * (m - 1) % MOD);
        }

        int sz = 2 * m;

        long[][] T = new long[sz][sz];

        // up[i] = sum down[j] (j > i)
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                T[i][m + j] = 1;
            }
        }

        // down[i] = sum up[j] (j < i)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                T[m + i][j] = 1;
            }
        }

        long[] base = new long[sz];

        for (int i = 0; i < m; i++) {
            base[i] = m - i - 1;      // up
            base[m + i] = i;          // down
        }

        long[][] P = matPow(T, n - 2);

        long[] res = multiply(P, base);

        long ans = 0;
        for (long x : res) {
            ans = (ans + x) % MOD;
        }

        return (int) ans;
    }

    private long[][] matPow(long[][] A, long p) {
        int n = A.length;

        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }

        while (p > 0) {
            if ((p & 1) == 1) {
                res = multiply(res, A);
            }

            A = multiply(A, A);
            p >>= 1;
        }

        return res;
    }

    private long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;

        long[][] C = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] == 0) continue;

                long aik = A[i][k];

                for (int j = 0; j < n; j++) {
                    if (B[k][j] == 0) continue;

                    C[i][j] = (C[i][j] + aik * B[k][j]) % MOD;
                }
            }
        }

        return C;
    }

    private long[] multiply(long[][] A, long[] v) {
        int n = A.length;

        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            long cur = 0;

            for (int j = 0; j < n; j++) {
                cur = (cur + A[i][j] * v[j]) % MOD;
            }

            res[i] = cur;
        }

        return res;
    }
}