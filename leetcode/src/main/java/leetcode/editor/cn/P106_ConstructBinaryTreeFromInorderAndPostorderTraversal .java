//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
// 
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1152 👎 0


package leetcode.editor.cn;

/**
 * 从中序与后序遍历序列构造二叉树
 * @author DY
 * @date 2023-12-16 23:02:56
 */
class P106_ConstructBinaryTreeFromInorderAndPostorderTraversal{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P106_ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
	Map<Integer, Integer> map;  // 方便根据数值查找位置
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) { // 用map保存中序序列的数值对应位置
			map.put(inorder[i], i);
		}

		return findNode(inorder,  0, inorder.length, postorder,0, postorder.length);  // 前闭后开
	}

	public TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
		// 参数里的范围都是前闭后开
		if (inBegin >= inEnd || postBegin >= postEnd) {  // 不满足左闭右开，说明没有元素，返回空树
			return null;
		}
		int rootIndex = map.get(postorder[postEnd - 1]);  // 找到后序遍历的最后一个元素在中序遍历中的位置
		TreeNode root = new TreeNode(inorder[rootIndex]);  // 构造结点
		int lenOfLeft = rootIndex - inBegin;  // 保存中序左子树个数，用来确定后序数列的个数
		root.left = findNode(inorder, inBegin, rootIndex,
				postorder, postBegin, postBegin + lenOfLeft);
		root.right = findNode(inorder, rootIndex + 1, inEnd,
				postorder, postBegin + lenOfLeft, postEnd - 1);

		return root;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
