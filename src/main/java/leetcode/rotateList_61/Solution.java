package leetcode.rotateList_61;

public class Solution {
    public static void main(String[] args) {

    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head.next == null) {
            return head;
        }

        //定义一个节点指向head
        ListNode temp = head;
        int len = 1;
        while (temp.next != null) {
            len++;
            temp = temp.next;
        }
        //尾节点的下一个节点指向头结点
        temp.next = head;

        k = k % len;

        for (int i = 0; i < len - k; i++) {
            temp = temp.next;
        }

        head = temp.next;
        temp.next = null;

        return head;
    }
}
