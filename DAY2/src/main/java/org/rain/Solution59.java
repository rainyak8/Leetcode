package org.rain;

import java.util.Arrays;
import java.math.*;

public class Solution59 {
    static int val = 20;

    public int[][] generateMatrix(int n) {
        int[][] map = new int[n][n];
        int k = 1,i = 0,j = 0,w = n - 1,flag = 0,wj = 0,sum = 0,iflag = -1,jflag = -1;
        for (k = 1; k <= n; k++) {
            map[i][j] = k;
            j++;
        }
        j--;
        jflag = 1;
        for (k = n + 1; k <= n * n; k++) {
            if(wj == 2){
                wj = 0;
                w--;
            }
            if(flag == 0){
                if(iflag == 1){
                    i--;
                    sum++;
                }else{
                    i++;
                    sum++;
                }
                map[i][j] = k;
                if(sum >= w){
                    flag = 1;
                    wj++;
                    sum = 0;
                    if(iflag == -1){
                        iflag = 1;
                    }else{
                        iflag = -1;
                    }
                    continue;
                }
            }
            if(flag == 1){
                if(jflag == 1){
                    j--;
                    sum++;
                }else{
                    j++;
                    sum++;
                }
                map[i][j] = k;
                if(sum >= w){
                    flag = 0;
                    wj++;
                    sum = 0;
                    if(jflag == -1){
                        jflag = 1;
                    }else{
                        jflag = -1;
                    }
                }
            }
        }
        return map;
    }

    public static void main(String[] args) {
        Solution59 s = new Solution59();
        int[][] len = s.generateMatrix(val);
        System.out.println(Arrays.deepToString(len));
    }
}
