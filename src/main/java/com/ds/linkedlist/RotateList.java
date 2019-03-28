package com.ds.linkedlist;

/**
 * #61
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        ListNode node = head;
        ListNode kParent = null;
        ListNode lastNode = null;
        int length = 0;

        while (node != null) {
            length++;
            if (length == k + 1) {
                kParent = head;
            } else if (length > k + 1) {
                kParent = kParent.next;
            }
            lastNode = node;
            node = node.next;
        }
        if (k > length) {
            return rotateRight(head, k % length);
        }

        if (kParent == null) {
            return head;
        }
        ListNode n = kParent.next;
        kParent.next = null;
        lastNode.next = head;
        return n;
    }

    public static void main(String[] args) {
        RotateList rl = new RotateList();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;


        ListNode h = rl.rotateRight(n5, 1);
        //  ListNode h = i[0];
        while (h != null) {
            System.out.println(h.val);
            h = h.next;
        }
    }
}
