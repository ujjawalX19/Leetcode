class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int MOD = 1_000_000_007;

        int[][] right = new int[m][n];
        int[][] down = new int[m][n];

        if (m == 1 && n == 1) return 1;

        right[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    if (j + 1 < n) right[i][j + 1] = 1;
                    if (i + 1 < m) down[i + 1][j] = 1;
                    continue;
                }

                if (grid[i][j] == 1) {
                    if (i + 1 < m)
                        down[i + 1][j] = (down[i + 1][j] + right[i][j]) % MOD;

                    if (j + 1 < n)
                        right[i][j + 1] = (right[i][j + 1] + down[i][j]) % MOD;
                } else {
                    int ways = (right[i][j] + down[i][j]) % MOD;

                    if (i == m - 1 && j == n - 1)
                        return ways;

                    if (i + 1 < m)
                        down[i + 1][j] = (down[i + 1][j] + ways) % MOD;

                    if (j + 1 < n)
                        right[i][j + 1] = (right[i][j + 1] + ways) % MOD;
                }
            }
        }

        return 0;
    }
}