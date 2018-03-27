/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fayuan.interview.binaryTree.treeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 获取二叉树的最大宽度
 *
 * @author fayuan.fzw
 * @version $Id: MaxWidth.java, v 0.1 2018年03月27日 下午9:00 fayuan.fzw Exp $
 */
public class MaxWidth {

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
    }

    /**
     * 获取二叉树的最大宽度
     *
     * @param root 根节点
     *
     * */
    public static int getMaxWidth(TreeNode root) {

        if (null == root) {
            return 0;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();

        int maxWidth = 1;
        queue.add(root);

        while (true) {

            int len = queue.size();

            if (0 == len) {
                break;
            }

            while (len > 0) {
                //移除并返问队列头部的元素
                TreeNode treeNode = queue.poll();
                len--;

            if (null != treeNode.getLeft()) {

                //下一层节点入队
                queue.add(treeNode.getLeft());
            }

            if (null != treeNode.getRight()) {

                //下一层节点入队列
                queue.add(treeNode.getRight());
            }

            maxWidth = Math.max(maxWidth, queue.size());

            }
        }

        return maxWidth;
    }
}