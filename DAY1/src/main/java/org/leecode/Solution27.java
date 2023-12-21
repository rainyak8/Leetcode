package org.leecode;

public class Solution27 {
    static int[] nums = new int[]{0,1,2,2,3,0,4,2};
    static int val = 3;
    public int removeElement(int[] nums, int val) {
        int left,right,valnum = 0,len,templen = 0,temp,relen = 0;
        len = nums.length;
        left = 0;
        right = -1;

        for (int i = 0; i <len; i++) {
            if(nums[i] == val && valnum == 0){
                left = i;
                valnum++;
            }else if(nums[i] != val){
                right = i;
                if(left != right){
                    temp = nums[right];
                    nums[right] = nums[left];
                    nums[left] = temp;
                    templen++;
                }
                left++;
                relen++;
            }
        }
        if(right == -1){
            return 0;
        }
        val = relen;
        return val;
    }

    public static void main(String[] args) {
        Solution27 s = new Solution27();
        int len = s.removeElement(nums, val);

        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
