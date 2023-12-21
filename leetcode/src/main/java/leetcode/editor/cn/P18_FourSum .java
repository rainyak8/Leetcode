//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 双指针 排序 👍 1815 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 * @author DY
 * @date 2023-12-05 16:54:27
 */
class P18_FourSum{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P18_FourSum().new Solution();

		 int[] nums = new int[]{1,0,-1,0,-2,2};
		 int target = 0;
		 List<List<Integer>> renum = solution.fourSum(nums, target);
		 for (List<Integer> integers : renum) {
			 System.out.println(integers);
		 }
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> renum = new ArrayList<>();
		Arrays.sort(nums);
		int head = 0,headnum = -1000000001,first=1,left = 2, right = nums.length-1;
		long sum = 0;
		for (head = 0; head < nums.length - 3; head++) {
			if (nums[head] > 0 && nums[head] > target) {
				return renum;
			}

			if (head > 0 && nums[head - 1] == nums[head]) {
				continue;
			}
			first = head + 1;
			left = first + 1;
			right = nums.length-1;
			headnum = -1000000001;
            while (first < nums.length - 2) {
                if(nums[first] == headnum){
                    first++;
                    left = first + 1;
                    right = nums.length-1;
                    continue;
                }
                if(nums[head] + nums[first] + nums[left] + nums[right] > target){
                    //System.out.println(nums[head] + " "+nums[first] + " "+nums[left]+" "+nums[right]+" 大于");
                    right--;
                }else if(nums[head] + nums[first] + nums[left] + nums[right] < target){
                    //System.out.println(nums[head] + " "+nums[first] + " "+nums[left]+" "+nums[right]+" 小于");
                    left++;
                }else{
                    //System.out.println(nums[head] + " "+nums[first] + " "+nums[left]+" "+nums[right]+" 等于");
                    List<Integer> num = new ArrayList<>();
                    while (right > left && nums[right] == nums[right - 1]){
                        right--;
                    }
                    while (right > left && nums[left] == nums[left + 1]) {
                        left++;
                    }
					num.add(nums[head]);
                    num.add(nums[first]);
                    num.add(nums[left]);
                    num.add(nums[right]);
                    renum.add(num);

                    left++;
                    //headnum = nums[first];
                }
                if(left >= right){
                    headnum = nums[first];
                    first++;
                    left = first + 1;
                    right = nums.length-1;
                }
            }
        }
		return renum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
