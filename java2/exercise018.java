import org.junit.Test;

public class exercise018 {
    public ListNode1 removeNthFromEnd(ListNode1 head, int n) {
        ListNode1 newHead = new ListNode1(-1, head);
        ListNode1 tail = newHead;
        ListNode1 prev = newHead;

        for(int i = 0; i < n; i ++) {
            tail = tail.next;
        }

        while(tail != null) {
            tail = tail.next;
            prev = prev.next;
        }

        prev.next = prev.next.next;

        return head;
    }
    @Test
    public void test() {

    }
}

class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1() {}
    ListNode1(int val) { this.val = val; }
    ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
}
