//给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。 
//
// 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。 
//
// 返回一个表示每个字符串片段的长度的列表。 
//
// 
//示例 1：
//
// 
//输入：s = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。 
//
// 示例 2： 
//
// 
//输入：s = "eccbbbbdec"
//输出：[10]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 贪心 哈希表 双指针 字符串 👍 1077 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 划分字母区间
 * @author DY
 * @date 2024-01-03 13:46:13
 */
class P763_PartitionLabels{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P763_PartitionLabels().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> partitionLabels(String s) {
		int[] last = new int[26];
		for (int i = 0;i < s.length();i++) {
			last[s.charAt(i) - 'a'] = i;
		}
		int start = 0,end = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 0;i < s.length();i++) {
			end = Math.max(end, last[s.charAt(i) - 'a']);
			if(i == end){
				list.add(end - start + 1);
				start = end + 1;
			}
		}
		return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
