package week;

import leetcode.editor.cn.P17_LetterCombinationsOfAPhoneNumber;

import java.util.Arrays;
import java.util.Collections;

public class P100148 {
    public static void main(String[] args) {
        //测试代码
        P100148.Solution solution = new P100148().new Solution();
        solution.numberGame(nums);
    }
    class Solution {
        public int[] numberGame(int[] nums) {
            Stack<Integer> stack = new Stack<>();
            int[] array = new int[nums.length];
            Integer[] integers = Arrays.stream(nums).boxed().toArray(Integer[]::new);
            Arrays.sort(integers, Collections.reverseOrder());
            nums = Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();
            for (int i = 0; i < array.length; i++) {
                stack.push(nums[i]);
            }
            // 打印栈中的元素
            for (int i = 0; i < array.length; i++) {
                array[i] = stack.pop();
            }
            return array;
        }
    }
}
