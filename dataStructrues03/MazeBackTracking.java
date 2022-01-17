package Recursion.Maze;
/*
迷宫问题
规范：
10*10迷宫，二维数组表示。
0为地面，1为墙，2为轨迹，3为死路。
移动的先后策略：下 右 上 左（不同策略下的路径不同）

思路：
1.构造迷宫
2.检测当前位置元素的上下左右四个元素的值，并进行递归

 */
public class MazeBackTracking {
    public static void main(String[] args) {
        int[][] maze = new int[10][10];//二维数组迷宫10×10
        for(int i = 0; i < 10; i ++) {//边界为1
            maze[0][i] = 1;
            maze[i][0] = 1;
            maze[9][i] = 1;
            maze[i][9] = 1;
        }
        for(int i = 1; i <= 6; i ++) {//迷宫内墙
            maze[3][i] = 1;
            maze[6][9-i] = 1;
        }

        boolean way = findWay(maze, 1, 1);
        System.out.println(way);

        for(int i = 0; i < 10; i ++) {//遍历，显示迷宫
            for(int j = 0; j < 10; j ++) {
                System.out.print(maze[i][j] + "  ");
            }
            System.out.println();
        }
    }

    /**
     * 从（1，1）出发到（8，8）.
     * 1为墙，0为地面，2为轨迹，3为死路
     * 移动的先后策略：下 右 上 左
     *
     * @param maze 迷宫
     * @param i 行定位，初始为0
     * @param j 列定位，初始为0
     * @return 是否找到通路
     */
    public static boolean findWay(int[][] maze, int i, int j) {
        if(maze[8][8] == 2) {
            return true;
        } else {
            if(maze[i][j] == 0) {
                maze[i][j] = 2;
                if(findWay(maze,i+1,j)) {//向下探路
                    return true;
                }else if(findWay(maze,i,j+1)) {//向右探路
                    return true;
                }else if(findWay(maze,i-1,j)) {//向上
                    return true;
                }else if(findWay(maze,i,j-1)) {//向左
                    return true;
                }else {
                    maze[i][j] = 3;//死路
                    return false;
                }
            }else {//此时maze[i][j] = 1\2\3，都不行
                return false;
            }
        }
    }
}

