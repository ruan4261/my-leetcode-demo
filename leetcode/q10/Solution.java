package demo.leetcode.q10;

public class Solution {

    public boolean isMatch(String s, String p) {
        char[] match = s.toCharArray();
        char[] pattern = p.toCharArray();
        this.reverse(match);
        this.reverse(pattern);
        return this.match(match, 0, pattern, 0);
    }

    private boolean match(char[] match, int matchOff, char[] pattern, int patternOff) {
        if (patternOff >= pattern.length && matchOff < match.length) return false;
        if (matchOff >= match.length) return this.matchOver(pattern, patternOff);

        char p = pattern[patternOff];
        if (p == '*') {
            p = pattern[++patternOff];
            int nextPatternOffset = patternOff + 1;
            if (p == '.') {
                for (int i = matchOff; i <= match.length; i++) {
                    if (this.match(match, i, pattern, nextPatternOffset)) return true;
                }
            } else {
                for (int i = matchOff; i <= match.length; i++) {
                    if (this.match(match, i, pattern, nextPatternOffset)) return true;
                    if (i >= match.length || match[i] != p) break;
                }
            }
            return false;
        } else {
            if (p != '.' && p != match[matchOff]) return false;
            return this.match(match, ++matchOff, pattern, ++patternOff);
        }
    }

    /**
     * 字符串结束了，检查模式是否可以结束（是否可忽略）
     */
    private boolean matchOver(char[] pattern, int offset) {
        if (offset >= pattern.length) return true;
        int remainder = pattern.length - offset;
        if ((remainder & 1) == 1) return false;

        int number = remainder >> 1;
        for (int i = offset; i < pattern.length; i++) {
            if (pattern[i] == '*') number--;
        }
        return number == 0;
    }

    private void reverse(char[] chars) {
        int last = chars.length - 1;
        for (int i = (last >> 1); i >= 0; i--) {
            int n = last - i;
            char t = chars[n];
            chars[n] = chars[i];
            chars[i] = t;
        }
    }
}
