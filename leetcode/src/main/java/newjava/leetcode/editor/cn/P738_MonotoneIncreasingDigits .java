//当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。 
//
// 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 10
//输出: 9
// 
//
// 示例 2: 
//
// 
//输入: n = 1234
//输出: 1234
// 
//
// 示例 3: 
//
// 
//输入: n = 332
//输出: 299
// 
//
// 
//
// 提示: 
//
// 
// 0 <= n <= 10⁹ 
// 
//
// Related Topics 贪心 数学 👍 443 👎 0


package leetcode.editor.cn;

/**
 * 单调递增的数字
 * @author DY
 * @date 2024-01-04 10:09:32
 */
class P738_MonotoneIncreasingDigits{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P738_MonotoneIncreasingDigits().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int monotoneIncreasingDigits(int n) {
		String s = String.valueOf(n);
		char[] chars = s.toCharArray();
		int start = s.length();
		for (int i = s.length() - 2; i >= 0; i--) {
			if(chars[i] > chars[i+1]){
				chars[i]--;
				start = i+1;
			}
		}
		for(int i = start;i < s.length();i++){
			chars[i] = '9';
		}
		return  Integer.parseInt(String.valueOf(chars));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
