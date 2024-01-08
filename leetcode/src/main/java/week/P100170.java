package week;

public class P100170 {
    class Solution {
        public int areaOfMaxDiagonal(int[][] dimensions) {
            if(dimensions.length == 1){
                return dimensions[0][0] * dimensions[0][1];
            }
            double max = Math.sqrt(dimensions[0][0]*dimensions[0][0]+dimensions[0][1]*dimensions[0][1]),max1 = 0;
            int max_index = 0,maxs = dimensions[0][0] * dimensions[0][1];
            for (int i = 1; i < dimensions.length; i++) {
                max1 = Math.sqrt(dimensions[i][0]*dimensions[i][0]+dimensions[i][1]*dimensions[i][1]);
                if(max1 == max){
                    if(dimensions[i][0] * dimensions[i][1] > maxs){
                        maxs = dimensions[i][0] * dimensions[i][1];
                        max_index = i;
                    }
                }
                if(max1 > max){
                    maxs = dimensions[i][0] * dimensions[i][1];
                    max = max1;
                    max_index = i;
                }
            }
            return maxs;
        }
    }
}
