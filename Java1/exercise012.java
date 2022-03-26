import org.junit.Test;

import java.util.Arrays;

public class exercise012 {
    public int[][] generateMatrix(int n) {
        int flag = 1;
        int i = 0;
        int j = -1;
        int[][] matrix = new int[n][n];

        while(n > 0) {
            if(j + 1 < matrix[0].length && matrix[i][j + 1] == 0) {//左移
                for(int x = 0; x < n; x ++) {
                    j ++;
                    matrix[i][j] = flag;
                    flag ++;
                }
            } else {//右移
                for(int x = 0; x < n; x ++) {
                    j --;
                    matrix[i][j] = flag;
                    flag ++;
                }
            }
            n --;
            if(i + 1 < matrix[0].length && matrix[i + 1][j] == 0) {//下移
                for(int x = 0; x < n; x ++) {
                    i ++;
                    matrix[i][j] = flag;
                    flag ++;
                }
            } else {//上移
                for(int x = 0; x < n; x ++) {
                    i --;
                    matrix[i][j] = flag;
                    flag ++;

                }
            }
        }
        return matrix;
    }

    @Test
    public void test() {
        int n = 6;
        int[][] ints = generateMatrix(n);

        for(int[] arr : ints) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
