package ca.algo.linkedlist;

import java.util.LinkedList;
import java.util.List;

public class LLMain {
    public static void main(String[] args) {
        ReorderList list = new ReorderList();
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);
        ListNode a1 = new ListNode(6);
        ListNode a2 = new ListNode(7);

        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = a1;
        a1.next = a2;

        ListNode newHead = list.reverseList(head);
        ListNode cur = newHead;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
