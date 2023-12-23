//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 1767 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字母异位词分组
 * @author DY
 * @date 2023-12-23 11:52:19
 */
class P49_GroupAnagrams{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P49_GroupAnagrams().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();//建立哈希MAP String作为key List<String>为值
		for (String str:strs) {
			char[] array = str.toCharArray();//把str化为数组
			Arrays.sort(array);//排序数组
			String key = new String(array);//得到数组的key
			List<String> list = map.getOrDefault(key, new ArrayList<String>());//查询该key是否有list列表 若无 新建一个
			list.add(str);//加入到上一步找到的list中
			map.put(key, list);//更新map
		}
		return new ArrayList<List<String>>(map.values());//返回map
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
