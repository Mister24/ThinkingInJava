/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2021 All Rights Reserved.
 */
package leetcode.addTwoNumbers_002;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * @author mr.24
 * @version Id: Solution, v 1.0 2021/3/20 下午1:28 Exp $$
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getLen(l1);
        int len2 = getLen(l2);
        ListNode head = null;
        if (l1.val + l2.val > 10) {
//
        }
        return null;

    }

//
///**
// * @author mr.24
// * @version Id: Solution, v 1.0 2021/3/20 下午1:28 Exp $$
// */
//public class Solution {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int len1 = getLen(l1);
//        int len2 = getLen(l2);
//        int max = len1 >= len2 ? len1 : len2;
//        int min = len1 >= len2 ? len2 : len1;
//
//        List<Integer> integerList1 = putToList(l1);
//        List<Integer> integerList2 = putToList(l1);
//
//        List<Integer> integerList1_reverse = reverse(integerList1);
//        List<Integer> integerList2_reverse = reverse(integerList2);
//        List<Integer> list = new ArrayList<>();
//        for (int i =0; i< min; i++) {
//            int num = integerList1_reverse.get(i) + integerList2_reverse.get(i);
//            int data = list.get(i);
//            if (num >=10) {
//                list.set(i, data + num - 10);
//                list.set(i + 1, 1);
//            } else {
//                list.set(i, data + num);
//            }
//        }
//
//        if (list.get(list.size() - 1) == 0) {
//            list.remove(list.size() - 1);
//        }
//
//        List<Integer> res = reverse(list);
//
//        for (int i = 0; i< res.size() -1;i++ ) {
//            ListNode node = new ListNode(res.get(i));
//            //node.next =
//        }
//    }
//
//    @Test
//    public void test() {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        System.out.println(list);
//        List<Integer> res = reverse(list);
//        System.out.println(res);
//    }
//    static List<Integer> reverse(List<Integer> list) {
//        if (list.size() == 1 || list.size() == 0) {
//            return list;
//        }
//
//        int mid = list.size() / 2;
//        for (int i = 0; i < list.size()/2; i++) {
//            int temp = 0;
//            int left = list.get(i);
//            int right = list.get(list.size() - i -1);
//            temp = left;
//            list.set(i, list.get(list.size() - i -1));
//            list.set(list.size() - i- 1, temp);
//        }
//
//        return list;
//    }
//
//    static List<Integer> putToList(ListNode node) {
//        List<Integer> integerList = Lists.newArrayList();
//        int len = getLen(node);
//        while (node.next != null) {
//            integerList.add(len);
//            node = node.next;
//        }
//
//        return integerList;
//    }
//

    /**
     * 获取长度
     *
     * @param node node
     * @return 长度
     */
    static int getLen(ListNode node) {
        int len = 0;
        while (node.next != null) {
            len++;
            node = node.next;
        }
        return len;
    }
}
//}
