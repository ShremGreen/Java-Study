package LinkedList;

/*
模拟单链表
核心：节点类中必须有指向下一个节点的next变量
需注意：
1.代码顺序。顺序颠倒导致了死循环、空指针等问题
2.该单链表的前提是有一个永不赋值的头节点
3.循环时，节点从前一个节点开始，实际上操作还是temp.next
 */
class SingleLinkedListTest {
    public static void main(String[] args) {
        heroNode hero1 = new heroNode(1,"宋江","及时雨");
        heroNode hero2 = new heroNode(3,"吴用","智多星");
        heroNode hero3 = new heroNode(4,"公孙胜","入云龙");
        heroNode hero4 = new heroNode(2,"卢俊义","玉麒麟");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

        /*singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        singleLinkedList.list();*/

        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.list();

        singleLinkedList.update(1,"晁盖","托塔天王");
        singleLinkedList.update(5,"关胜","大刀");
        singleLinkedList.list();
        singleLinkedList.delete(2);
        singleLinkedList.list();
    }
}

public class SingleLinkedList {
    //初始化头节点,头节点为空
    heroNode head = new heroNode(0,"","");

    //添加，方法一：按添加顺序依次写入数链表
    public void add(heroNode hero) {
        heroNode temp = head;
        //判断是否到末尾
        while(true) {
            if(temp.getNext() == null) {//temp.next即指针的位置
                break;
            } temp = temp.getNext();
        }
        temp.setNext(hero);
    }
    //添加，方法二：按排名写入链表
    public void addByOrder(heroNode hero) {
        heroNode temp = head;
        boolean flag = false;
        //遍历当前链表，并判断
        //1.链表为空2.编号存在3.存在比当前节点编号更大的节点4.前面节点全是比当前小的
        while(true) {
            if(temp.getNext() == null) {//空
                break;
            }
            if(temp.getNext().getNo() == hero.getNo()) {//编号相同
                flag = true;
                break;
            }
            if(temp.getNext().getNo() > hero.getNo()) {//找到位置
                break;
            }
            temp = temp.getNext();
        }
        //1和3都可以直接添加；2报错；4继续迭代
        if(flag) {
            System.out.println("该节点已存在");
        }else {//赋值并首尾连接
            //注意顺序！！！先设置尾指针再设置头指针
            hero.setNext(temp.getNext());
            temp.setNext(hero);
        }
    }

    //显示链表
    public void list() {
        if(head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        //while遍历，通过之前定义的head对象作为头指针
        heroNode temp = head.getNext();
        while(temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    //修改
    public void update(int no, String name, String nickName) {
        heroNode temp = head;
        boolean flag = false;
        if(temp.getNext() == null) {
            System.out.println("链表为空，请先录入数据");
            return;
        }
        while(true) {
            if(temp.getNext() == null) {//注意顺序！！（空指针异常）
                break;
            }
            if(temp.getNext().getNo() == no) {//注意顺序！！（空指针异常）
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if(flag) {
            temp.getNext().setName(name);
            temp.getNext().setNickName(nickName);
        }else {
            System.out.println("该节点不存在，请确认信息");
        }
    }

    //删除(即更改节点连接情况)
    public void delete(int no) {
        heroNode temp = head;
        boolean flag = false;
        if(temp.getNext() == null) {
            System.out.println("链表为空，请先录入数据");
            return;
        }
        while(true) {
            if(temp.getNext() == null) {
                break;
            }else if(temp.getNext().getNo() == no) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if(flag) {
            temp.setNext(temp.getNext().getNext());
            //这里不会空指针！！因为当指针在n处时已经被循环排除，而在n-1处时temp.next.next=null
        }else {
            System.out.println("该节点不存在，请确认信息");
        }
    }
}

//该类表示节点（存取数据的单位）
class heroNode {
    private int no;//编号
    private String name;
    private String nickName;
    private heroNode next;
    //next用于连接下一个节点和迭代
    //每次创建一个新的类对象时都会生成一个heroNode类型的next变量，初始值为null
    //实际上next就相当于链表中当前节点和下一个节点的连接

    public heroNode() {
    }

    public heroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public heroNode getNext() {
        return next;
    }

    public void setNext(heroNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "排名：" + no +
                "\t姓名：" + name +
                "\t绰号：" + nickName;
    }
}
