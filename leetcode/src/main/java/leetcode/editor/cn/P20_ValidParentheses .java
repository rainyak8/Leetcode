//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 4281 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * 有效的括号
 * @author DY
 * @date 2023-12-09 22:06:42
 */
class P20_ValidParentheses{
	 public static void main(String[] args) {
		 String s = "([)]";
	 	 //测试代码
	 	 Solution solution = new P20_ValidParentheses().new Solution();
		 System.out.println("solution.isValid(s) = " + solution.isValid(s));
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
		int len = s.length();
		Deque<Character> e = new LinkedList<>();
		char x;
		for (int i = 0; i < len; i++) {
			x = s.charAt(i);
			if(x == '('){
				e.push(')');
			}else if(x == '['){
				e.push(']');
			}else if(x == '{'){
				e.push('}');
			}else if(e.isEmpty()){
				return false;
			}else if(e.peek() != x){
				return false;
			}else{
				e.pop();
			}
		}
		return e.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
