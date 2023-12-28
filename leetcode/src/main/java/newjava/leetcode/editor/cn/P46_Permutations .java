//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2780 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * @author DY
 * @date 2023-12-27 11:44:20
 */
class P46_Permutations{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P46_Permutations().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public List<List<Integer>> result = new ArrayList<>();
	public List<Integer> list = new ArrayList<>();
	boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
		used = new boolean[nums.length];
		dfs(nums);
		return result;
    }

	public void dfs(int[] nums){
		if(list.size() == nums.length){
			result.add(new ArrayList<>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if(used[i]){
				continue;
			}
			used[i] = true;
			list.add(nums[i]);
			dfs(nums);
			list.remove(list.size()-1);
			used[i] = false;
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
