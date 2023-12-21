//给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下： 
//
// 
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。 
//
// 初始状态下，所有 next 指针都被设置为 NULL。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,6,7]
//输出：[1,#,2,3,#,4,5,6,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 
//next 指针连接，'#' 标志着每一层的结束。
// 
//
// 
// 
//
// 示例 2: 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数量在
// [0, 2¹² - 1] 范围内 
// -1000 <= node.val <= 1000 
// 
//
// 
//
// 进阶： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 链表 二叉树 👍 1076 👎 0


package leetcode.editor.cn;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 填充每个节点的下一个右侧节点指针
 * @author DY
 * @date 2023-12-13 19:56:01
 */
class P116_PopulatingNextRightPointersInEachNode{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P116_PopulatingNextRightPointersInEachNode().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)

// Definition for a Node.
/*class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};*/


class Solution {
	public List<List<Node>> resList = new ArrayList<List<Node>>();

	//DFS--递归方式
	public void checkFun01(Node node1, Integer deep) {
		if (node1 == null) return;
		deep++;

		if (resList.size() < deep) {
			//当层级增加时，list的Item也增加，利用list的索引值进行层级界定
			List<Node> item = new ArrayList<Node>();
			resList.add(item);
		}
		resList.get(deep - 1).add(node1);

		checkFun01(node1.left, deep);
		checkFun01(node1.right, deep);
	}
    public Node connect(Node root) {
		checkFun01(root,0);
		int len = 0;
		for (List<Node> u: resList) {
            len = u.size();
            int i;
            for (i = 0; i < len - 1; i++) {
                u.get(i).next = u.get(i + 1);
            }
            u.get(i).next = null;
        }
		return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
