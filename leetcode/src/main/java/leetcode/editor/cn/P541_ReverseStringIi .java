//给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文组成 
// 1 <= k <= 10⁴ 
// 
//
// Related Topics 双指针 字符串 👍 557 👎 0


package leetcode.editor.cn;

import static java.lang.String.copyValueOf;

/**
 * 反转字符串 II
 * @author DY
 * @date 2023-12-06 08:43:01
 */
class P541_ReverseStringIi{
	 public static void main(String[] args) {
	 	 //测试代码
		 String s = "hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl";
		 int k = 39;
	 	 Solution solution = new P541_ReverseStringIi().new Solution();
		 System.out.println(solution.reverseStr(s,k));
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {
		int len = s.length(),left = 0,right = k-1;
		char[] x = s.toCharArray();
		if(len < k){
			right = len - 1;
			//System.out.println(x);
			x = reverseString(x,left,right);
            return new String(x);
		}
		while(left < len){
			if(right < len){
				s.getChars(left,right,x,left);
				x = reverseString(x,left,right);
				left += 2*k;
				right += 2*k;
			}else{
				s.getChars(left,len - 1,x,left);
				x = reverseString(x,left,len - 1);
				left += 2*k;
				right += 2*k;
			}
		}
		return new String(x);
    }

	public char[] reverseString(char[] s,int left,int right) {
		char temp;
		while(left < right){
			temp = s[left];
			s[left] = s[right];
			s[right] = temp;
			left++;
			right--;
		}
		return s;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
