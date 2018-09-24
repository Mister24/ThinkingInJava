package swordOffer.no004;

import sun.reflect.generics.tree.Tree;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，
 * 请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和
 * 中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 * */
public class Solution {
    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in  = {4,7,2,1,5,3,8,6};

        TreeNode treeNode = reConstructBinaryTree(pre, in);
    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }

        return construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    /**
     * 重新构建
     *
     * @param pre      前序遍历的结果
     * @param startPre 前序遍历的开始位置下标
     * @param endPre   前序遍历的结束位置下标
     * @param in       中序遍历的结果
     * @param startIn  中序遍历的开始位置下标
     * @param endIn    中序遍历的结束位置下标
     *
     * @return         根节点
     * */
    public static TreeNode construct(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }

        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {

            //中序遍历找根节点
            if (in[i] == pre[startPre]) {
                root.left = construct(pre, startPre + 1, i - startIn + startPre, in, startIn, i - 1);
                root.right = construct(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
                break;
            }
        }

        return root;
    }
}

