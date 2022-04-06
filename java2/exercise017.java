public class exercise017 {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        System.out.println(linkedList.size);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        System.out.println(linkedList.size);
        System.out.println(linkedList.get(1));
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(linkedList.size);
        System.out.println(linkedList.get(1));
    }
}
class ListNode {
    int val;
    ListNode prev;
    ListNode next;

    public ListNode() {}
    public ListNode(int val, ListNode prev, ListNode next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

class MyLinkedList {
    ListNode head;//虚拟头节点
    int size;//节点数量

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0, null, null);
    }

    public int get(int index) {
        if(size == 0 || index > size - 1 || index < 0) return -1;//索引无效

        ListNode temp = head;
        for(int i = -1; i < index; i ++) {
            temp = temp.next;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        if(size == 0) {
            head.next = new ListNode(val, head, null);
            size ++;
        } else addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size - 1, val);
    }

    public void addAtIndex(int index, int val) {
        if(index > size) return;

        ListNode temp = head;
        for(int i = 0; i < index; i ++) {
            temp = temp.next;
        }
        ListNode link = temp.next;
        temp.next = new ListNode(val, temp, temp.next);
        link.prev = temp.next;
        size ++;
    }

    public void deleteAtIndex(int index) {
        if(size == 0 || index > size - 1 || index < 0) return;

        ListNode temp = head;
        for(int i = 0; i < index; i ++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        temp.next.prev = temp;
        size --;
    }
}