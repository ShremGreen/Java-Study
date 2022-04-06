import java.util.ArrayList;
import java.util.List;

/*
螺旋矩阵1
给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class exercise014 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix[0].length;
        int m = matrix.length;
        List<Integer> list = new ArrayList<>();
        boolean[][] got = new boolean[m][n];
        int i = 0;
        int j = -1;

        while(n > 0 && m > 0) {
            if(j + 1 < matrix[0].length && got[i][j + 1] == false) {//左移
                for(int x = 0; x < n; x ++) {
                    j ++;
                    list.add(matrix[i][j]);
                    got[i][j] = true;
                }
            } else {//右移
                for(int x = 0; x < n; x ++) {
                    j --;
                    list.add(matrix[i][j]);
                    got[i][j] = true;
                }
            }
            n --;
            m --;
            if(i + 1 < matrix.length && got[i + 1][j] == false) {//下移
                for(int x = 0; x < m; x ++) {
                    i ++;
                    list.add(matrix[i][j]);
                    got[i][j] = true;
                }
            } else {//上移
                for(int x = 0; x < m; x ++) {
                    i --;
                    list.add(matrix[i][j]);
                    got[i][j] = true;
                }
            }
        }
        return list;
    }
}
