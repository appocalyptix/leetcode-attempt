package com.algorithm.sort;

/**
 *
 */
public class SortList {
    public ListNode sortList(ListNode head) {

        return head;
    }

    // TODO
    public void sortListRecursive(ListNode node, int max, int min) {

        if (node == null || node.next == null || node.val == max) {
            return;
        }

        ListNode pivot = node;
        ListNode head = node;

        ListNode previous = node;
        node = node.next;

        while (node != null && node.val != max) {
            if (node.val < pivot.val) {
                previous.next = node.next;
                node.next = head;
                head = node;
                node = previous.next;
            } else {
                previous = node;
                node = node.next;
            }
        }
        return;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
