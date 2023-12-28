//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。 
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics 数组 回溯 👍 1995 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * N 皇后
 * @author DY
 * @date 2023-12-28 21:52:49
 */
class P51_NQueens{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P51_NQueens().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	List<List<String>> res = new ArrayList<>();
	boolean[] usedCol, usedDiag45, usedDiag135;    // boolean数组中的每个元素代表一条直(斜)线
	public List<List<String>> solveNQueens(int n) {
		usedCol = new boolean[n];                  // 列方向的直线条数为 n
		usedDiag45 = new boolean[2 * n - 1];       // 45°方向的斜线条数为 2 * n - 1
		usedDiag135 = new boolean[2 * n - 1];      // 135°方向的斜线条数为 2 * n - 1
		//用于收集结果, 元素的index表示棋盘的row，元素的value代表棋盘的column
		int[] board = new int[n];
		backTracking(board, n, 0);
		return res;
	}
	private void backTracking(int[] board, int n, int row) {
		if (row == n) {
			//收集结果
			List<String> temp = new ArrayList<>();
			for (int i : board) {
				char[] str = new char[n];
				Arrays.fill(str, '.');
				str[i] = 'Q';
				temp.add(new String(str));
			}
			res.add(temp);
			return;
		}

		for (int col = 0; col < n; col++) {
			if (usedCol[col] | usedDiag45[row + col] | usedDiag135[row - col + n - 1]) {
				continue;
			}
			board[row] = col;
			// 标记该列出现过
			usedCol[col] = true;
			// 同一45°斜线上元素的row + col为定值, 且各不相同
			usedDiag45[row + col] = true;
			// 同一135°斜线上元素row - col为定值, 且各不相同
			// row - col 值有正有负, 加 n - 1 是为了对齐零点
			usedDiag135[row - col + n - 1] = true;
			// 递归
			backTracking(board, n, row + 1);
			usedCol[col] = false;
			usedDiag45[row + col] = false;
			usedDiag135[row - col + n - 1] = false;
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
