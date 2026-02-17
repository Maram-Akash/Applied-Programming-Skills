class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        int[][] pref = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pref[i+1][j+1] = pref[i][j+1] + pref[i+1][j] - pref[i][j] + mat[i][j];
            }
        }
        
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(i - k, 0);
                int c1 = Math.max(j - k, 0);
                int r2 = Math.min(i + k, m - 1);
                int c2 = Math.min(j + k, n - 1);
                
                ans[i][j] = pref[r2 + 1][c2 + 1]
                          - pref[r1][c2 + 1]
                          - pref[r2 + 1][c1]
                          + pref[r1][c1];
            }
        }
        return ans;
    }
}
