//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// Related Topics 递归 链表 👍 2097 👎 0


package leetcode.editor.cn;

/**
 * 两两交换链表中的节点
 * @author DY
 * @date 2023-12-02 11:24:57
 */
class P24_SwapNodesInPairs{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P24_SwapNodesInPairs().new Solution();
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
    public ListNode swapPairs(ListNode head) {
		ListNode virtualHead = new ListNode();
		ListNode virtualHead1 = new ListNode();
		ListNode temp1 = new ListNode();
		ListNode temp2 = new ListNode();
		ListNode temp3 = new ListNode();
		virtualHead.next = head;
		virtualHead1.next = virtualHead;
		while(true){
			//System.out.println(virtualHead.val);
			if(virtualHead.next == null || virtualHead.next.next == null){
				break;
			}
			temp1 = virtualHead.next;
			temp2 = virtualHead.next.next;
			temp3 = virtualHead.next.next.next;
			temp1.next = temp3;
			temp2.next = temp1;
			virtualHead.next = temp2;

			virtualHead = temp1;
			//System.out.println(virtualHead.val);
		}
        return virtualHead1.next.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
