/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fayuan.interview.binaryTree.algorithm;

import com.fayuan.interview.binaryTree.treeNode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 获取二叉树节点的总个数
 *
 * @author fayuan.fzw
 * @version $Id: GetTreeNodeNumber.java, v 0.1 2018年03月29日 下午6:00 fayuan.fzw Exp $
 */
public class GetTreeNodeNumber {

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

        System.out.println(getTreeNodeNumber(root));
        System.out.println(getTreeNodeNumber1(root));
    }

    /**
     * 求二叉树中节点个数(递归)
     *
     * @param root 二叉树根节点
     *
     * @return     二叉树节总点个数
     * */
    public static int getTreeNodeNumber(TreeNode root) {

        if (null == root) {

            return 0;
        } else {

            return getTreeNodeNumber(root.left) + getTreeNodeNumber(root.right) + 1;
        }
    }

    /**
     * 求二叉树中节点个数(非递归)
     *
     * @param root 二叉树根节点
     *
     * @return     二叉树节总点个数
     * */
    public static int getTreeNodeNumber1(TreeNode root) {

        if (null == root) {

            return 0;
        } else {

            int count = 1;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {

                TreeNode current = queue.remove();

                if (null != current.left) {
                    queue.add(current.left);
                    count++;
                }

                if (null != current.right) {
                    queue.add(current.right);
                    count++;
                }
            }
            return count;
        }
    }
}