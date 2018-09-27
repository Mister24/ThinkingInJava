/**
 * fayuan.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fayuan.interview.binaryTree.algorithm;

import com.fayuan.interview.binaryTree.treeNode.TreeNode;

/**
 *
 * @author fayuan.fzw
 * @version $Id: MaxDepth.java, v 0.1 2018年03月27日 下午8:42 fayuan.fzw Exp $
 */
public class MaxDepth {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        TreeNode treeNode1 = new TreeNode(13);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(11);
        TreeNode treeNode6 = new TreeNode(14);
        TreeNode treeNode7 = new TreeNode(2);

        root.setLeft(treeNode2);
        root.setRight(treeNode1);
        treeNode2.setLeft(treeNode3);
        treeNode2.setRight(treeNode4);
        treeNode1.setLeft(treeNode5);
        treeNode1.setRight(treeNode6);
        treeNode3.setLeft(treeNode7);

        System.out.println(getMaxDepth(root));
    }

    /**
     * 获取二叉树的深度
     *
     * @param root 二叉树的根节点
     *
     * @return     二叉树的深度
     * */
    public static int getMaxDepth(TreeNode root) {

        if (null == root) {
            return 0;
        }

        int left = getMaxDepth(root.left);
        int right = getMaxDepth(root.right);

        return 1 + Math.max(left, right);
    }
}