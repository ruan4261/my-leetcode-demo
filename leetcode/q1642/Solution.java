package demo.leetcode.q1642;

public class Solution {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        var queue = new FixedPriorityQueue(ladders);
        int limit = heights.length - 1;

        int i = 0;
        for (; i < limit; i++) {
            int gap = heights[i + 1] - heights[i];

            if (gap > 0) {
                if (bricks >= gap) {
                    // 如果ladders为0就用不到优先队列了
                    if (ladders > 0) queue.add(gap);
                    bricks -= gap;
                } else if (ladders > 0) {
                    int topStack = queue.peek();
                    if (gap < topStack) {
                        bricks += topStack - gap;
                        queue.move0();
                        queue.add(gap);
                    }
                    ladders--;
                } else break;
            }
        }

        return i;
    }

    static class FixedPriorityQueue {
        private final int[] queue;// 仅可以放入正数
        private int size;// 其标记在最后一个空的位置上，可能等于数组长度

        public FixedPriorityQueue(int size) {
            this.queue = new int[size];
            this.size = 0;
        }

        public void add(int i) {
            if (this.size == this.queue.length) {
                int last = this.size - 1;
                if (i <= this.queue[last]) return;
                this.queue[last] = 0;
                this.size--;
            }

            for (int j = this.size; j >= 0; j--) {
                if (i <= this.queue[j]) {
                    int insert = j + 1;
                    if (insert == this.size) {
                        this.queue[this.size] = i;
                    } else {
                        this.move(insert);
                        this.queue[insert] = i;
                    }
                    this.size++;
                    return;
                }
            }

            // 没有比其大的值
            this.move(0);
            this.queue[0] = i;
            this.size++;
        }

        public int peek() {
            return this.queue[0];
        }

        public int pop() {
            int val = this.queue[0];
            move0();
            this.size--;
            return val;
        }

        /**
         * 数据将插入i的位置，原数据从i开始向后移动
         */
        private void move(int i) {
            if (this.size - 1 - i >= 0) System.arraycopy(this.queue, i, this.queue, i + 1, this.size - 1 - i);
        }

        /**
         * 顶部数据被弹出，数据整体向前移动一位
         */
        private void move0() {
            if (this.size - 1 >= 0) System.arraycopy(this.queue, 0, this.queue, 1, this.size - 1);
        }
    }

}
