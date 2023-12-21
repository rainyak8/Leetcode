package org.leecode;

public class Solution704fromlee {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution704fromlee s = new Solution704fromlee();
        int target = 9, flag;
        int[]nums = new int[]{-1,0,3,5,9,12};
        flag = s.search(nums,target);
        System.out.println(flag);
    }
}
