package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 *
 * @author hzzhou
 * @since 2023-11-09
 */
class Alg00118 {

    public static void main(String[] args) {
        int grid = 5;
        Alg00118 alg = new Alg00118();
        System.out.println(alg.generate(grid));
    }


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            System.out.print("i=" + i + "  ");
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                System.out.print("j=" + j + "  ");
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            System.out.print("i=" + i + "  ");
            System.out.println();

            result.add(row);
        }
        return result;
        // 结果证明：for循环里的 ++i和i++没有区别。深究一下为什么？已解决https://blog.csdn.net/github_37847975/article/details/77369851
    }

}
