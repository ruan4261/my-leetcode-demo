package demo.leetcode.iv1713;

/**
 * 面试题 17.13. 恢复空格
 * <p>
 * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
 * <p>
 * 注意：本题相对原题稍作改动，只需返回未识别的字符数
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 * 输出： 7
 * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
 * 提示：
 * <p>
 * 0 <= len(sentence) <= 1000
 * dictionary中总字符数不超过 150000。
 * 你可以认为dictionary和sentence中只包含小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/re-space-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class Solution {
    public int respace(String[] dictionary, String sentence) {
        int len = sentence.length();
        if (len == 0) return 0;
        Trie root = new Trie();
        root.insert(dictionary);

        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; ++i) {
            dp[i] = dp[i - 1] + 1;

            Trie node = root;
            for (int j = i; j >= 1; --j) {
                int t = sentence.charAt(j - 1) - 'a';

                if (node.trie[t] == null) break;
                else if (node.trie[t].isWord) dp[i] = Math.min(dp[i], dp[j - 1]);

                if (dp[i] == 0) break;
                node = node.trie[t];
            }
        }
        return dp[len];
    }

    class Trie {
        Trie[] trie = new Trie[26];
        boolean isWord;

        void insert(String[] dictionary) {
            for (String str : dictionary) {
                Trie node = this;
                for (int k = str.length() - 1; k >= 0; k--) {
                    int i = str.charAt(k) - 'a';
                    if (node.trie[i] == null) node.trie[i] = new Trie();
                    node = node.trie[i];
                }
                node.isWord = true; //单词的结尾
            }
        }
    }
}
