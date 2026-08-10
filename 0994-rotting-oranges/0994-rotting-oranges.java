class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int col = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int m = 0;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        if (fresh == 0)
            return 0;
        while (!q.isEmpty() && fresh > 0) {
            m++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] node = q.poll();
                int r = node[0];
                int c = node[1];
                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < col && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        q.offer(new int[] { nr, nc });
                    }
                }
            }
        }
        return fresh == 0?m:-1;
    }
}