//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics 位运算 数组 回溯 👍 2211 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 子集
 * @author DY
 * @date 2023-12-26 14:34:27
 */
class P78_Subsets{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P78_Subsets().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public List<List<Integer>> result = new ArrayList<>();
	public List<Integer> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
		result.add(new ArrayList<>());
		dfs(nums,0);
		return result;
    }

	public void dfs(int[] nums,int index){
		if(index >= nums.length){
			return;
		}
		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			//System.out.println("list = " + list);
			result.add(new ArrayList<>(list));
			dfs(nums,i+1);
			list.remove(list.size()-1);
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
