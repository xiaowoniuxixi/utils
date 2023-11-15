package leetcode;

import java.util.Arrays;

/**
 * @author hzzhou
 * @since 2023-11-14
 */
public class Alg01334 {
    /**
     * 方法一：Floyd 算法
     *
     * @param n
     * @param edges
     * @param distanceThreshold
     * @return
     */
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[] ans = {Integer.MAX_VALUE / 2, -1};
        int[][] mp = new int[n][n];
        // 初始化
        for (int i = 0; i < n; i++) {
            Arrays.fill(mp[i], Integer.MAX_VALUE / 2);
        }
        // 初始化有效weight
        for (int[] eg : edges) {
            int from = eg[0], to = eg[1], weight = eg[2];
            mp[from][to] = mp[to][from] = weight;
        }
        // 构造最新路径
        for (int k = 0; k < n; k++) {
            mp[k][k] = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mp[i][j] = Math.min(mp[i][j], mp[i][k] + mp[k][j]);
                }
            }
        }
        // 按distanceThreshold过滤数据
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (mp[i][j] <= distanceThreshold) {
                    cnt++;
                }
            }
            if (cnt <= ans[0]) {
                ans[0] = cnt;
                ans[1] = i;
            }
        }
        return ans[1];
    }
}
