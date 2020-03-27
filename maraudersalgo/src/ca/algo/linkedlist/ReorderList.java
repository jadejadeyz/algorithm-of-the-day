package ca.algo.linkedlist;

public class ReorderList {
    public ListNode reorderList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondHead = slow.next;
        slow.next = null;

        if (secondHead == null)
            return head;

        if (secondHead.next != null) {
            ListNode head2 = reverseList(secondHead);
            head = mergeTwoList(head, head2);
        } else {
            head = mergeTwoList(head, secondHead);
        }
        return head;
    }

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode runner = head.next;
        head.next = null;
        ListNode temp;

        while (runner != null) {
            temp = runner.next;
            runner.next = cur;
            cur = runner;
            if (temp == null)
                break;
            runner = temp;
        }
        return runner;
    }

    public ListNode mergeTwoList(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        ListNode tempA, tempB;

        while (curA != null && curB != null) {
            tempA = curA.next;
            tempB = curB.next;
            curA.next = curB;
            curB.next = tempA;
            curA = tempA;
            curB = tempB;
        }

        return headA;
    }
}
