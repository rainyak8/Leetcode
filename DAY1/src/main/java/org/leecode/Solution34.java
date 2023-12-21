package org.leecode;

public class Solution34 {
    static int[] nums = new int[]{5,7,7,8,8,10};
    static int val = 6;
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int left, right,mid;
        int rightnum = -1 , leftnum = -1;
        int[] tar = new int[]{-1,-1};
        left = 0;
        right = len - 1;
        mid = left+ (right - left) /2;
        rightnum = searchRangeRight(nums, target, rightnum);
        leftnum = searchRangeLeft(nums, target, leftnum);
        tar[0] = leftnum;
        tar[1] = rightnum;
        return tar;
    }

    public int searchRangeRight(int[] nums, int target, int rightnum) {
        int len = nums.length;
        int mid = 0;
        int  left,right;
        left = 0;
        right = len - 1;
        while(left<=right){
            mid = left+ (right - left) /2;
            if(nums[mid] == target){
                rightnum = mid;
                left = mid + 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return rightnum;
    }

    public int searchRangeLeft(int[] nums, int target, int leftnum) {
        int len = nums.length;
        int mid = 0;
        int  left,right;
        left = 0;
        right = len - 1;
        while(left<=right){
            mid = left+ (right - left) /2;
            if(nums[mid] == target){
                leftnum = mid;
                right = mid - 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return leftnum;
    }

    public static void main(String[] args) {
        Solution34 s = new Solution34();
        int[] lens = s.searchRange(nums, val);
        for (int len : lens) {
            System.out.println(len);
        }

    }
}
