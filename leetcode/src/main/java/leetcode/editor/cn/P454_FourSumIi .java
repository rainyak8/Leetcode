//给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足： 
//
// 
// 0 <= i, j, k, l < n 
// nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
//输出：2
//解释：
//两个元组如下：
//1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1)
// + 2 = 0
//2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1)
// + 0 = 0
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == nums1.length 
// n == nums2.length 
// n == nums3.length 
// n == nums4.length 
// 1 <= n <= 200 
// -2²⁸ <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2²⁸ 
// 
//
// Related Topics 数组 哈希表 👍 936 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 四数相加 II
 * @author DY
 * @date 2023-12-05 14:44:36
 */
class P454_FourSumIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P454_FourSumIi().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0,i =0, j = 0,sum = 0,value = 0;
		for(i = 0;i < nums1.length; i++){
			for (j = 0;j < nums2.length; j++) {
				sum = nums1[i] + nums2[j];
				if(map.get(sum) != null){
					value = map.get(sum) + 1;
					map.put(sum,value);
				}else{
					map.put(sum,1);
				}
			}
		}
		for(i = 0;i < nums3.length; i++){
			for (j = 0;j < nums4.length; j++) {
				sum = nums3[i] + nums4[j];
				if(map.containsKey(-sum)){
					count += map.get(-sum);
				}
			}
		}
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
