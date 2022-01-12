package SparseArray;

import org.junit.Test;
//稀疏数组
//稀疏数组
/*
稀疏数组和普通数组的转换
 */
public class SparseArrayDemo1 {
    @Test
    //格式化输出格式
    public void formattedOutput() {
        double d = 345.678;
        String s = "Hello!";
        int i = 1234;
        //"%"表示进行格式化输出，"%"之后的内容为格式的定义。
        System.out.printf("%f",d);//"f"表示格式化输出浮点数
        System.out.printf("%9.2f",d);//"9.2"中的9表示输出的长度，2表示小数点后的位数。
        System.out.printf("%+9.2f",d);//"+"表示输出的数帯正负号。
        System.out.printf("%-9.4f",d);//"-"表示输出的数左对齐（认为右对齐）。
        System.out.printf("%+-9.3f",d);//"+-"表示输出的数帯正负号且左对齐。
        System.out.printf("%d",i);//"d"表示输出十进制整数。
        System.out.printf("%o",i);//"o"表示输出八进制整数。
        System.out.printf("%x",i);//"d"表示输出十六进制整数。
        System.out.printf("%#x",i);//"d"表示输出帯有十六进制标志的整数
        System.out.printf("%s",s);//"d"表示输出字符串。
        System.out.printf("输出一个浮点数: %f,一个整数: %d,一个字符串: %s",d,i,s);//可以输出多个变量，注意顺序。
        System.out.printf("字符串: %2$s,%1$d的十六进制数：%1$#x",i,s);//"X"表示第几个变量。
    }

    @Test
    //将数组转为稀疏数组
    public void sparseArray() {
        //1.列出数组
        int[][] arr = new int[11][11];
        arr[0][3] = 22;
        arr[0][10] = -1;
        arr[1][1] = 36;
        arr[3][9] = -62;
        arr[7][0] = 3;
        arr[9][7] = 98;
        arr[10][3] = 65;

        //2.统计非零元素
        int sum = 0;
        for(int[] tempArr : arr) {
            for(int i : tempArr) {
                System.out.printf("%d\t",i);
                if(i != 0) {
                    sum ++;
                }
            }
            System.out.println();
        }
        System.out.println("sum = " + sum);

        //3.创建稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][2] = sum;
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;

        //4.遍历原数组并列出稀疏数组
        int count = 1;
        for(int i = 0; i < 11; i ++) {
            for(int j = 0; j < 11; j ++) {
                if(arr[i][j] != 0) {
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = arr[i][j];
                    count ++;
                }
            }
        }
        for(int[] tempArr : sparseArr) {
            System.out.printf("%d\t%d\t%d\n",tempArr[0],tempArr[1],tempArr[2]);
        }
    }
}
