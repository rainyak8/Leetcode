//编写一个算法来判断一个数 n 是不是快乐数。 
//
// 「快乐数」 定义为： 
//
// 
// 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。 
// 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。 
// 如果这个过程 结果为 1，那么这个数就是快乐数。 
// 
//
// 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 19
//输出：true
//解释：
//1² + 9² = 82
//8² + 2² = 68
//6² + 8² = 100
//1² + 0² + 0² = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
//
// Related Topics 哈希表 数学 双指针 👍 1476 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数
 * @author DY
 * @date 2023-12-04 13:41:26
 */
class P202_HappyNumber{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P202_HappyNumber().new Solution();
		 System.out.println(solution.isHappy(1563712132));
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int sumN(int n){
		int sum = 0;
		long t = 1;
		while(n >= t){
			sum += ((n/t)%10) * ((n/t)%10);
			t *= 10;
		}
		return sum;
	}

    public boolean isHappy(int n) {
		Set<Integer> nsum = new HashSet<>();
		while(n != 1 && !nsum.contains(n)){
			nsum.add(n);
			n = sumN(n);
			//System.out.println("nsum = " + nsum);
		}
		if(n == 1){
			return true;
		}else{
			return false;
		}
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
