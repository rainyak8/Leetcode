//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。 
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,10⁴] 
// 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 549 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 找树左下角的值
 * @author DY
 * @date 2023-12-16 20:49:09
 */
class P513_FindBottomLeftTreeValue{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P513_FindBottomLeftTreeValue().new Solution();
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
    public int findBottomLeftValue(TreeNode root) {
		createList(root,0);
		int len = resList.size();
		return resList.get(len-1).get(0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
