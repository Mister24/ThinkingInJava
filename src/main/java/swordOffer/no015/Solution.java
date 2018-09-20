package swordOffer.no015;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * */
public class Solution {

    public static void main(String[] args) {

    }
    public static ListNode ReverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head.next;
        while (cur != null && cur.next != null) {
            cur.next = head;
            head = cur;
            cur = cur.next;
        }

        cur.next = head;
        return cur;

//        ListNode pre = head;
//        ListNode cur = pre.next;
//        ListNode end = cur.next;
//
//        while (end != null && end.next != null) {
//            end.next = pre;
//            pre = cur;
//            cur = end;
//            end = end.next;
//        }

    }

    public static ListNode ReverseList1(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        Queue<ListNode> queue = new LinkedList<>();
        while (head.next != null) {
            queue.add(head);
            head = head.next;
        }
        queue.add(head.next);

        ListNode res = queue.poll();
        ListNode res1 = queue.poll();

        while (!queue.isEmpty()) {
            res.next = queue.poll();
        }

        return res1;
    }
}
