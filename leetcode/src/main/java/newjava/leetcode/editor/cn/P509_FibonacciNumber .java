//斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// 
//F(0) = 0，F(1) = 1
//F(n) = F(n - 1) + F(n - 2)，其中 n > 1
// 
//
// 给定 n ，请计算 F(n) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 30 
// 
//
// Related Topics 递归 记忆化搜索 数学 动态规划 👍 729 👎 0


package leetcode.editor.cn;

/**
 * 斐波那契数
 * @author DY
 * @date 2024-01-05 14:16:22
 */
class P509_FibonacciNumber{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P509_FibonacciNumber().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib(int n) {
		if(n == 0){
			return 0;
		}
		int[] a = new int[n + 1];
		a[0] = 0;
		a[1] = 1;
		for (int i = 2; i <= n; i++) {
			a[i] = a[i - 1] + a[i - 2];
		}
		return a[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
