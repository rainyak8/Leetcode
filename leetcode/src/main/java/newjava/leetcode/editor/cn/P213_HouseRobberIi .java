//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
//房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 👍 1551 👎 0


package leetcode.editor.cn;

/**
 * 打家劫舍 II
 * @author DY
 * @date 2024-01-15 13:27:18
 */
class P213_HouseRobberIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P213_HouseRobberIi().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
		//这道题不好判断环，可以另辟蹊径
		//即分成两个部分 一个去掉首部 一个去掉尾部 找到这两个的MAX，判断去掉那个更好
		if(nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];
		int result1 = robR(nums,0,nums.length-2);
		int result2 = robR(nums,1,nums.length-1);
		return Math.max(result1,result2);
    }

	public int robR(int[]nums,int begin,int end){
		if(begin == end) return nums[begin];
		int[] dp = new int[nums.length];
		dp[begin] = nums[begin];
		dp[begin + 1] = Math.max(nums[begin],nums[begin + 1]);
		for (int i = begin + 2; i <= end; i++) {
			dp[i] = Math.max(dp[i - 2] + nums[i],dp[i - 1]);
		}
		return dp[end];
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
