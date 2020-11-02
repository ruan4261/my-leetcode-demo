package demo.leetcode.q1639;

/**
 * 这个超时了，可惜，逻辑是回溯没问题，还需要考虑一下剪枝优化
 * 可以dp，不用回溯，我是sb
 */
public class Solution {

    int wordLen;
    int wordSize;

    public int numWays(String[] words, String target) {
        this.wordLen = words.length;
        this.wordSize = words[0].length();
        return this.helper(words, target.toCharArray(), 0, 0) % 1000000007;
    }

    public int helper(String[] words, char[] target, int tidx, int k) {
        int count = 0;

        char ch = target[tidx];

        for (int i = k; i < wordSize; i++) {
            for (int j = 0; j < wordLen; j++) {
                if (words[j].charAt(i) == ch) {
                    if (tidx + 1 == target.length) count += 1;
                    else count += helper(words, target, tidx + 1, i + 1);
                }
            }
        }

        // 第tidx个字符从tiny开始取是不存在的
        return count;
    }
}
