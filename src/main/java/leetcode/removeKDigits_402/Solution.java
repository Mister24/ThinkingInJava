package leetcode.removeKDigits_402;

public class Solution {
    public static void main(String[] args) {

    }

    public String removeKdigits(String num, int k) {
        String res = "";
        int length = num.length();
        if (length <= k) {
            return "0";
        }
        for (int i = 0; i < length - 1; i++) {
            if (num.charAt(i) > num.charAt(i + 1)) {
                num = delete(num, i);

            }
        }

        return res;
    }

    /**
     * 从字符串中删除pos位置的字符
     *
     * @param str 原始字符串
     * @param pos 待删除字符的位置
     *
     * @return    删除特定字符之后的字符串
     * */
    public String delete(String str, int pos) {
        return str.substring(0, pos) + str.substring(pos);
    }
}
