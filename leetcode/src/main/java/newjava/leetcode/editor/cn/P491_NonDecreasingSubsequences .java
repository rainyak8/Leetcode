//给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。 
//
// 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,6,7,7]
//输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,4,3,2,1]
//输出：[[4,4]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 15 
// -100 <= nums[i] <= 100 
// 
//
// Related Topics 位运算 数组 哈希表 回溯 👍 755 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 非递减子序列
 * @author DY
 * @date 2023-12-27 11:28:01
 */
class P491_NonDecreasingSubsequences{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P491_NonDecreasingSubsequences().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public List<List<Integer>> result = new ArrayList<>();
	public List<Integer> list = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
		//Arrays.sort(nums);
		dfs(nums,0);
		return result;
    }
	public void dfs(int[] nums,int index){
		if (list.size() > 1) {
			result.add(new ArrayList<>(list));
		}
		int[] used = new int[201];
		for (int i = index; i < nums.length; i++) {
			if (!list.isEmpty() && nums[i] < list.get(list.size() - 1) ||
					(used[nums[i] + 100] == 1)) continue;
			used[nums[i] + 100] = 1;
			list.add(nums[i]);
			dfs(nums, i + 1);
			list.remove(list.size() - 1);
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
