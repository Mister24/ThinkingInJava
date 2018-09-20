package leetcode.largestNumber_179;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5,9};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            str[i] = String.valueOf(nums[i]);
        Comparator<String> comp = new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        };
        Arrays.sort(str, comp);
        if (str[0].equals("0"))
            return "0";
        StringBuilder sb=new StringBuilder();
        for (String s : str)
            sb.append(s);
        return sb.toString();
    }
}
