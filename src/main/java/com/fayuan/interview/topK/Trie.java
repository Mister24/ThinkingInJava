/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fayuan.interview.topK;

/**
 *
 * @author fayuan.fzw
 * @version $Id: Trie.java, v 0.1 2018年03月30日 上午10:39 fayuan.fzw Exp $
 */
public class Trie {

    private final int SIZE = 26;

    private TrieNode root;

    //初始化字典树
    Trie() {
        root = new TrieNode();
    }

    public void insert(String str) {

        if (null == str || str.length() == 0) {

            return;
        }

        TrieNode trieNode = root;

        //单词转换为数组
        char[] letters = str.toCharArray();

        for (int i = 0; i < letters.length; i++) {

            int position = letters[i] - 'a';

            if (null == trieNode.son[position]) {

                //新建节点
                trieNode.getSon()[position] = new TrieNode();
                //放进对应的儿子节点中
                trieNode.getSon()[position].setVal(letters[i]);
            } else {
                trieNode.getSon()[position].number++;
            }

            trieNode = trieNode.getSon()[position];
        }
    }
}