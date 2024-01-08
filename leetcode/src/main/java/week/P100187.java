package week;

import java.util.*;

public class P100187 {
    class Solution {
        int[] che = new int[2];
        int[] xiang = new int[2];
        int[] queen = new int[2];
        int min_che = 0,min_xiang = 0;
        public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
            che = new int[]{a, b};
            xiang = new int[]{c, d};
            queen = new int[]{e, f};
            // 检查车和皇后是否在同一行或同一列
            if (che[0] == queen[0] || che[1] == queen[1]) {
                // 检查象是否在车和皇后之间
                if ((che[0] == queen[0]) && (che[0] == xiang[0]) && ((che[1] - queen[1] > 0 && xiang[1] - queen[1] > 0 && che[1] - xiang[1] > 0) || (che[1] - queen[1] < 0 && xiang[1] - queen[1] < 0 && che[1] - xiang[1] < 0))) {
                    min_che = 3;
                }
                // 检查象是否在车和皇后之间
                else if ((che[1] == queen[1]) && (che[1] == xiang[1]) && ((che[0] - queen[0] > 0 && xiang[0] - queen[0] > 0 && che[0] - xiang[0] > 0) || (che[0] - queen[0] < 0 && xiang[0] - queen[0] < 0 && che[0] - xiang[0] < 0))) {
                    min_che = 3;
                }// 若象在车和皇后之间，且车和皇后在同一行同一列，则车最少需要移动三次
                else {
                    min_che = 1;
                }
            }else{
                min_che = 2;
            }
            System.out.println("min_che = " + min_che);
            // 检查象和皇后是否在同一对角线上
            if (Math.abs(xiang[0] - queen[0]) == Math.abs(xiang[1] - queen[1])) {
                // 检查车是否在象和皇后之间
                if ((Math.abs(che[0] - queen[0]) == Math.abs(che[1] - queen[1])) && ((che[1] > xiang[1] && che[1] < queen[1]) || (che[1] < xiang[1] && che[1] > queen[1]))&& ((che[0] > xiang[0] && che[0] < queen[0]) || (che[0] < xiang[0] && che[0] > queen[0]))) {
                        min_xiang = 3;
                } else {
                    // 车不在象和皇后之间
                    min_xiang = 1;
                }
            } else {
                // 象和皇后不在同一对角线上
                min_xiang = 2;
            }
            System.out.println("min_xiang = " + min_xiang);
            return Math.min(min_xiang, min_che);
        }
    }
}
