//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// Related Topics 回溯 👍 1557 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 * @author DY
 * @date 2023-12-22 17:37:15
 */
class P77_Combinations{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P77_Combinations().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public List<List<Integer>> re = new ArrayList<>();
	public List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
		backtracking(n, k, 1);
		return re;
    }

	public void backtracking(int n, int k, int index) {
		if(list.size() == k){
			re.add(new ArrayList<>(list));
			return;
		}
		for (int i = index;i <= n - (k - list.size()) + 1;i++) {
			list.add(i);
			backtracking(n, k, i+1); // 递归
			list.remove(list.size()-1);
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
