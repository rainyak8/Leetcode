● 今日学习的文章链接和视频链接

> 题目[454.四数相加II](https://leetcode.cn/problems/4sum-ii/)
> 题目[383.赎金信](https://leetcode.cn/problems/ransom-note/)
> 题目[15.三数之和](https://leetcode.cn/problems/3sum/)
> 题目[18.四数之和](https://leetcode.cn/problems/4sum/)

● 看到题目的第一想法

    今天的题有难度
● 看完代码随想录之后的想法

    卡哥去重的思想给了很大帮助
● 实现过程中遇到哪些困难

    四数相加和赎金信写的很快，哈希表很好用。但是三数之和遇到了问题：
    1. 边界问题
    2. 去重问题

● 解题代码

1.
      <details>
      <summary>点击查看代码</summary>
    
      ```
         class Solution {
             public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
                 Map<Integer, Integer> map = new HashMap<>();
                 int count = 0,i =0, j = 0,sum = 0,value = 0;
                 for(i = 0;i < nums1.length; i++){
                     for (j = 0;j < nums2.length; j++) {
                         sum = nums1[i] + nums2[j];
                         if(map.get(sum) != null){
                             value = map.get(sum) + 1;
                             map.put(sum,value);
                         }else{
                             map.put(sum,1);
                         }
                     }
                 }
                 for(i = 0;i < nums3.length; i++){
                     for (j = 0;j < nums4.length; j++) {
                         sum = nums3[i] + nums4[j];
                         if(map.containsKey(-sum)){
                             count += map.get(-sum);
                         }
                     }
                 }
                 return count;
             }
         }
      ```
      </details>

2.
      <details>
      <summary>点击查看代码</summary>
    
      ```
         class Solution {
         public boolean canConstruct(String ransomNote, String magazine) {
             Map<Character,Integer> map = new HashMap<>();
             int value = 0;
             for (int i = 0; i < magazine.length(); i++) {
                 if(map.get(magazine.charAt(i)) != null){
                     value = map.get(magazine.charAt(i)) + 1;
                     map.put(magazine.charAt(i),value);
                 }else{
                     map.put(magazine.charAt(i),1);
                 }
             }
             for (int i = 0; i < ransomNote.length(); i++) {
                 if(map.containsKey(ransomNote.charAt(i)) && map.get(ransomNote.charAt(i)) >= 1){
                     value = map.get(ransomNote.charAt(i)) - 1;
                     map.put(ransomNote.charAt(i),value);
                 }else{
                     return false;
                 }
             }
             return true;
         }
       }
      ```
      </details>

3.
   <details>
   <summary>点击查看代码</summary>

   ```
    class Solution {
     public List<List<Integer>> threeSum(int[] nums) {
         List<List<Integer>> renum = new ArrayList<>();
         Arrays.sort(nums);
         int i = 0, headnum = -100001,first=0,left = 1, right = nums.length-1;
         for (;first < nums.length - 2;) {
             if(nums[first] == headnum){
                 first++;
                 left = first + 1;
                 right = nums.length-1;
                 continue;
             }
             if(nums[first] + nums[left] + nums[right] > 0){
                 //System.out.println(nums[first] + " "+nums[left]+" "+nums[right]+" 大于");
                 right--;
             }else if(nums[first] + nums[left] + nums[right] < 0){
                 //System.out.println(nums[first] + " "+nums[left]+" "+nums[right]+" 小于");
                 left++;
             }else{
                 //System.out.println(nums[first] + " "+nums[left]+" "+nums[right]+" 等于");
                 List<Integer> num = new ArrayList<>();
                 while (right > left && nums[right] == nums[right - 1]){
                     i = 1;
                     right--;
                 }
                 while (right > left && nums[left] == nums[left + 1]) {
                     i = 1;
                     left++;
                 }
                 num.add(nums[first]);
                 num.add(nums[left]);
                 num.add(nums[right]);
                 renum.add(num);

                 left++;
                 //headnum = nums[first];
             }
             if(left >= right){
                 headnum = nums[first];
                 first++;
                 left = first + 1;
                 right = nums.length-1;
             }
         }
         return renum;
     }
    }
   ```
   </details>

4.
   <details>
   <summary>点击查看代码</summary>

   ```
    class Solution {
     public List<List<Integer>> fourSum(int[] nums, int target) {
         List<List<Integer>> renum = new ArrayList<>();
         Arrays.sort(nums);
         int head = 0,headnum = -1000000001,first=1,left = 2, right = nums.length-1;
         long sum = 0;
         for (head = 0; head < nums.length - 3; head++) {
             if (nums[head] > 0 && nums[head] > target) {
                 return renum;
             }

             if (head > 0 && nums[head - 1] == nums[head]) {
                 continue;
             }
             first = head + 1;
             left = first + 1;
             right = nums.length-1;
             headnum = -1000000001;
             while (first < nums.length - 2) {
                 if(nums[first] == headnum){
                     first++;
                     left = first + 1;
                     right = nums.length-1;
                     continue;
                 }
                 if(nums[head] + nums[first] + nums[left] + nums[right] > target){
                     //System.out.println(nums[head] + " "+nums[first] + " "+nums[left]+" "+nums[right]+" 大于");
                     right--;
                 }else if(nums[head] + nums[first] + nums[left] + nums[right] < target){
                     //System.out.println(nums[head] + " "+nums[first] + " "+nums[left]+" "+nums[right]+" 小于");
                     left++;
                 }else{
                     //System.out.println(nums[head] + " "+nums[first] + " "+nums[left]+" "+nums[right]+" 等于");
                     List<Integer> num = new ArrayList<>();
                     while (right > left && nums[right] == nums[right - 1]){
                         right--;
                     }
                     while (right > left && nums[left] == nums[left + 1]) {
                         left++;
                     }
                     num.add(nums[head]);
                     num.add(nums[first]);
                     num.add(nums[left]);
                     num.add(nums[right]);
                     renum.add(num);

                     left++;
                     //headnum = nums[first];
                 }
                 if(left >= right){
                     headnum = nums[first];
                     first++;
                     left = first + 1;
                     right = nums.length-1;
                 }
             }
         }
         return renum;
     }
    }
   ```
   </details>

● 今日收获，学习时长

    今日收获：
        边界问题通过DEBUG，最后找到了问题所在。但是去重问题一直没能解决，耗时大概半小时没做出来
    就去看了卡哥的文章，然后知道了通过两次循环去重的方法，即将左右指针都移动到和自己相同的最边缘位
    这样可以保证只有一次结果，然后我添加了headNum，在开头比较，更直观的看到头部去重。
    接下来4numsum就好做了，无非是把3numsum copy下来 在这三个指针前面加一个head指针作为第四个数。
    代码甚至没什么改动，只是参照卡哥加了head的去重，然后就能跑了。
    这两道题的关键就是左右指针的去重，解决后就很简单！

    学习时长：2.5h
