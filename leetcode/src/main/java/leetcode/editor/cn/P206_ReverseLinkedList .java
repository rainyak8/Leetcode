//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
//
// Related Topics 递归 链表 👍 3427 👎 0


package leetcode.editor.cn;

/**
 * 反转链表
 * @author DY
 * @date 2023-12-01 23:58:46
 */
class P206_ReverseLinkedList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P206_ReverseLinkedList().new Solution();
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
class Solution {
	int deep = 0;
	ListNode ReverList;
	public ListNode reverseList(ListNode head) {
		ReverList = head;
		ListNode ReverList1 = null;
		while(true){
			if(ReverList != null){
				deep++;
				ReverList1 = ReverList;
				ReverList = ReverList.next;
			}else{
				break;
			}
		}
		if(deep > 0){
			if(deep == 1){
				return ReverList1;
			}else{
				ReverList = ReverList1;
				ReverList1.next = ReverList;
				for (int i = deep; i > 0; i--) {
					ReverList.next = reverseList1(head,i);
					System.out.println(ReverList.val+" "+i);
					ReverList = ReverList.next;
				}
			}
		}
		return ReverList1;
	}

	public ListNode reverseList1(ListNode head,int deep1) {
		ListNode head1;
		head1 = head;
		for (int i = 0; i < deep1 - 1; i++) {
			head1 = head1.next;
		}
		head1.next = null;
		return head1;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
