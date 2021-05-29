/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fzw.interview.list;

import com.fzw.interview.list.listnode.ListNode;

import java.util.HashMap;

/**
 *
 * @author fzw.fzw
 * @version $Id: ListLoop.java, v 0.1 2018年03月26日 下午9:02 fzw.fzw Exp $
 */
public class ListLoop {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        listNode4.setNext(listNode5);
        listNode5.setNext(listNode1);

        System.out.println(hasLoop(listNode1));

        System.out.println(hasLoop1(listNode1));
    }

    /**
     * 判断是否是环链
     *
     * @param node 链的头指针
     *
     * @return     是否有环
     * */
    public static boolean hasLoop(ListNode node) {

        ListNode node1 = node;
        ListNode node2 = node.next;

        while (null != node2) {

            int val1 = node1.getVal();
            int val2 = node2.getVal();

            if (val1 == val2) {
                return true;
            }

            node1 = node1.next;
            node2 = node2.next.next;

            if (null == node2) {
                return false;
            }
        }

        return true;
    }

    /**
     * 判断是否是环链
     *
     * @param listNode 链的头指针
     *
     * @return         是否有环
     * */
    public static boolean hasLoop1(ListNode listNode) {

        ListNode temp1 = listNode;

        HashMap<ListNode, ListNode> nodeListNodeHashMap = new HashMap<ListNode, ListNode>();

        while (null != listNode) {

            //用hashmap保存节点，如果存在，表示存在环
            if (null != nodeListNodeHashMap.get(temp1)) {
                return true;
            } else {
                nodeListNodeHashMap.put(temp1, temp1);
            }
            temp1 = temp1.next;
            if (null == temp1) {
                return false;
            }
        }
        return false;
    }
}