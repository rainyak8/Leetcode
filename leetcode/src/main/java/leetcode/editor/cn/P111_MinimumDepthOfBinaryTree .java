//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 10⁵] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1134 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的最小深度
 * @author DY
 * @date 2023-12-13 20:40:22
 */
class P111_MinimumDepthOfBinaryTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P111_MinimumDepthOfBinaryTree().new Solution();
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
	public int min = Integer.MAX_VALUE;
	public void createList(TreeNode root,int deep){
		if(root == null) return;
		deep++;

		if(resList.size() < deep){
			List<Integer> n = new ArrayList<>();
			resList.add(n);
		}
		resList.get(deep - 1).add(root.val);

		if(root.left == null && root.right == null && deep < min){
			min = deep;
		}
		createList(root.left,deep);
		createList(root.right, deep);

	}
    public int minDepth(TreeNode root) {
		if(root != null){
			createList(root,0);
			return min;
		}else{
			return 0;
		}
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
