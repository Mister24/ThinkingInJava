/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package leetcode.removeNthNodeFromEndOfList_019;
import java.util.Stack;

/**
 *
 * @author fayuan.fzw
 * @version $Id: RemoveNthNodeFromEndOfList_19.java, v 0.1 2018年07月22日 上午12:18 fayuan.fzw Exp $
 */
public class RemoveNthNodeFromEndOfList_19 {

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode start = null;
        int num = 0;

        Stack<ListNode> stack = new Stack<>();
        Stack<ListNode> stack1 = new Stack<>();

        while (head.next != null) {
            stack.push(head);
            head = head.next;
        }

        if (stack.pop() != null) {

            if (num != n) {
                stack1.push(stack.pop());
            }
        }

        return start;
    }
}