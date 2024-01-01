//给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。 
//
// 输入为三个整数：day、month 和 year，分别表示日、月、年。 
//
// 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", 
//"Friday", "Saturday"}。 
//
// 
//
// 示例 1： 
//
// 输入：day = 31, month = 8, year = 2019
//输出："Saturday"
// 
//
// 示例 2： 
//
// 输入：day = 18, month = 7, year = 1999
//输出："Sunday"
// 
//
// 示例 3： 
//
// 输入：day = 15, month = 8, year = 1993
//输出："Sunday"
// 
//
// 
//
// 提示： 
//
// 
// 给出的日期一定是在 1971 到 2100 年之间的有效日期。 
// 
//
// Related Topics 数学 👍 160 👎 0


package leetcode.editor.cn;

import java.time.LocalDate;

/**
 * 一周中的第几天
 * @author DY
 * @date 2023-12-30 19:53:26
 */
class P1185_DayOfTheWeek{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1185_DayOfTheWeek().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
import java.time.LocalDate;
class Solution {
	private String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

	public String dayOfTheWeek(int day, int month, int year) {
		LocalDate date = LocalDate.of(year, month, day);
		return week[date.getDayOfWeek().getValue() % 7];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
