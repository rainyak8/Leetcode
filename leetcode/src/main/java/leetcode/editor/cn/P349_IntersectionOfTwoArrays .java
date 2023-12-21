//给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//解释：[4,9] 也是可通过的
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
//
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 858 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 两个数组的交集
 * @author DY
 * @date 2023-12-04 13:26:24
 */
class P349_IntersectionOfTwoArrays{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P349_IntersectionOfTwoArrays().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
		if(nums1 == null || nums2 == null){
			return null;
		}
		if(nums1.length == 0 || nums2.length == 0){
			return null;
		}
        Set<Integer> set = new HashSet<>(Arrays.stream(nums1).boxed().toList());
		Set<Integer> reset = new HashSet<>();
		for(int i = 0;i<nums2.length;i++){
			if(set.contains(nums2[i])){
				reset.add(nums2[i]);
			}
		}
		int[] resets = new int[reset.size()];
		int i = 0;
		for (int num:reset) {
			resets[i++] = num;
		}
		return resets;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
