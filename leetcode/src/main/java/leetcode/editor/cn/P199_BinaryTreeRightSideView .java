//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: [1,2,3,null,5,null,4]
//输出: [1,3,4]
// 
//
// 示例 2: 
//
// 
//输入: [1,null,3]
//输出: [1,3]
// 
//
// 示例 3: 
//
// 
//输入: []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,100] 
// 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1004 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 二叉树的右视图
 * @author DY
 * @date 2023-12-13 19:25:02
 */
class P199_BinaryTreeRightSideView{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P199_BinaryTreeRightSideView().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
	public List<List<Integer>> resList = new ArrayList<List<Integer>>();

	//DFS--递归方式
	public void checkFun01(TreeNode node, Integer deep) {
		if (node == null) return;
		deep++;

		if (resList.size() < deep) {
			//当层级增加时，list的Item也增加，利用list的索引值进行层级界定
			List<Integer> item = new ArrayList<Integer>();
			resList.add(item);
		}
		resList.get(deep - 1).add(node.val);

		checkFun01(node.left, deep);
		checkFun01(node.right, deep);
	}
    public List<Integer> rightSideView(TreeNode root) {

		List<Integer> resList1 = new ArrayList<>();
		checkFun01(root,0);
		int len = resList.size();
		for (int i = 0; i < len; i++) {
			resList1.add(resList.get(i).get(resList.get(i).size()-1));
		}
		return resList1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
