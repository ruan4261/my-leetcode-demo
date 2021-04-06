package demo.leetcode.q502;

import java.util.PriorityQueue;

public class Solution2 {

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        // 启动资金充足情况下的提速方案
        boolean speedUp = true;
        for (int c: Capital) if (W < c) speedUp = false;
        if (speedUp) {
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            for (int p: Profits) {
                heap.add(p);
                if (heap.size() > k) heap.poll();
            }
            for (int h: heap) W += h;
            return W;
        }

        int idx;
        int n = Profits.length;
        // 每个项目只能选择一次，此循环为所有项目被选择的总次数
        for(int i = 0; i < Math.min(k, n); ++i) {
            idx = -1;
            // 选择这次使用什么项目
            for(int j = 0; j < n; ++j) {
                if (W >= Capital[j]) {
                    if (idx == -1 ) idx = j;
                    else if (Profits[idx] < Profits[j]) idx = j;
                }
            }
            // 没有选择项目，则当前启动资金已经不足以启动任何项目
            if(idx == -1) break;

            // 加上本次项目的利润，然后将本次启动项目的启动资金设为MAX，其将不会再被选择
            W += Profits[idx];
            Capital[idx] = Integer.MAX_VALUE;
        }
        return  W;
    }
}
