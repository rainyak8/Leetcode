//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 2633 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口最大值
 * @author DY
 * @date 2023-12-12 16:04:37
 */
class P239_SlidingWindowMaximum{
	 public static void main(String[] args) {
		 int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
		 int k = 3;
	 	 //测试代码
	 	 Solution solution = new P239_SlidingWindowMaximum().new Solution();
		 System.out.println("solution.maxSlidingWindow(nums,k) = " + Arrays.toString(solution.maxSlidingWindow(nums, k)));
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 1) {
			return nums;
		}
		int len = nums.length - k + 1;
		int[] res = new int[len];
		int num = 0;
		Queuea queue = new Queuea();
		for (int i = 0; i < k; i++) {
			queue.add(nums[i]);
		}
		res[num++] = queue.peek();
		for (int i = k; i < nums.length; i++) {
			queue.poll(nums[i - k]);
			queue.add(nums[i]);
			res[num++] = queue.peek();
		}
		return res;
	}
}

class Queuea {
		Deque<Integer> que = new LinkedList<>();
		// 每次弹出的时候，比较当前要弹出的数值是否等于队列出口元素的数值，如果相等则弹出。
		// 同时pop之前判断队列当前是否为空。
		void poll(int value) {
			if (!que.isEmpty() && value == que.peek()) {
				que.poll();
			}
		}
		// 如果push的数值大于入口元素的数值，那么就将队列后端的数值弹出，直到push的数值小于等于队列入口元素的数值为止。
		// 这样就保持了队列里的数值是单调从大到小的了。
		void add(int value) {
			while (!que.isEmpty() && value > que.getLast()) {
				que.removeLast();
			}
			que.add(value);
		}
		// 查询当前队列里的最大值 直接返回队列前端也就是front就可以了。
		int peek() {
			return que.peek();
		}
	};
//leetcode submit region end(Prohibit modification and deletion)

}
