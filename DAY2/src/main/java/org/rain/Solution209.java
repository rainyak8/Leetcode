package org.rain;

import java.math.*;

public class Solution209 {
    //构建滑块nums1
    //left
    static int[] nums = new int[]{1,1,1,1,1,1,1,1};
    //2 5 6 8 12 15
    static int val = 11;

    public int minSubArrayLen(int target, int[] nums) {
        int len = 1000010,left = 0,right = 0,sum = 0;

        while(right < nums.length){
            if(sum < target){
                sum += nums[right];
                right++;
            }
            while(sum >= target){
                len = Math.min(len,right-left);
                sum -= nums[left];
                left++;
            }
        }
        if(len == 1000010){
            len = 0;
        }
        return len;
    }

    public static void main(String[] args) {
        Solution209 s = new Solution209();
        int len = s.minSubArrayLen(val,nums);
        System.out.println(len);
    }
}
