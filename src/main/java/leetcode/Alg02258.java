package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author hzzhou
 * @since 2023-11-09
 */
class Alg02258 {

    public static void main(String[] args) {
        int[][] grid = {{0,2,0,0,0,0,0},{0,0,0,2,2,1,0},{0,2,0,0,1,2,0},{0,0,2,2,2,0,2},{0,0,0,0,0,0,0}};
        Alg02258 alg = new Alg02258();
        System.out.println(alg.maximumMinutes(grid));
    }


    static final int INF = 1000000000;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maximumMinutes(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] fireTime = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(fireTime[i], INF);
        }
        bfs(grid, fireTime);
        int ans = -1;
        int low = 0, high = m * n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(fireTime, grid, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans >= m * n ? INF : ans;
    }

    public void bfs(int[][] grid, int[][] fireTime) {
        int m = grid.length;
        int n = grid[0].length;
        // deque: double ended queue 双向队列
        Queue<int[]> queue = new ArrayDeque<int[]>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    fireTime[i][j] = 0;
                }
            }
        }
        int time = 1;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int[] arr = queue.poll();
                int cx = arr[0], cy = arr[1];
                for (int j = 0; j < 4; j++) {
                    int nx = cx + dirs[j][0];
                    int ny = cy + dirs[j][1];
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                        if (grid[nx][ny] == 2 || fireTime[nx][ny] != INF) {
                            continue;
                        }
                        queue.offer(new int[]{nx, ny});
                        fireTime[nx][ny] = time;
                    }
                }

            }
            time++;
        }
    }

    public boolean check(int[][] fireTime, int[][] grid, int stayTime) {
        int m = fireTime.length;
        int n = fireTime[0].length;
        boolean[][] visit = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, stayTime});
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int cx = arr[0], cy = arr[1], time = arr[2];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dirs[i][0];
                int ny = cy + dirs[i][1];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {

                    if (visit[nx][ny] || grid[nx][ny] == 2) {
                        continue;
                    }
                    if (nx == m - 1 && ny == n - 1) {
                        return fireTime[nx][ny] >= time + 1;
                    }
                    if (fireTime[nx][ny] > time + 1) {
                        queue.offer(new int[]{nx, ny, time + 1});
                        visit[nx][ny] = true;
                    }
                }

            }
        }
        return false;
    }
}
