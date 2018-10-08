/**
 * fayuan.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fayuan.interview.binaryTree.algorithm;

import com.fayuan.interview.binaryTree.treeNode.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 遍历
 * 1.前序遍历（递归+非递归）
 * 2.中序遍历（递归+非递归）
 * 3.后序遍历（递归+非递归）
 * 4.层次遍历
 *
 * @author fayuan.fzw
 * @version $Id: Travel.java, v 0.1 2018年03月29日 下午7:07 fayuan.fzw Exp $
 */
public class Travel {

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

        preOrderTravel(root);
        System.out.println();

        preOrderTravelByLoop(root);
        System.out.println();

        middleOrderTravel(root);
        System.out.println();

        middleOrderTravelByLoop(root);
        System.out.println();

        postOrderTravel(root);
        System.out.println();

        layerTravel(root);
    }

    /**
     * 先序遍历(递归)
     *
     * @param root 根节点
     *
     * */
    public static void preOrderTravel(TreeNode root) {

        if (null == root) {
            return;
        }

        System.out.print(root.val + " ");
        preOrderTravel(root.getLeft());
        preOrderTravel(root.getRight());
    }

    /**
     * 先序遍历(非递归)
     *
     * @param root 根节点
     *
     * */
    public static void preOrderTravelByLoop(TreeNode root) {

        if (null == root) {
            return;
        }

        Stack<TreeNode> stack = new Stack();

        //根节点非空，则入栈，并将节点赋值给左孩子
        while (root != null || !stack.isEmpty()) {

            if (root != null) {

                stack.push(root);
                System.out.print(root.val + " ");
                root = root.getLeft();
            } else {

                root = stack.pop().getRight();
            }
        }
    }

    /**
     * 中序遍历(递归)
     *
     * @param root 根节点
     *
     * */
    private static void middleOrderTravel(TreeNode root) {

        if (null == root) {
            return;
        }

        middleOrderTravel(root.left);
        System.out.print(root.val + " ");
        middleOrderTravel(root.right);
    }

    /**
     * 中序遍历(非递归)
     *
     * @param root 根节点
     *
     * */
    private static void middleOrderTravelByLoop(TreeNode root) {

        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (root != null || !stack.isEmpty()) {

            //当前节点非空，入栈
            if (root != null) {

                stack.push(root);
                root = root.getLeft();
            } else {

                root = stack.pop();
                System.out.print(root.val + " ");
                root = root.getRight();
            }
        }

    }

    /**
     * 后序遍历
     *
     * @param root 根节点
     *
     * */
    private static void postOrderTravel(TreeNode root) {

        if (null == root) {
            return;
        }

        postOrderTravel(root.left);
        postOrderTravel(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * 层次遍历（借助栈的功能）
     * 1.对于不为空的结点，先把该结点加入到队列中
     * 2.从队中拿出结点，如果该结点的左右结点不为空，就分别把左右结点加入到队列中
     * 3.重复以上操作直到队列为空
     *
     * @param root 根节点
     *
     * */
    public static void layerTravel(TreeNode root) {

        if (null == root) {
            return;
        }

        TreeNode current;
        LinkedList<TreeNode> linkedList = new LinkedList<TreeNode>();
        linkedList.add(root);

        while (!linkedList.isEmpty()) {

            current = linkedList.poll();
            System.out.print(current.val + " ");

            if (current.left != null) {
                linkedList.add(current.left);
            }

            if (current.right != null) {
                linkedList.add(current.right);
            }
        }
    }

}