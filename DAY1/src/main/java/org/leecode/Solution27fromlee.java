package org.leecode;

public class Solution27fromlee {
    static int[] nums = new int[]{0,1,2,2,3,0,4,2};
    static int val = 3;
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        Solution27fromlee s = new Solution27fromlee();
        int len = s.removeElement(nums, val);

        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
