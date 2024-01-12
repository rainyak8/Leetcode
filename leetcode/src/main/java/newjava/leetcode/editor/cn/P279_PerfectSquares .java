//给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。 
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：3 
//解释：12 = 4 + 4 + 4 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：2
//解释：13 = 4 + 9 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数学 动态规划 👍 1889 👎 0


package leetcode.editor.cn;

/**
 * 完全平方数
 * @author DY
 * @date 2024-01-12 13:48:42
 */
class P279_PerfectSquares{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P279_PerfectSquares().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	// 版本二， 先遍历背包, 再遍历物品
	public int numSquares(int n) {
		int max = Integer.MAX_VALUE;
		int[] dp = new int[n + 1];
		// 初始化
		for (int j = 0; j <= n; j++) {
			dp[j] = max;
		}
		// 当和为0时，组合的个数为0
		dp[0] = 0;
		// 遍历背包
		for (int j = 1; j <= n; j++) {
			// 遍历物品
			for (int i = 1; i * i <= j; i++) {
				dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
			}
		}
		return dp[n];
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
