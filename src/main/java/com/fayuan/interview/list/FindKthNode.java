/**
 * fzw.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fzw.interview.list;

import com.fzw.interview.list.listnode.ListNode;

import java.util.List;

/**
 * 查找单链表中的倒数第k个结点
 *
 * @author fzw.fzw
 * @version $Id: FindKthNode.java, v 0.1 2018年03月27日 上午1:23 fzw.fzw Exp $
 */
public class FindKthNode {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        System.out.println(findKthNode(listNode1,2).getVal());
    }

    /**
     * 查找单链表中的倒数第k个结点
     *
     * @param head 头节点
     * @param k    倒数第k个节点
     *
     * @return     查找到的节点
     * */
    public static ListNode findKthNode(ListNode head, int k) {

        if (0 == k || null == head) {
            return null;
        }

        ListNode first = head;
        ListNode second = head;

        //先让第二个指针向后移动k的距离，此时两个节点的距离为k
        for (int i = 0; i < k - 1; i++) {

            System.out.println("i的值为" + i);
            second = second.next;

            if (null == second) {
                return null;
            }
        }

        //两个指针同时移动，当第二个节点到底末尾时，第一个节点恰好在倒数第k的位置
        while (null != second.next) {
            first = first.next;
            second = second.next;
        }
        return first;
    }
}