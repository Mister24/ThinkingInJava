package swordOffer.no001;

public class Solution {
    public static void main(String[] args) {

    }

    public boolean Find(int target, int[][] array) {
        boolean res = false;

        //n行m列
        int n = array.length;
        int m = array[0].length;

        for (int i = 0, j = m - 1; i >= 0 && i <= n - 1 && j >= 0 && j <= m - 1;) {
            if (array[i][j] == target) {
                res = true;
            } else if (array[i][j] > target) {
                j--;
            }  else {
                i++;
            }
        }

        return res;
    }
}