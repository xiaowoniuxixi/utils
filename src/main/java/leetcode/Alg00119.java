package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角 II
 *
 * @author hzzhou
 * @since 2023-11-10
 */
public class Alg00119 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> c = new ArrayList<>();
        for (int i = 0; i <= rowIndex; ++i) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add((c.get(i - 1).get(j - 1)) + c.get(i - 1).get(j));
                }
            }
            c.add(row);
        }
        return c.get(rowIndex);
    }
}
