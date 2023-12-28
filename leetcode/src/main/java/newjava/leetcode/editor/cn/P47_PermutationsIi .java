//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 数组 回溯 👍 1515 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 全排列 II
 * @author DY
 * @date 2023-12-27 11:52:16
 */
class P47_PermutationsIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P47_PermutationsIi().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public List<List<Integer>> result = new ArrayList<>();
	public List<Integer> list = new ArrayList<>();
	boolean[] used;
	HashSet set = new HashSet();
    public List<List<Integer>> permuteUnique(int[] nums) {
		used = new boolean[nums.length];
		Arrays.sort(nums);
		dfs(nums);
		return result;
    }

	public void dfs(int[] nums){
		if(list.size() == nums.length){
/*			if(set.contains(list)){
				return;
			}
			set.add(list);*/
			result.add(new ArrayList<>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if(i != 0 && nums[i] == nums[i-1] && used[i - 1]){
				continue;
			}
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
