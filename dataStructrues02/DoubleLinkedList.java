package LinkedList;

/*
模拟双链表

需注意：
按排名添加节点时，根据定位后面有无节点分为两种情况，
若定位处后面无节点，则可以直接添加，2次连接，顺序无要求
若后面有节点，需要重新分配该处节点连接情况，4次连接，顺序是重点
 */

class DoubleLinkedListTest {
    public static void main(String[] args) {

        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(3,"吴用","智多星");
        HeroNode hero3 = new HeroNode(4,"公孙胜","入云龙");
        HeroNode hero4 = new HeroNode(2,"卢俊义","玉麒麟");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.list();

        doubleLinkedList.reverseOutput();

        doubleLinkedList.delete(0);
        doubleLinkedList.list();

    }
}



public class DoubleLinkedList {
    //初始化头节点
    HeroNode head = new HeroNode(0,"","");

    //添加
    public void addByOrder(HeroNode hero) {
        HeroNode temp = head;
        boolean flag = false;

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

        //重点：连接条件和顺序！！！！
        if(flag) {
            System.out.println("该节点已存在");
        }else {
            if(temp.getNext() == null) {
                hero.setPre(temp);
                temp.setNext(hero);
            }else {
                hero.setNext(temp.getNext());
                temp.getNext().setPre(hero);
                hero.setPre(temp);
                temp.setNext(hero);
            }
        }
    }

    //显示链表
    public void list() {
        if(head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.getNext();
        while(temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    //修改
    public void update(int no, String name, String nickName) {
        HeroNode temp = head;
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
        HeroNode temp = head.getNext();
        boolean flag = false;
        if(temp == null) {
            System.out.println("链表为空，请先录入数据");
            return;
        }
        while(true) {
            if(temp == null) {
                break;
            }else if(temp.getNo() == no) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if(flag) {
            temp.getPre().setNext(temp.getNext());
            if(temp.getNext() != null) {
                temp.getNext().setPre(temp.getPre());
            }
        }else {
            System.out.println("该节点不存在，请确认信息");
        }
    }
    //查询某个节点内容
    public HeroNode Node(int no) {
        HeroNode temp = head;
        boolean flag = false;
        if(temp.getNext() == null) {
            System.out.println("链表为空，请先录入数据");
            return null;
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
            return temp.getNext();
        }else {
            System.out.println("该节点不存在，请确认信息");
            return null;
        }
    }
    //链表长度
    public int length() {
        HeroNode temp = head;
        int length = 0;
        if(head.getNext() == null) {
            return 0;
        }
        while(temp.getNext() != null) {
            length ++;
            temp = temp.getNext();
        }
        return length;
    }

    //逆序输出（原链表无损）
    public void reverseOutput() {
        HeroNode temp = head;
        if(temp.getNext() == null) {
            System.out.println("链表为空，请先录入数据");
            return;
        }
        while(temp.getNext() != null) {
            temp = temp.getNext();
        }
        while(temp != head) {
            System.out.println(temp);
            temp = temp.getPre();
        }
    }
}

class HeroNode{
    private int no;//编号
    private String name;
    private String nickName;
    private HeroNode next;
    private HeroNode pre;

    public HeroNode() {
    }

    public HeroNode(int no, String name, String nickName) {
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

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    public HeroNode getPre() {
        return pre;
    }

    public void setPre(HeroNode pre) {
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "排名：" + no +
                "\t姓名：" + name +
                "\t绰号：" + nickName;
    }
}
