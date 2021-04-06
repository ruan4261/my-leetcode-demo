package demo.leetcode.q943;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 943. 最短超级串
 * <p>
 * 给定一个字符串数组 A，找到以 A 中每个字符串作为子字符串的最短字符串。
 * <p>
 * 我们可以假设 A 中没有字符串是 A 中另一个字符串的子字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：["alex","loves","leetcode"]
 * 输出："alexlovesleetcode"
 * 解释："alex"，"loves"，"leetcode" 的所有排列都会被接受。
 * 示例 2：
 * <p>
 * 输入：["catg","ctaagt","gcta","ttca","atgcatc"]
 * 输出："gctaagttcatgcatc"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 12
 * 1 <= A[i].length <= 20
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-shortest-superstring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class Solution {

    /**
     * dp向下递归
     * 递归外部嵌套循环确保正确性
     * 这鬼东西对是对，就是leetcode上会跑超时..
     * Time O(n^2)基于以String为单位的运算
     *
     * @param A
     * @return
     */
    public String shortestSuperstring(String[] A) {
        if (A == null || A.length == 0) return null;
        if (A.length < 2) return A[0];
        return this.helper(new LinkedList<>(Arrays.asList(A)));
    }

    private String helper(LinkedList<String> list) {
        if (list.size() == 2) return this.getShortest(list.getFirst(), list.getLast());

        int len = list.size();
        String shortest = null;
        for (int i = 0; i < len; i++) {
            String ele = list.removeFirst();
            String temp = this.getShortest(ele, helper(list));
            if (i == 0 || (temp.length() < shortest.length())) shortest = temp;
            list.addLast(ele);
        }

        return shortest;
    }

    private String getShortest(String s1, String s2) {
        int s1len = s1.length();
        int s2len = s2.length();
        String res = s1 + s2;
        for (int i = 0; i < s1len; i++) {
            String temp = s1.substring(i);
            if (s2.indexOf(temp) == 0) {
                temp = s1 + s2.substring(temp.length());
                if (temp.length() < res.length())
                    res = temp;
            }
        }
        for (int i = 0; i < s2len; i++) {
            String temp = s2.substring(i);
            if (s1.indexOf(temp) == 0) {
                temp = s2 + s1.substring(temp.length());
                if (temp.length() < res.length())
                    res = temp;
            }
        }
        return res;
    }

}
