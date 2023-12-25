//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 1700 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 分割回文串
 * @author DY
 * @date 2023-12-25 17:05:49
 */
class P131_PalindromePartitioning{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P131_PalindromePartitioning().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public List<List<String>> result = new ArrayList<>();
	public List<String> list = new ArrayList<>();
    public List<List<String>> partition(String s) {
		dfs(s,0);
		return result;
    }

	public void dfs(String s,int index){
		if (index >= s.length()) {
			result.add(new ArrayList<>(list));
			return;
		}
		for (int i = index; i < s.length(); i++) {
			String str = s.substring(index,i + 1);
			//System.out.println("str = " + str);
			if(Objects.equals(reverse(str), str)){
				list.add(str);
			}else{
				continue;
			}
			dfs(s,i+1);
			list.remove(list.size()-1);
		}
	}

	public String reverse(String str){
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		return sb.toString();
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
