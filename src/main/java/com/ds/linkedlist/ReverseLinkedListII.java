package com.ds.linkedlist;

/**
 * 92. Reverse Linked List II
 * <p>
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        if (m == n) {
            return head;
        }

        ListNode prevM = null;
        ListNode mTh = null;
        ListNode nTh = null;

        ListNode node = head;
        int count = 1;
        while (count <= n) {
            if (count == (m - 1)) {
                prevM = node;
            }
            if (count == m) {
                mTh = node;
            }

            if (count == n) {
                nTh = node;
            }
            count++;
            node = node.next;
        }

        ListNode sec3 = nTh.next;
        nTh.next = null;
        ListNode[] h = new ListNode[1];
        reverse(mTh, h);

        if (prevM == null) {
            head = h[0];
        } else {
            prevM.next = h[0];
        }

        node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = sec3;
        return head;
    }

    private ListNode reverse(ListNode node, ListNode[] head) {
        if (node.next == null) {
            head[0] = node;
            return node;
        }
        ListNode n = reverse(node.next, head);
        node.next = null;
        n.next = node;
        return node;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode n = n1;

        while (n != null) {
            System.out.print(" > " + n.val);
            n = n.next;
        }
        System.out.println("\n------------");
        ReverseLinkedListII rl = new ReverseLinkedListII();
        ListNode l = rl.reverseBetween(n4, 1, 2);

        while (l != null) {
            System.out.print(" > " + l.val);
            l = l.next;
        }
    }
}
