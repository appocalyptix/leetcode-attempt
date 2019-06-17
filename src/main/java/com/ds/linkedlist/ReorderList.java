package com.ds.linkedlist;

/**
 * 143. Reorder List
 * <p>
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * Example 1:
 * <p>
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 * <p>
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 * <p>
 * Solution: The idea is to divide the list into half, then reverse the 2nd half of the list and then merge two halves
 */
public class ReorderList {

    public void reorderList(ListNode head) {

        if (head == null) {
            return;
        }

        int count = 0;
        ListNode n = head;

        while (n != null) {
            count++;
            n = n.next;
        }

        if (count < 3) {
            return;
        }
        int mid = count / 2;
        n = head;
        count = 0;
        while (count < mid - 1) {
            count++;
            n = n.next;
        }

        ListNode temp = new ListNode(-1);
        reverse(n.next, temp);

        n.next = null;
        ListNode h2 = temp.next;
        ListNode h1 = head;
        ListNode h3 = new ListNode(-1);
        head = h3;

        boolean alternate = false;
        while (h1 != null || h2 != null) {
            if (h2 != null && alternate) {
                h3.next = h2;
                h2 = h2.next;
                h3 = h3.next;
            } else if (h1 != null && !alternate) {
                h3.next = h1;
                h1 = h1.next;
                h3 = h3.next;
            }
            alternate = !alternate;
        }
        head = head.next;
    }


    private ListNode reverse(ListNode node, ListNode temp) {
        if (node == null) {
            return null;
        }

        if (node.next == null) {
            temp.next = node;
            return node;
        }

        ListNode n = reverse(node.next, temp);
        n.next = node;
        node.next = null;
        return node;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ReorderList rl = new ReorderList();
        rl.reorderList(n1);
        System.out.println(n1);

    }
}
