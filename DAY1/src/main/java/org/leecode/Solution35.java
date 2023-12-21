package org.leecode;

public class Solution35 {
    static int[] nums = new int[]{1,3,5,6};
    static int val = 7;
    public int searchInsert(int[] nums, int target) {
        int len = nums.length,i = 0;
        while(i < len){
            if(nums[i] >= target){
                return i;
            }
            i++;
        }
        return len;
    }

    public static void main(String[] args) {
        Solution35 s = new Solution35();
        int len = s.searchInsert(nums, val);
        System.out.println(len);
    }
}
