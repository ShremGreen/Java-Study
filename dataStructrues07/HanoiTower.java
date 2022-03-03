package DevideAndConquer;

/*
汉诺塔游戏
*/

public class HanoiTower {
    public static void main(String[] args) {
        hanoiTower(3,'X','Y','Z');
    }

    public static void hanoiTower(int num, char X, char Y, char Z) {
        if(num == 1) {
            System.out.println("1\t" + X + "->" + Z);
        } else {
            hanoiTower(num - 1, X, Z, Y);
            System.out.println(num + "\t" + X + "->" + Z);
            hanoiTower(num - 1, Y, X, Z);
        }
    }
}
