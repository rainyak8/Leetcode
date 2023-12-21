package org.rain;

public class Solution977 {
    static int[] nums = new int[]{-10000,-9999,-7,-5,0,0,10000};
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] nums1 = new int[len];
        int right = len - 1,left = 0,pos = len - 1;
        while(left <= right){
            if(nums[left] * nums[left] > nums[right] * nums[right]){
                nums1[pos] = nums[left] * nums[left];
                left++;
            }else{
                nums1[pos] = nums[right] * nums[right];
                right--;
            }
            pos--;
        }
        return nums1;
    }

    public static void main(String[] args) {
        Solution977 s = new Solution977();
        int[] lens = s.sortedSquares(nums);

        for (int len : lens) {
            System.out.println(len);
        }
    }
}
