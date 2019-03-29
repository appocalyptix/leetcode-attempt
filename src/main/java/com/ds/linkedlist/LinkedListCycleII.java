package com.ds.linkedlist;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode walker = head.next;
        ListNode runner = head.next.next;
        ListNode cycle = null;
        while (walker != null && runner.next != null) {
            if (walker == runner) {
                cycle = walker;
                break;
            }
            walker = walker.next;
            runner = runner.next.next;
        }
        return cycle;
    }
}
