//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 1965 👎 0


package leetcode.editor.cn;

/**
 * 分割等和子集
 * @author DY
 * @date 2024-01-05 18:06:40
 */
class P416_PartitionEqualSubsetSum{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P416_PartitionEqualSubsetSum().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public boolean canPartition(int[] nums) {
		if(nums == null || nums.length == 0) return false;
		int n = nums.length;
		int sum = 0;
		for(int num : nums) {
			sum += num;
		}
		//总和为奇数，不能平分
		if(sum % 2 != 0) return false;
		int target = sum / 2;
		int[] dp = new int[target + 1];
		for(int i = 0; i < n; i++) {
			for(int j = target; j >= nums[i]; j--) {
				//物品 i 的重量是 nums[i]，其价值也是 nums[i]
				dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
			}

			//剪枝一下，每一次完成內層的for-loop，立即檢查是否dp[target] == target，優化時間複雜度（26ms -> 20ms）
			if(dp[target] == target)
				return true;
		}
		return dp[target] == target;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
