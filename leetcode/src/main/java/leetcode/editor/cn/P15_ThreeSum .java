//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != 
//k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请 
//
// 你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 双指针 排序 👍 6569 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * @author DY
 * @date 2023-12-05 15:46:46
 */
class P15_ThreeSum{
	 public static void main(String[] args) {
		 int[] nums = new int[]{0,0,0,0};
	 	 //测试代码
	 	 Solution solution = new P15_ThreeSum().new Solution();
		 List<List<Integer>> renum = solution.threeSum(nums);
         for (List<Integer> integers : renum) {
             System.out.println(integers);
         }
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> renum = new ArrayList<>();
		Arrays.sort(nums);
		int i = 0, headnum = -100001,first=0,left = 1, right = nums.length-1;
		for (;first < nums.length - 2;) {
			if(nums[first] == headnum){
				first++;
				left = first + 1;
				right = nums.length-1;
				continue;
			}
			if(nums[first] + nums[left] + nums[right] > 0){
				//System.out.println(nums[first] + " "+nums[left]+" "+nums[right]+" 大于");
				right--;
			}else if(nums[first] + nums[left] + nums[right] < 0){
				//System.out.println(nums[first] + " "+nums[left]+" "+nums[right]+" 小于");
				left++;
			}else{
				//System.out.println(nums[first] + " "+nums[left]+" "+nums[right]+" 等于");
				List<Integer> num = new ArrayList<>();
				while (right > left && nums[right] == nums[right - 1]){
					i = 1;
					right--;
				}
				while (right > left && nums[left] == nums[left + 1]) {
					i = 1;
					left++;
				}
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
        return renum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
