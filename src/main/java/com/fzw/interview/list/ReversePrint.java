/**
 * fzw.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fzw.interview.list;

import com.fzw.interview.list.listnode.ListNode;

import java.util.Stack;

/**
 * 从尾到头打印单链表
 *
 * @author fzw.fzw
 * @version $Id: ReversePrint.java, v 0.1 2018年03月27日 上午1:34 fzw.fzw Exp $
 */
public class ReversePrint {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode temp = listNode1;

        while (null != temp) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        System.out.println();
        reversePrint(listNode1);
    }

    /**
     * 从尾到头打印单链表
     *
     * @param head 头指针
     *
     * */
    public static void reversePrint(ListNode head) {

        if (null == head) {
            return;
        }

        Stack<ListNode> stack = new Stack<ListNode>();

        while (null != head) {
            stack.push(head);
            head = head.next;
        }

        while (stack.size() > 0) {
            System.out.print(stack.pop().val + " ");
        }
    }
}