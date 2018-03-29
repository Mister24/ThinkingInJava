/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fayuan.interview.binaryTree.algorithm;

import com.fayuan.interview.binaryTree.treeNode.TreeNode;

/**
 * 获取第k层节点总个数
 *
 * @author fayuan.fzw
 * @version $Id: GetKthLevelNodeNumber.java, v 0.1 2018年03月28日 上午1:49 fayuan.fzw Exp $
 */
public class GetKthLevelNodeNumber {

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

        System.out.println(getKthLevelNodeNumber(root, 2));
    }

    /**
     * 获取第k层节点总个数
     *
     * @param root 根节点
     * @param k    第k层
     *
     * @return     第k层节点的总个数
     *
     * */
    public static int getKthLevelNodeNumber(TreeNode root, int k) {

        if (null == root || k < 1) {
            return 0;
        } else if (k == 1) {
            return 1;
        } else {

            int leftTreeNodeNumber = getKthLevelNodeNumber(root.left, k - 1);
            int rightTreeNodeNumber = getKthLevelNodeNumber(root.right, k - 1);

            return leftTreeNodeNumber + rightTreeNodeNumber;
        }
    }
}