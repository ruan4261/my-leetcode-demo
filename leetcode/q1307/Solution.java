package com.ruan.alg.leetcode.leetcode.q1307;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    private Map<Character, Integer> weights = new HashMap<>(10);// 字符映射到权值

    private char[] minusWeights = new char[7];// 负权值排序

    private char[] plusWeights = new char[10];// 正权值排序

    private char[] absWeights = new char[10];// 绝对权值排序

    private boolean[] zeroUnable = new boolean[26];// 为true代表不可为0

    private Map<Character, Integer> minNumber = new HashMap<>(10);// 最小可能数

    private Map<Character, Integer> maxNumber = new HashMap<>(10);// 最大可能数

    /**
     *
     * @param words
     * @param result
     * @return
     */
    public boolean isSolvable(String[] words, String result) {
        // 基本权值计算与初始数据校验
        int maxLen = 0;
        for (String word : words) {
            if (word.length() > maxLen) maxLen = word.length();
            zeroUnable[word.charAt(0) - 'A'] = true;
            int weight = 1;
            int len = word.length();
            for (int i = 0; i < len; i++) {
                char c = word.charAt(len - i - 1);
                weights.put(c, weights.getOrDefault(c, 0) + weight);
                weight *= 10;
            }
        }

        int weight = 1;
        int resLen = result.length();
        for (int i = 0; i < resLen; i++) {
            char c = result.charAt(resLen - i - 1);
            weights.put(c, weights.getOrDefault(c, 0) - weight);
            weight *= 10;
        }

        // 有一点点晚的判断
        if (maxLen > result.length() || result.length() - maxLen > 1) return false;

        // 权值排序（顺带进行权值系数大小检测，正负差值达到十倍则不可能有解）
        int minusWeight = 0;
        int plusWeight = 0;
        for (Map.Entry entry : weights.entrySet()) {
            char c = (char) entry.getKey();
            int wei = (int) entry.getValue();
            if (wei < 0) {
                minusWeight += wei;
                for (int i = 0; i < minusWeights.length; i++) {
                    if (minusWeights[i] == 0) {
                        minusWeights[i] = c;
                        break;
                    } else if (wei < weights.get(minusWeights[i])) {
                        if (minusWeights.length - 1 - i >= 0)
                            System.arraycopy(minusWeights, i, minusWeights, i + 1, minusWeights.length - 1 - i);
                        minusWeights[i] = c;
                        break;
                    }
                }
            } else {
                plusWeight += wei;
                for (int i = 0; i < plusWeights.length; i++) {
                    if (plusWeights[i] == 0) {
                        plusWeights[i] = c;
                        break;
                    } else if (wei > weights.get(plusWeights[i])) {
                        if (plusWeights.length - 1 - i >= 0)
                            System.arraycopy(plusWeights, i, plusWeights, i + 1, plusWeights.length - 1 - i);
                        plusWeights[i] = c;
                        break;
                    }
                }
            }

            int absWei = Math.abs(wei);
            for (int i = 0; i < absWeights.length; i++) {
                if (absWeights[i] == 0) {
                    absWeights[i] = c;
                    break;
                }
                if (absWei > Math.abs(weights.get(absWeights[i]))) {
                    if (absWeights.length - 1 - i >= 0)
                        System.arraycopy(absWeights, i, absWeights, i + 1, absWeights.length - 1 - i);
                    absWeights[i] = c;
                    break;
                }
            }
        }

        if (minusWeight == 0 && plusWeight == 0) return true;
        if (minusWeight == 0 || plusWeight == 0) return false;
        if (-minusWeight / plusWeight >= 10 || plusWeight / -minusWeight >= 10) return false;

        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        return dfs(new char[10], arr, 0);
    }

    /**
     * @param numberMapToChar
     * @param absIdx
     * @return
     */
    private boolean dfs(char[] numberMapToChar, int[] charMapToNumber, int absIdx) {
        if (absIdx >= absWeights.length || absWeights[absIdx] == 0) {
            int sum = 0;
            for (Map.Entry entry : weights.entrySet()) {
                int num = charMapToNumber[(char) entry.getKey() - 'A'];
                sum += num * (int) entry.getValue();
            }
            return sum == 0;
        }
        char[] minTempMap = new char[10];
        char[] maxTempMap = new char[10];
        char c = absWeights[absIdx];
        int wei = weights.get(c);
        if (wei == 0) return dfs(numberMapToChar, charMapToNumber, absIdx + 1);
        int max = 0;
        int min = 0;

        // 在此处，对当前递归的权值做了区间判断
        for (int i = 0; i < absWeights.length && absWeights[i] != 0; i++) {
            char cc = absWeights[i];
            if (cc == c) continue;
            int w = weights.get(cc);
            if (charMapToNumber[cc - 'A'] != -1) {
                max += charMapToNumber[cc - 'A'] * w;
                min += charMapToNumber[cc - 'A'] * w;
                continue;
            }

            Integer ccMax = maxNumber.getOrDefault(cc, 9);
            Integer ccMin;
            if (zeroUnable[cc - 'A']) ccMin = minNumber.getOrDefault(cc, 1);
            else ccMin = minNumber.getOrDefault(cc, 0);
            int maxL = -1;
            int minL = -1;

            boolean o = ((wei >>> 31) ^ (w >>> 31)) == 0;
            if (o) {
                for (int j = ccMin; j <= ccMax; j++) {
                    if (maxTempMap[j] == 0 && numberMapToChar[j] == 0) {
                        maxTempMap[j] = cc;
                        maxL = j;
                        break;
                    }
                }
                for (int j = ccMax; j >= ccMin; j--) {
                    if (minTempMap[j] == 0 && numberMapToChar[j] == 0) {
                        minTempMap[j] = cc;
                        minL = j;
                        break;
                    }
                }
            } else {
                for (int j = ccMax; j >= ccMin; j--) {
                    if (maxTempMap[j] == 0 && numberMapToChar[j] == 0) {
                        maxTempMap[j] = cc;
                        maxL = j;
                        break;
                    }
                }
                for (int j = ccMin; j <= ccMax; j++) {
                    if (minTempMap[j] == 0 && numberMapToChar[j] == 0) {
                        minTempMap[j] = cc;
                        minL = j;
                        break;
                    }
                }
            }

            if (maxL == -1 || minL == -1) return false;

            max += maxL * w;
            min += minL * w;
        }
        maxNumber.put(c, Math.min(-max / wei, 9));
        if (zeroUnable[c - 'A']) minNumber.put(c, Math.max((int) Math.ceil(-min / wei), 1));
        else minNumber.put(c, Math.max((int) Math.ceil(-min / wei), 0));

        int begin = minNumber.get(c);
        int end = maxNumber.get(c);
        for (int i = begin; i <= end; i++) {
            if (numberMapToChar[i] != 0) continue;
            numberMapToChar[i] = c;
            charMapToNumber[c - 'A'] = i;
            if (dfs(numberMapToChar, charMapToNumber, absIdx + 1)) return true;
            numberMapToChar[i] = 0;
            charMapToNumber[c - 'A'] = -1;
        }

        maxNumber.remove(c);
        minNumber.remove(c);
        return false;
    }

}
