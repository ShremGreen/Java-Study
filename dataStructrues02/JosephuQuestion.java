package LinkedList;
/*
约瑟夫问题：
n个人围坐一圈，约定编号为k (1<=k<=n)的人从1开始报数，数到m的那个人出列，
它的下一位又从1开始报数，数到m的那个人又出列，
依次类推，直到所有人出列为止，由此产生一个出队编号的序列。

模拟约瑟夫问题：
通过单向环形链表实现，
没有空的头节点,链表存储节点对象，该对象的属性只有int no;
 */
public class JosephuQuestion {
    public static void main(String[] args) {
        CircleSingleLinkedList circle = new CircleSingleLinkedList();
        circle.addNodes(18);
        circle.listNodes();
        circle.Josephu(18,1,2);
    }
}

class CircleSingleLinkedList {
    private CircleNode first = null;//指针的定位标准
    CircleNode point = null;//指针

    //添加
    public void addNodes(int num) {
        if(num < 1) {
            System.out.println("节点数必须大于1个");
            return;
        }
        for(int i = 1; i <= num; i ++) {
            CircleNode node = new CircleNode(i);
            if(i == 1) {
                first = node;
                node.setNext(first);
                point = node;
            }else {
                point.setNext(node);
                node.setNext(first);
                point = node;
            }
        }
    }

    //遍历
    public void listNodes() {
        if(first.getNext() == null) {
            System.out.println("链表为空");
        }
        point = first;
        while(true) {
            System.out.println(point);
            if(point.getNext() == first) break;
            point = point.getNext();
        }
    }

    //Josephu
    public void Josephu(int num, int startNum, int countNum) {
        if(startNum > num || startNum < 1) {
            System.out.println("参数错误");
            return;
        }else if(first == null) {
            System.out.println("环形链表为空");
            return;
        }

        //point指针指向尾节点，first指针指向头节点
        //将指针位置移动至startNum
        while(point.getNext() != first) {
            point = point.getNext();
        }//头节点在1号

        while(true){
            if(first == point) break;
            for(int i = 1; i < countNum; i ++) {
                point = point.getNext();
                first = point.getNext();
            }
            System.out.print(first.getNo() + "  ");
            first = first.getNext();//此时point和first中间夹着Josephu节点
            point.setNext(first);
        }
        System.out.println(first.getNo());
    }
}

//节点，需要1.编号 2.next节点
class CircleNode {
    private int no;
    private CircleNode next;

    public CircleNode(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public CircleNode getNext() {
        return next;
    }

    public void setNext(CircleNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return no + "号";
    }
}