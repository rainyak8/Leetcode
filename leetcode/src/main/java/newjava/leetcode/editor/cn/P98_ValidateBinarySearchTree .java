//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。 
//
// 有效 二叉搜索树定义如下： 
//
// 
// 节点的左子树只包含 小于 当前节点的数。 
// 节点的右子树只包含 大于 当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [2,1,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在[1, 10⁴] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 2233 👎 0


package leetcode.editor.cn;

/**
 * 验证二叉搜索树
 * @author DY
 * @date 2023-12-18 14:34:30
 */
class P98_ValidateBinarySearchTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P98_ValidateBinarySearchTree().new Solution();
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
	TreeNode pre = null; // 用来记录前一个节点
	public boolean flag1 = true,flag2 = true;
    public boolean isValidBST(TreeNode root) {

		if(root.left != null){
			if(root.left.val >= root.val){
				return false;
			}
			flag1 = isValidBST(root.left);
		}
		if (pre != null && pre.val >= root.val) return false;
		pre = root; // 记录前一个节点
		if(root.right != null){
			if(root.right.val <= root.val){
				return false;
			}
			flag2 = isValidBST(root.right);
		}

		return flag1 && flag2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
