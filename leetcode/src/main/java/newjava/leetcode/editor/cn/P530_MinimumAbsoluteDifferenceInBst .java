//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。 
//
// 差值是一个正数，其数值等于两值之差的绝对值。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [4,2,6,1,3]
//输出：1
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,0,48,null,null,12,49]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [2, 10⁴] 
// 0 <= Node.val <= 10⁵ 
// 
//
// 
//
// 注意：本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-
//nodes/ 相同 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树 👍 530 👎 0


package leetcode.editor.cn;

import static java.lang.Math.abs;

/**
 * 二叉搜索树的最小绝对差
 * @author DY
 * @date 2023-12-19 13:42:19
 */
class P530_MinimumAbsoluteDifferenceInBst{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P530_MinimumAbsoluteDifferenceInBst().new Solution();
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
	TreeNode pre;// 记录上一个遍历的结点
	int min = Integer.MAX_VALUE;
	public int getMinimumDifference(TreeNode root) {
		if(root==null)return 0;
		traversal(root);
		return min;
	}
	public void traversal(TreeNode root){
		if(root==null)return;
		//左
		traversal(root.left);
		//中
		if(pre!=null){
			min = Math.min(min,root.val-pre.val);
		}
		pre = root;
		//右
		traversal(root.right);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
