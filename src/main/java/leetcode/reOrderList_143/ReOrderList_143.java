/**
 * fzw.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package leetcode.reOrderList_143;

/**
 * 链表重新排序
 *
 * @author fzw.fzw
 * @version $Id: ReOrderList_143.java, v 0.1 2018年07月23日 下午7:58 fzw.fzw Exp $
 */
public class ReOrderList_143 {

    public static void main(String[] args) {

    }

    public void reorderList(ListNode head) {

        if (head == null && head.next == null && head.next.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //第一段的结尾是第二段的开始
        ListNode secondHalf = slow.next;

        //将第一段的结尾置为null
        slow.next = null;

        //第二段取反
        secondHalf = reverse(secondHalf);

    }

    public ListNode reverse(ListNode listNode) {

        if (listNode == null || listNode.next == null) {
            return listNode;
        }

        ListNode pre = listNode;
        ListNode current = pre.next;

        while (current != null) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }

        listNode.next = null;

        return pre;
    }
}