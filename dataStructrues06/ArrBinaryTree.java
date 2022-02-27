package Tree;
/*
顺序存储二叉树
思路：
以数组正常顺序存储arr，遍历时按照规则遍历

二叉树特点：
第n个元素的左子节点为2n+1
第n个元素的右子节点为2n+2
第n个元素的父节点为(n-1)/2
 */
class ArrBinaryTreeTest {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree abt = new ArrBinaryTree(arr);
        abt.preOrder(0);//1   2   4   5   3   6   7
        System.out.println();
        abt.infixOrder(0);//2   4   5   1   3   6   7
        System.out.println();
        abt.postOrder(0);//2   4   5   3   6   7   1
    }
}

class ArrBinaryTree {
    private int[] arr;//存储数据节点的数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //前序遍历
    public void preOrder(int index) {
        //先判断数组是否为空
        if(arr == null || arr.length == 0) {
            System.out.println("数组为空");
        }

        System.out.print(arr[index] + "   ");

        if((index * 2 + 1) < arr.length) {//左递归
            preOrder(index * 2 + 1);
        }
        if((index * 2 + 2) < arr.length) {
            preOrder(index * 2 + 2);
        }
    }

    //中序遍历
    public void infixOrder(int index) {
        if(arr == null || arr.length == 0) {
            System.out.println("数组为空");
        }

        if((index * 2 + 1) < arr.length) {//左递归
            preOrder(index * 2 + 1);
        }

        System.out.print(arr[index] + "   ");

        if((index * 2 + 2) < arr.length) {
            preOrder(index * 2 + 2);
        }
    }

    //后续遍历
    public void postOrder(int index) {
        if(arr == null || arr.length == 0) {
            System.out.println("数组为空");
        }

        if((index * 2 + 1) < arr.length) {//左递归
            preOrder(index * 2 + 1);
        }

        if((index * 2 + 2) < arr.length) {
            preOrder(index * 2 + 2);
        }

        System.out.print(arr[index] + "   ");
    }
}
