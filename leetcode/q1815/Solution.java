package demo.leetcode.q1815;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * 题目化简:
     * 一个不定长的数组A{n1,n2,...}
     * 并定义0 < ni < batchSize
     * count(ni) <= 30
     * 求使用该数组中的元素可以拼凑出多少组完整的batchSize, 元素不可重复使用,
     * 每组可使用的元素数量不限
     */
    public int maxHappyGroups(int batchSize, int[] groups) {
        this.batchSize = batchSize;
        int justRight = 0;
        long status = 0L;
        for (int group : groups) {
            int remainder = group % batchSize;
            if (remainder == 0)
                justRight++;
            else
                status += 1L << ((remainder - 1) * 5);
        }

        int doubleJustRight = 0;
        int half = batchSize >> 1;
        if ((batchSize & 1) == 0) {
            int count = notUsed(status, half);
            int part = count >> 1;
            status = use(status, half, part << 1);
            doubleJustRight += part;
        } else half++;

        for (int i = 1; i < half; i++) {
            int relative = batchSize - i;
            int n = notUsed(status, i);
            int m = notUsed(status, relative);
            int min = Math.min(n, m);
            status = use(status, i, min);
            status = use(status, relative, min);
            doubleJustRight += min;
        }

        return justRight + doubleJustRight + dfs(0, status);
    }

    Map<Long, Integer> caches = new HashMap<>();
    int batchSize;// final

    int dfs(int remainder, long status) {
        if (status == 0) return 0;
        Integer cache = caches.get(status);
        if (cache != null) return cache;

        int sum = 0;
        for (int i = 1; i < this.batchSize; i++) {
            int notUsedCount = notUsed(status, i);
            if (notUsedCount > 0) {
                for (int j = 1; j <= notUsedCount; j++) {
                    int newRemainder = (remainder + i * j) % this.batchSize;
                    int next = dfs(newRemainder, use(status, i, j));
                    sum = Math.max(sum, remainder == 0 ? next + 1 : next);
                }
            }
        }

        caches.put(status, sum);
        return sum;
    }

    /**
     * 使目标余数未使用数量减少
     * 不做数量校验, 使用notUsed方法自行控制
     *
     * @param status    原状态
     * @param remainder 目标余数
     * @param count     减少的数量
     */
    long use(long status, int remainder, int count) {
        return status - (1L << ((remainder - 1) * 5)) * count;
    }

    /**
     * 使目标余数未使用数量增加
     * 不做数量校验, 使用notUsed方法自行控制
     *
     * @param status    原状态
     * @param remainder 目标余数
     * @param count     增加的数量
     */
    long dontUse(long status, int remainder, int count) {
        return status + (1L << ((remainder - 1) * 5)) * count;
    }

    /**
     * @return 返回未使用的remainder的数量, 当remainder为0时, 返回全部数量
     */
    int notUsed(long status, int remainder) {
        if (remainder != 0)
            return (int) (status >>> ((remainder - 1) * 5)) & 31;

        int count = 0;
        for (int i = 0; i < 8; i++) {
            count += (status >>> (i * 5)) & 31;
        }
        return count;
    }

}
