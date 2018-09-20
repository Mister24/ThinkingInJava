package swordOffer.no009;

public class Solution {
    public int JumpFloorII(int target) {
        if (target <= 0) {
            return 0;
        } else {
            return 1 << target - 1;
        }
    }
}
