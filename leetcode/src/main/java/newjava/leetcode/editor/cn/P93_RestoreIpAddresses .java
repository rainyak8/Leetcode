//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
//排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅由数字组成 
// 
//
// Related Topics 字符串 回溯 👍 1371 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原 IP 地址
 * @author DY
 * @date 2023-12-26 14:12:35
 */
class P93_RestoreIpAddresses{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P93_RestoreIpAddresses().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public List<String> list = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
		dfs(s,0,0);
		return list;
    }

	public void dfs(String s,int index,int pointNum){
		if (pointNum == 3) {// 逗点数量为3时，分隔结束
			// 判断第四段⼦字符串是否合法，如果合法就放进result中
			if (isValid(s,index,s.length()-1)) {
				list.add(s);
			}
			return;
		}
		for (int i = index; i < s.length(); i++) {
			if (isValid(s, index, i)) {
				s = s.substring(0, i + 1) + "." + s.substring(i + 1);    //在str的后⾯插⼊⼀个逗点
				pointNum++;
				dfs(s, i + 2, pointNum);// 插⼊逗点之后下⼀个⼦串的起始位置为i+2 因为需要在字符串中加入了分隔符.
				pointNum--;// 回溯
				s = s.substring(0, i + 1) + s.substring(i + 2);// 回溯删掉逗点
			} else {
				break;
			}
		}
	}
	private Boolean isValid(String s, int start, int end) {
		if (start > end) {
			return false;
		}
		if (s.charAt(start) == '0' && start != end) {
			return false;
		}
		int num = 0;
		for (int i = start; i <= end; i++) {
			if (s.charAt(i) > '9' || s.charAt(i) < '0') {
				return false;
			}
			num = num * 10 + (s.charAt(i) - '0');
			if (num > 255) { // 如果⼤于255了不合法
				return false;
			}
		}
		return true;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
