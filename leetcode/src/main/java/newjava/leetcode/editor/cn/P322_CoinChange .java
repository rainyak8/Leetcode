//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数组 动态规划 👍 2677 👎 0


package leetcode.editor.cn;

/**
 * 零钱兑换
 * @author DY
 * @date 2024-01-12 13:47:35
 */
class P322_CoinChange{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P322_CoinChange().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int coinChange(int[] coins, int amount) {
		int max = Integer.MAX_VALUE;
		int[] dp = new int[amount + 1];
		//初始化dp数组为最大值
		for (int j = 0; j < dp.length; j++) {
			dp[j] = max;
		}
		//当金额为0时需要的硬币数目为0
		dp[0] = 0;
		for (int i = 0; i < coins.length; i++) {
			//正序遍历：完全背包每个硬币可以选择多次
			for (int j = coins[i]; j <= amount; j++) {
				//只有dp[j-coins[i]]不是初始最大值时，该位才有选择的必要
				if (dp[j - coins[i]] != max) {
					//选择硬币数目最小的情况
					dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
				}
			}
		}
		return dp[amount] == max ? -1 : dp[amount];
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
