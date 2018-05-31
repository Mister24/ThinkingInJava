/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fayuan.interview.list.listnode;

/**
 * 节点类
 *
 * @author fayuan.fzw
 * @version $Id: ListNode.java, v 0.1 2018年03月26日 下午7:27 fayuan.fzw Exp $
 */
public class ListNode {

    //节点的值
    public int val;

    //下一节点
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    /**
     * Getter method for property <tt>val</tt>.
     *
     * @return property value of val
     */
    public int getVal() {
        return val;
    }

    /**
     * Setter method for property <tt>val</tt>.
     *
     * @param val  value to be assigned to property val
     */
    public void setVal(int val) {
        this.val = val;
    }

    /**
     * Getter method for property <tt>next</tt>.
     *
     * @return property value of next
     */
    public ListNode getNext() {
        return next;
    }

    /**
     * Setter method for property <tt>next</tt>.
     *
     * @param next  value to be assigned to property next
     */
    public void setNext(ListNode next) {
        this.next = next;
    }
}