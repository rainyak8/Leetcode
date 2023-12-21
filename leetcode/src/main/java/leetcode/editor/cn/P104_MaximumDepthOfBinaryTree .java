//给定一个二叉树 root ，返回其最大深度。 
//
// 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：root = [1,null,2]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数量在 [0, 10⁴] 区间内。 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1754 👎 0


package leetcode.editor.cn;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的最大深度
 * @author DY
 * @date 2023-12-13 20:32:41
 */
class P104_MaximumDepthOfBinaryTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P104_MaximumDepthOfBinaryTree().new Solution();
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

	public void createList(TreeNode root,int deep){
		if(root == null) return;
		deep++;

		if(resList.size() < deep){
			List<Integer> n = new ArrayList<>();
			resList.add(n);
		}
		resList.get(deep - 1).add(root.val);

		createList(root.left,deep);
		createList(root.right, deep);

	}
    public int maxDepth(TreeNode root) {
		createList(root,0);
		return resList.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
