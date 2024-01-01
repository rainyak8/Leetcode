package week;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int maximumLength(String s) {
        //初始化一个HashMap数组count，每个HashMap对应一个从'a'到'z'的字符。每个HashMap中的键是相同字符的子字符串的长度，值是这个长度的频率。
        //因为其实只有26个字母组成的字符串，所有完全不用开那么大的哈希
        HashMap<Integer,Integer>[] count = new HashMap[26];
        for(int i = 0;i<26;i++) count[i] = new HashMap<>();
        int i = 1;
        //初始化前一个字符pre为字符串s的第一个字符，长度l为1。
        char pre = s.charAt(0);
        int l = 1;
        //遍历字符串s，从第二个字符开始。
        while(i < s.length()){
            char c = s.charAt(i);
            //方法遍历字符串s。如果当前字符与前一个字符相同，它就增加长度l。
            if(c == pre) l++;
            else{
                //获取与前一个字符pre对应的HashMap。HashMaps存储在数组count中，字符的HashMap的索引是通过从字符的ASCII值中减去'a'的ASCII值来计算的。
                HashMap<Integer,Integer> map = count[pre - 'a'];
                //更新HashMap map中长度l的频率。如果l不是map中的一个键，getOrDefault返回0，然后将l以频率1放入map。如果l已经是map中的一个键，那么它的频率就增加1。
                map.put(l,map.getOrDefault(l,0) + 1);
                //果l大于或等于2，就会执行这行代码。它以与前一行相同的方式更新map中l-1的频率。频率增加2而不是1，是因为长度l可以通过将一个字符附加到长度为l-1的字符串上两次来形成。
                if(l >= 2) map.put(l-1,map.getOrDefault(l-1,0) + 2);
                //只有当l大于或等于3时才会执行。它更新map中l-2的频率，频率增加3，是因为长度l可以通过将一个字符附加到长度为l-2的字符串上三次来形成。
                if(l >= 3) map.put(l-2,map.getOrDefault(l-2,0) + 3);
                //重置l为1，因为当前字符与前一个字符不同。
                l = 1;
                //更新前一个字符pre为当前字符c。
                pre = c;
            }
            i++;
        }
        //在遍历完字符串s后，我们需要更新最后一个字符的HashMap。这是因为在遍历字符串s时，我们只更新了前一个字符的HashMap。
        HashMap<Integer,Integer> map = count[pre - 'a'];
        //同理继续
        map.put(l,map.getOrDefault(l,0) + 1);
        if(l >= 2) map.put(l-1,map.getOrDefault(l-1,0) + 2);
        if(l >= 3) map.put(l-2,map.getOrDefault(l-2,0) + 3);
        int res = -1;
        //遍历数组count中的每个HashMap。对于每个HashMap，我们遍历它的键集。如果键的频率大于或等于3，我们就更新res。
        for(var map1 : count){
            for(Integer key : map1.keySet()){
                if(map1.get(key) >= 3) res = Math.max(res, key);
            }
        }
        return res;
    }
}

