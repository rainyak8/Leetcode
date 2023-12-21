package org.leecode;

class Solution704 {
    public int search(int[] nums, int target){
        int left,right,mid,len;
        len = nums.length;
        left = 0;
        right = len - 1;
        if(left == right){
            //System.out.println(" end ");
            if(target == nums[left]){
                return left;
            }
            return -1;
        }
        while(true){
            if(left > right){
                break;
            }
            mid = left + (right - left) / 2;
            if(target < nums[mid]){
                right = mid - 1;
            }else if(target > nums[mid]){
                left = mid + 1;
            }else{
                return  mid;
            }
            //System.out.printf(mid + " ");
            if(left == right){
                if(target == nums[right]){
                    return right;
                }
                //System.out.println(" end ");
                break;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution704 s = new Solution704();
        int target = 9, flag;
        int[]nums = new int[]{-1,0,3,5,9,12};
        flag = s.search(nums,target);
        System.out.println(flag);
    }
}