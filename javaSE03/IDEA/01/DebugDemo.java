package IDEA_code;

class DebugDemo {
    public static void main(String[] args) {
            //获取一个随机数
        double d = Math.random();

        for(int i = 0; i < 100; i ++) {
            //默认数据类型是double型，强制转换为int型
            int x = (int) (Math.random() * 100 + 1);
            System.out.println(x);
        }
    }
}

