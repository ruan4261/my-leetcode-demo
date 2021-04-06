package demo.leetcode.q943;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 这个可以算dp
 * 比官方清晰，还快...
 * 所以，为啥这个这么快???
 */
public class Solution3 {

    /**
     * 每次循环从列表中寻找两个覆盖最优的字符串合并，将合并结果加入数组，进入下一次循环
     * 直到列表size为1，其值为结果
     * O(((n^2)/2)*(n-1))这不应该很慢吗，为啥秒杀全场???
     *
     * @param A
     * @return
     */
    public String shortestSuperstring(String[] A) {
        List<String> list = new ArrayList<>(Arrays.asList(A));

        while (true) {
            int len = list.size();
            if (len == 1) break;

            int maxOverflow = -1;
            int idx1 = 0;
            int idx2 = 0;
            String newstr = "";

            // 不断循环，获得列表中任意两个字符串最大可覆盖长度
            for (int i = 0; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    String s1 = list.get(i);
                    String s2 = list.get(j);
                    String meg = merge(s1, s2);

                    int overflow = s1.length() + s2.length() - meg.length();
                    if (overflow > maxOverflow) {
                        maxOverflow = overflow;
                        idx1 = i;
                        idx2 = j;
                        newstr = meg;
                    }
                }
            }

            // 将两个字符串合并为一个，然后重复此操作
            String s1 = list.get(idx1);
            String s2 = list.get(idx2);
            list.remove(s1);
            list.remove(s2);
            list.add(newstr);
        }
        return list.get(0);
    }

    /**
     * 返回合并后的两个字符串
     *
     * @param s1
     * @param s2
     * @return
     */
    private String merge(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int overlapped1 = 0;
        int overlapped2 = 0;

        for (int len = 1; len1 - len >= 0 && len <= len2; len++)
            if (s1.substring(len1 - len).equals(s2.substring(0, len)))
                overlapped1 = len;

        for (int len = 1; len2 - len >= 0 && len <= len1; len++)
            if (s1.substring(0, len).equals(s2.substring(len2 - len)))
                overlapped2 = len;


        if (overlapped1 >= overlapped2)
            return s1.substring(0, len1 - overlapped1) + s2;
        else
            return s2.substring(0, len2 - overlapped2) + s1;
    }

}
