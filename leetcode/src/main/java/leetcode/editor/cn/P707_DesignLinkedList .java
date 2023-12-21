//你可以选择使用单链表或者双链表，设计并实现自己的链表。 
//
// 单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。 
//
// 如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。 
//
// 实现 MyLinkedList 类：
//
//
// MyLinkedList() 初始化 MyLinkedList 对象。
// int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
// void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
// void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
// void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果
//index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
// void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
//
//
//
//
// 示例：
//
//
//输入
//["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get",
//"deleteAtIndex", "get"]
//[[], [1], [3], [1, 2], [1], [1], [1]]
//输出
//[null, null, null, null, 2, null, 3]
//
//解释
//MyLinkedList myLinkedList = new MyLinkedList();
//myLinkedList.addAtHead(1);
//myLinkedList.addAtTail(3);
//myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
//myLinkedList.get(1);              // 返回 2
//myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
//myLinkedList.get(1);              // 返回 3
//
//
//
//
// 提示：
//
//
// 0 <= index, val <= 1000
// 请不要使用内置的 LinkedList 库。
// 调用 get、addAtHead、addAtTail、addAtIndex 和 deleteAtIndex 的次数不超过 2000 。
//
//
// Related Topics 设计 链表 👍 968 👎 0


package leetcode.editor.cn;

/**
 * 设计链表
 * @author DY
 * @date 2023-12-01 20:46:15
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class P707_DesignLinkedList{
	 public void main(String[] args) {
         MyLinkedList myLinkedList = new MyLinkedList();
         myLinkedList.addAtHead(7);
         myLinkedList.addAtHead(2);
         myLinkedList.addAtHead(1);
         myLinkedList.addAtIndex(3, 0);
         myLinkedList.deleteAtIndex(2);
         myLinkedList.addAtHead(6);
         myLinkedList.addAtTail(4);
         System.out.println(myLinkedList.get(4));
/*         myLinkedList.addAtHead(4);
         myLinkedList.addAtIndex(5, 0);
         myLinkedList.addAtHead(6);
         myLinkedList.addAtHead(1);
         myLinkedList.addAtTail(3);
         myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
         System.out.println(myLinkedList.get(1));
         myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
         System.out.println(myLinkedList.get(1));
         myLinkedList.addAtHead(1);
         myLinkedList.addAtTail(3);
         myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
         System.out.println(myLinkedList.get(1));
         myLinkedList.deleteAtIndex(0);    // 现在，链表变为 1->3
         System.out.println(myLinkedList.get(0));*/
	 }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class MyLinkedList {
    int size;
    ListNode listnow;
    public MyLinkedList() {
        size = 0;
        listnow = new ListNode(0);
    }

    public int get(int index) {
        int i = 0;
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode list = listnow;
        for ( i = 0; i < index; i++) {
            list = list.next;
        }
        return list.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if(index > size) {
            return;
        }
        if(index < 0) {
            index = 0;
        }
        if(size == 0){
            listnow.val = val;
            size++;
        }else if(index == 0){
            ListNode list = new ListNode(0);
            list.val = val;
            list.next = listnow;
            listnow = list;
            size++;
        }else if(index == size){
            ListNode list = new ListNode(0);
            ListNode list1 = new ListNode(0);
            list1.val = val;
            list1.next = null;
            list.next = listnow;
            while(list.next != null){
                list = list.next;
            }
            list.next = list1;
            size++;
        }else{
            ListNode list = listnow;
            for (int i = 0; i < index-1; i++) {
                list = list.next;
            }
            ListNode temp = new ListNode(val);
            temp.next = list.next;
            list.next = temp;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if(index == 0){
            size--;
            listnow = listnow.next;
        }else{
            size--;
            int i;
            ListNode list = listnow;
            for (i = 0; i < index-1; i++) {
                list = list.next;
            }
            list.next = list.next.next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
