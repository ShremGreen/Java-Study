/*
给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
图示两个链表在节点 c1 开始相交：

题目数据 保证 整个链式结构中不存在环。
注意，函数返回结果后，链表必须 保持其原始结构 。
 */

public class exercise019 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /*//方法一
        ListNode temp = headA;
        Set basket = new HashSet();
        while(temp != null) {
            basket.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while(temp != null) {
            if(basket.contains(temp)) return temp;
            temp = temp.next;
        }
        return null;
        */

        //方法二
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        while(temp1 != temp2) {
            temp1 = temp1 == null ? headB : temp1.next;
            temp2 = temp2 == null ? headA : temp2.next;
        }
        return temp1;
    }
}
