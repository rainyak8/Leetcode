//给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入: root = [1,3,2,5,3,null,9]
//输出: [1,3,9]
// 
//
// 示例2： 
//
// 
//输入: root = [1,2,3]
//输出: [1,3]
// 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点个数的范围是 [0,10⁴] 
// 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 347 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 在每个树行中找最大值
 * @author DY
 * @date 2023-12-13 19:47:42
 */
class P515_FindLargestValueInEachTreeRow{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P515_FindLargestValueInEachTreeRow().new Solution();
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

    public List<Integer> largestValues(TreeNode root) {
		checkFun01(root,0);
		List<Integer> resList1 = new ArrayList<>();
		for (List<Integer> u: resList) {
			int max = Integer.MIN_VALUE;
			for (int i:u) {
				if(i > max)
					max = i;
			}
			resList1.add(max);
		}
		return resList1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
