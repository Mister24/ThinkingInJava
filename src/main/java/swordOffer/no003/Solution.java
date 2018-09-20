package swordOffer.no003;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * */
public class Solution {
    public static void main(String[] args) {

        //{67,0,24,58}
        ListNode listNode = new ListNode(67);
        ListNode listNode1 = new ListNode(0);
        ListNode listNode2 = new ListNode(24);
        ListNode listNode3 = new ListNode(58);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        System.out.println(printListFromTailToHead(listNode));
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        if (listNode == null) {
            return arrayList;
        }

        Stack<ListNode> stack = new Stack<>();
        while (listNode.next != null) {
            stack.push(listNode);
            listNode = listNode.next;
        }
        //放入最后一个
        stack.push(listNode);

        while (stack.empty() == false) {
            arrayList.add(stack.peek().val);
            stack.pop();
        }
        return arrayList;
    }
}
