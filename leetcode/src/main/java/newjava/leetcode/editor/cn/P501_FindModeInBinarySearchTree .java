//给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。 
//
// 如果树中有不止一个众数，可以按 任意顺序 返回。 
//
// 假定 BST 满足如下定义： 
//
// 
// 结点左子树中所含节点的值 小于等于 当前节点的值 
// 结点右子树中所含节点的值 大于等于 当前节点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 718 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;

/**
 * 二叉搜索树中的众数
 * @author DY
 * @date 2023-12-19 14:07:37
 */
class P501_FindModeInBinarySearchTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P501_FindModeInBinarySearchTree().new Solution();
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
	public int size = 0,maxSize = 0;
	ArrayList<Integer> var = new ArrayList<Integer>();
	public TreeNode pre;
    public int[] findMode(TreeNode root) {
		if(root == null)
			return null;
		findMode1(root);
		int[] res = new int[var.size()];
		for (int i = 0; i < var.size(); i++) {
			res[i] = var.get(i);
		}
		return res;
    }

	public void findMode1(TreeNode root){
		if(root == null){
			return;
		}
		findMode1(root.left);
		if (pre == null) { // 第一个节点
			size = 1; // 频率为1
		} else if (pre.val == root.val) { // 与前一个节点数值相同
			size++;
		} else { // 与前一个节点数值不同
			size = 1;
		}
		// 更新结果以及maxCount
		if (size > maxSize) {
			var.clear();
			var.add(root.val);
			maxSize = size;
		} else if (size == maxSize) {
			var.add(root.val);
		}
		pre = root;
		findMode1(root.right);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
