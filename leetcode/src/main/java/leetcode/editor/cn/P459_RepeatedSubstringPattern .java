//给定一个非空的字符串
// s ，检查是否可以通过由它的一个子串重复多次构成。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abab"
//输出: true
//解释: 可由子串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: s = "aba"
//输出: false
// 
//
// 示例 3: 
//
// 
//输入: s = "abcabcabcabc"
//输出: true
//解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
//
// Related Topics 字符串 字符串匹配 👍 1096 👎 0


package leetcode.editor.cn;

/**
 * 重复的子字符串
 * @author DY
 * @date 2023-12-07 17:30:22
 */
class P459_RepeatedSubstringPattern{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P459_RepeatedSubstringPattern().new Solution();
		 String s = "babbbbaabbbabbbbaabbbabbbbaabbbabbbbaabbbabbbbaabbbabbbbaabbbabbbbaabbbabbbbaabbbabbbbaabbbabbbbaabb";
		 System.out.println("solution.repeatedSubstringPattern(s) = " + solution.repeatedSubstringPattern(s));
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int[] getNext(int[] next, String s) {
		int j = 0;
		next[0] = 0;
		for(int i = 1; i < s.length(); i++) {
			while (j > 0 && s.charAt(i) != s.charAt(j)) {
				j = next[j - 1];
			}
			if (s.charAt(i) == s.charAt(j)) {
				j++;
			}
			next[i] = j;
		}
		return next;
	}
	public boolean repeatedSubstringPattern(String s) {
		int len = s.length();
		if(len == 1){
			return false;
		}
		int[] next = getNext(new int[len],s);
		int max = 0;
		int halfLen = len / 2;
		for (int i = 1; i < len; i++) {
			if(next[i] > max){
				max = next[i];
			}else if(i == len - 1 && next[i] < max){
				return false;
			}
		}
		return max >= halfLen && (len % 2 == 0 || max == len - 1 || max > halfLen + 1);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
