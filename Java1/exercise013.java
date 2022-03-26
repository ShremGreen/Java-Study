import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class exercise013 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix[0].length;
        int m = matrix.length;
        List<Integer> list = new ArrayList<>();
        boolean[][] got = new boolean[m][n];
        int i = 0;
        int j = -1;

        while(n > 1 || m > 1) {
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
    @Test
    public void test() {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> integers = spiralOrder(arr);
        System.out.println(integers);
    }
}
