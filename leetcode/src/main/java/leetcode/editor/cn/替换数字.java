package leetcode.editor.cn;
import java.util.*;
public class 替换数字 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String x = "";
        char[] sin = s.toCharArray();
        int count = 0;
        int len = sin.length;
        for(char q:sin){
            if(q <= '9' && q >= '0'){
                x = x + "number";
            }else{
                String str = new String(String.valueOf(q));
                x = x + str;
            }
        }
        System.out.println(x);
    }

}
