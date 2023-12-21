//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点数目在范围 [0, 10⁴] 内 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
//
// Related Topics 递归 链表 👍 1363 👎 0


package leetcode.editor.cn;

/**
 * 移除链表元素
 * @author DY
 * @date 2023-12-01 11:42:07
 */
class P203_RemoveLinkedListElements{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P203_RemoveLinkedListElements().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
	public ListNode removeElements(ListNode head, int val) {
		ListNode head1 = new ListNode();
		head1.next = head;
		ListNode head2 = head1;
		while (head2.next != null) {
			if (head2.next.val == val) {
				head2.next = head2.next.next;
			} else {
				head2 = head2.next;
			}
		}
		return head1.next;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
