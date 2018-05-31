/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fayuan.interview.topK;

/**
 * 字节数节点类
 *
 * @author fayuan.fzw
 * @version $Id: TrieNode.java, v 0.1 2018年03月30日 上午10:54 fayuan.fzw Exp $
 */
public class TrieNode {

    //有多少单词通过这个节点，即由根至该节点组成的字符串模式出现的次数
    public int number;

    //所有的儿子节点
    public TrieNode[] son;

    //是不是最后一个节点
    public boolean isEnd;

    //节点的值
    public char val;

    TrieNode() {

        number = 1;
        son = new TrieNode[16];
        isEnd = false;
    }

    /**
     * Getter method for property <tt>number</tt>.
     *
     * @return property value of number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Setter method for property <tt>number</tt>.
     *
     * @param number  value to be assigned to property number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Getter method for property <tt>son</tt>.
     *
     * @return property value of son
     */
    public TrieNode[] getSon() {
        return son;
    }

    /**
     * Setter method for property <tt>son</tt>.
     *
     * @param son  value to be assigned to property son
     */
    public void setSon(TrieNode[] son) {
        this.son = son;
    }

    /**
     * Getter method for property <tt>isEnd</tt>.
     *
     * @return property value of isEnd
     */
    public boolean isEnd() {
        return isEnd;
    }

    /**
     * Setter method for property <tt>isEnd</tt>.
     *
     * @param isEnd  value to be assigned to property isEnd
     */
    public void setEnd(boolean isEnd) {
        isEnd = isEnd;
    }

    /**
     * Getter method for property <tt>val</tt>.
     *
     * @return property value of val
     */
    public char getVal() {
        return val;
    }

    /**
     * Setter method for property <tt>val</tt>.
     *
     * @param val  value to be assigned to property val
     */
    public void setVal(char val) {
        this.val = val;
    }
}