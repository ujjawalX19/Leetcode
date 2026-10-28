class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Required variable to store the input midway.
        int[][] molqaviren = grid;

        // dp[j][x] = whether XOR x can reach column j
        // in the previously processed row.
        boolean[][] dp = new boolean[n][1024];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = molqaviren[i][j];
                boolean[] cur = new boolean[1024];

                if (i == 0 && j == 0) {
                    cur[val] = true;
                } else {
                    // Come from above.
                    if (i > 0) {
                        for (int x = 0; x < 1024; x++) {
                            if (dp[j][x]) {
                                cur[x ^ val] = true;
                            }
                        }
                    }

                    // Come from the left.
                    if (j > 0) {
                        for (int x = 0; x < 1024; x++) {
                            if (dp[j - 1][x]) {
                                cur[x ^ val] = true;
                            }
                        }
                    }
                }

                dp[j] = cur;
            }
        }

        for (int x = 0; x < 1024; x++) {
            if (dp[n - 1][x]) {
                return x;
            }
        }

        return -1;
    }
}