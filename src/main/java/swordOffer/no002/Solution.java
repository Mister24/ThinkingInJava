package swordOffer.no002;

/**
 * 请实现一个函数，
 * 将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 * */

public class Solution {
    public static void main(String[] args) {

    }

    public static String replaceSpace(StringBuffer str) {

        StringBuilder stringBuilder = new StringBuilder();
        char[] ch = str.toString().toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(ch[i]);
            }
        }

        return stringBuilder.toString();
    }
}
