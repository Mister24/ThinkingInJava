/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fzw.interview.list;

import com.fzw.interview.list.listnode.ListNode;

/**
 * 链表翻转
 *
 * @author fzw.fzw
 * @version $Id: ReverseList.java, v 0.1 2018年03月26日 下午7:29 fzw.fzw Exp $
 */
public class ReverseList {

    public static void main(String[] args) {

        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        head = reverse(head);
        printListNode(head);

    }


    /**
     * 链表翻转（非递归）
     *
     * @param head 链表头指针
     *
     * @return     翻转后链表的头指针
     * */
    public static ListNode reverse(ListNode head) {

        if (null == head) {
            return null;
        }

        ListNode previous = head;
        ListNode current = head.next;
        ListNode temp;

        while (null != current) {
            temp = current.next;
            current.setNext(previous);

            previous = current;
            current = temp;
        }

        head.setNext(null);

        return previous;
    }

    /**
     * 链表翻转（递归）
     *
     * @param head 链表头指针
     *
     * @return     翻转后链表的头指针
     * */
    public static ListNode reverse1(ListNode head) {

        if (null == head || null == head.next) {
            return null;
        }

        ListNode previous = reverse1(head.next);
        head.next.next = head;
        head.next = null;

        return previous;
    }

    public static ListNode printListNode(ListNode head) {

        while (null != head) {
            System.out.println(head.getVal() +  " ");
        }

        return head;
    }
}