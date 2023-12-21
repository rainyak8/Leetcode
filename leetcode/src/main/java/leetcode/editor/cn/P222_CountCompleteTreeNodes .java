//给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。 
//
// 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层
//为第 h 层，则该层包含 1~ 2ʰ 个节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,4,5,6]
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是[0, 5 * 10⁴] 
// 0 <= Node.val <= 5 * 10⁴ 
// 题目数据保证输入的树是 完全二叉树 
// 
//
// 
//
// 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？ 
//
// Related Topics 位运算 树 二分查找 二叉树 👍 1066 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 完全二叉树的节点个数
 * @author DY
 * @date 2023-12-14 20:33:59
 */
class P222_CountCompleteTreeNodes{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P222_CountCompleteTreeNodes().new Solution();
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
	public int res;
	public void createList(TreeNode root,int deep){
		if(root == null) return;
		deep++;

		if(resList.size() < deep){
			List<Integer> n = new ArrayList<>();
			resList.add(n);
		}
		resList.get(deep - 1).add(root.val);
		res++;
		createList(root.left,deep);
		createList(root.right, deep);

	}
    public int countNodes(TreeNode root) {
		if(root != null){
			createList(root,0);
			return res;
		}else{
			return 0;
		}
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
