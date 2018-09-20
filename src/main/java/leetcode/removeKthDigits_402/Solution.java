package leetcode.removeKthDigits_402;

public class Solution {

    public static void main(String[] args) {
        System.out.println(removeKdigits("10", 1));
    }

    public static String removeKdigits(String num, int k) {

        int start = k;

        if (num.length() <= k) {
            return "0";
        }

        if (k == 0) {
            return num;
        }

        for (int i = 0; i < num.length() - 1; i++) {
            if (num.charAt(0) == '0') {
                num = num.substring(1);
            }
            if (num.charAt(1) == '0') {
                num = num.substring(2);
                if (num.length() == 0) {
                    return  "0";
                }
                k--;
            } else if (num.charAt(i) > num.charAt(i + 1)) {
                //num = num.substring(0, i - start + k) + num.substring(i - start + k + 1);
                //num = num.substring(0, i - (start - k)) + num.substring(i + 1 - (start - k));
                num = num.substring(0, i) + num.substring(i + 1);
                k--;
                i = 0;
            } else {
                num = num.substring(0, num.length());
                k--;
                i = 0;
            }

            if (k == 0) {
                break;
            }
        }

        return num;
    }
}
