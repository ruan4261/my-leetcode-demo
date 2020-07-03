package demo.leetcode.q15;

import java.util.*;

/**
 * 讲道理这个算法是有问题的，int计算中bit位超过32直接就会被截断，这会导致map数组的长度不可预料，然后就发送异常了:P
 * 就算 max - min + 1 没能超过2^31，要开辟 4 * 2^31 字节内存大小也不切实际，利用空间换时间，这波啊，这波是空间光荣牺牲了
 * 如果改用HashMap进行记录，在leetcode用例测试时，时间消耗会直接上升4倍
 */
public class Solution2 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // 正负及0计数
        int[] count = new int[2];
        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);

            if (n != 0) {
                count[n >>> 31]++;
            }
        }
        // posCount为正数量, negCount为负数量
        int posCount = count[0], negCount = count[1], zeroCount = nums.length - negCount - posCount;
        // 自成一派
        if (zeroCount >= 3) ans.add(Arrays.asList(0, 0, 0));
        // 如果没有负数或没有正数
        if (negCount == 0 || posCount == 0) return ans;

        // 如果max/min的绝对值超过了另一边的两倍，将其设置为另一边的两倍，在下面的检查中抛弃超界的部分
        if ((min << 1) + max > 0) {
            max = -min << 1;
        } else if ((max << 1) + min < 0) {
            min = -max << 1;
        }

        // 个数映射，n对应下标为n-min
        //Map<Integer, Integer> map = new HashMap<>(negCount + posCount + 1, 1);
        int[] map = new int[max - min + 1];
        int[] negs = new int[negCount];
        int[] poses = new int[posCount];
        negCount = 0;
        posCount = 0;
        for (int n : nums) {
            if (n < min || n > max) {
                continue;
            }
            if (map[n - min]++ != 0) {
                continue;
            }
            // 每个位置存放数组中对应数字的个数,poses和negs存放正、负数
            if (n > 0) {
                poses[posCount++] = n;
            } else if (n < 0) {
                negs[negCount++] = n;
            }
        }
        Arrays.sort(poses, 0, posCount);
        Arrays.sort(negs, 0, negCount);
        // 至此，我们将nums数组分为了正负两个数组并根据由小到大排序，同时有记录所有数字个数的映射
        int left = 0;
        // 遍历负数数组（由大到小）
        // 一组数中至少需要一个负数anchor和一个正数pos，余下的一个数diff通过计算得出（可能为负也可能为正），然后去匹配数字个数映射
        for (int i = negCount - 1; i >= 0; i--) {
            int anchor = negs[i];
            // 正数至少要有一个达到anchor绝对值一半的，从这儿开始循环选择，可以直接避免重复
            int minPos = -anchor >>> 1;

            // 将minPos确认到poses数组的下标中
            while (left < posCount && poses[left] < minPos) left++;

            // 选择不同正数
            for (int j = left; j < posCount; j++) {
                int pos = poses[j];
                int diff = -anchor - pos;

                // anchor <= diff <= pos
                if (diff >= anchor && diff <= pos) {
                    if (diff == anchor) {
                        if (map[anchor - min] > 1) ans.add(Arrays.asList(anchor, anchor, pos));
                    } else if (diff == pos) {
                        if (map[pos - min] > 1) ans.add(Arrays.asList(anchor, pos, pos));
                    } else if (map[diff - min] > 0) ans.add(Arrays.asList(anchor, diff, pos));
                } else if (diff < anchor) {
                    // 在循环中diff会不断变小，anchor作为所有负数的循环遍历，如果diff小于anchor则会造成重复
                    break;
                }
            }
        }
        return ans;
    }

}
