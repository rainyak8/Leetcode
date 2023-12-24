package week;

import java.util.Arrays;

public class P100169 {
    class Solution {
        public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
            //1. 通过hFences 与 vFences构建出可能的边长
            if(m-1 == n-1){
                return (n-1) * (n-1) % 1000000007;
            }
            Arrays.sort(hFences);
            Arrays.sort(vFences);
            Set<Integer> setH = new HashSet<Integer>();
            Set<Integer> setV = new HashSet<Integer>();
            setH.add(m-1);
            setV.add(n-1);
            for(int i = 0; i<hFences.length; i++){
                int left = hFences[i] -1;
                int right = m - hFences[i];
                setH.add(left);
                setH.add(right);
                for(int j = i+1; j<hFences.length; j++){
                    int len = hFences[j] - hFences[i];
                    setH.add(len);
                }
            }



            for(int i = 0; i<vFences.length; i++){
                int left = vFences[i] -1;
                int right = n - vFences[i];
                setV.add(left);
                setV.add(right);
                for(int j = i+1; j<vFences.length; j++){
                    int len = vFences[j] - vFences[i];
                    setV.add(len);
                }
            }

            // 获取边的交集
            setH.retainAll(setV);
            if(setH.isEmpty()){
                return -1;
            }
            else{
                long res = 1;
                for(int num : setH){
                    res = Math.max(res, num);
                }
                return (int)(res*res%1000000007);
            }

        }
    }
}
