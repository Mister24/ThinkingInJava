package leetcode.longestPalindromicSubstring_5;

public class Solution {
    public static void main(String[] args) {
        String ch = "abcde";
        String res = longestPalindrome(ch);
        System.out.println(res);
        String ch1 = "abcd";
        String res1 = longestPalindrome(ch1);
        System.out.println(ch1);
    }

    public static String longestPalindrome(String s) {

        if (s.length() == 0) {
            return null;
        }

        char[] ch = s.toCharArray();

        //添加分隔符之后的数组
        char[] fix = new char[2 * ch.length + 1];

        //插入分隔符
        for (int i = 0; i < ch.length; i++) {
            fix[2 * i] = '#';
            fix[2 * i + 1] = ch[i];
        }
        fix[fix.length - 1] = '#';

        //对应位置的最大回文字符串的长度
        int[] num = new int[2 * ch.length + 1];

        //遍历并记录每个下表位置的最长子序列长度
        for (int i = 0; i < fix.length; i++) {
            for (int j = 1; j <= i && i + j <= fix.length - i; j++) {
                if (fix[i - j] == fix[i + j]) {
                    j++;
                } else {
                    //计算最大长度
                    num[i] = 2 * j - 1 ;
                    break;
                }
            }
        }

        int temp = 0;
        int index = 0;
        for (int i = 0; i < num.length; i++) {
            temp = (num[i] > temp) ? num[i] : temp;
            index = i;
        }

        //回文字符串的半径
        int radium = (temp - 1) / 2;

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = index - radium; i <= index + radium; i++) {
            if (fix[i] != '#') {
                stringBuilder.append(fix[i]);
            }
        }

        return stringBuilder.toString();
    }
}
