package swordOffer.no016;

public class Solution {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = null;

        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(6);
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = null;

        ListNode tem = Merge(listNode1, listNode4);

        while (tem.next != null) {
            System.out.println(tem.val);
        }

    }

    public static ListNode Merge(ListNode list1,ListNode list2) {
        ListNode listNode = null;

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                listNode.next = list1;
                listNode = listNode.next;
                list1 = list1.next;
            } else {
                listNode.next = list2;
                listNode = listNode.next;
                list2 = list2.next;
            }
        }

        if (list1 == null) {
            listNode.next = list2;
        }

        if (list2 == null){
            listNode.next = list1;
        }

        return listNode;
    }
}
