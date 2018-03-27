/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fayuan.interview.binaryTree.treeNode;

/**
 * 二叉树节点类
 *
 * @author fayuan.fzw
 * @version $Id: TreeNode.java, v 0.1 2018年03月27日 下午8:41 fayuan.fzw Exp $
 */
public class TreeNode {

    //节点值
    int val;

    //左子树
    TreeNode left = null;

    //右子树
    TreeNode right = null;

    TreeNode(int val) {
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
     * Getter method for property <tt>left</tt>.
     *
     * @return property value of left
     */
    public TreeNode getLeft() {
        return left;
    }

    /**
     * Setter method for property <tt>left</tt>.
     *
     * @param left  value to be assigned to property left
     */
    public void setLeft(TreeNode left) {
        this.left = left;
    }

    /**
     * Getter method for property <tt>right</tt>.
     *
     * @return property value of right
     */
    public TreeNode getRight() {
        return right;
    }

    /**
     * Setter method for property <tt>right</tt>.
     *
     * @param right  value to be assigned to property right
     */
    public void setRight(TreeNode right) {
        this.right = right;
    }
}