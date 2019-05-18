package com.ds.linkedlist;

/**
 * 206. Reverse Linked List
 * <p>
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode[] h = new ListNode[1];
        reverse(head, h);
        return h[0];
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
        ReverseLinkedList rl = new ReverseLinkedList();
        ListNode l = rl.reverseList(n1);

        while (l != null) {
            System.out.print(" > " + l.val);
            l = l.next;
        }
    }
}
