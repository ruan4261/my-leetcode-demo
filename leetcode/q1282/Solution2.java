package demo.leetcode.q1282;

import java.util.LinkedList;
import java.util.List;

public class Solution2 {

    private boolean[] log;
    private int[] groupSizes;

    /**
     * 挺有创意的想法
     *
     * @param groupSizes
     * @return
     */
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> resultList = new LinkedList<>();
        this.groupSizes = groupSizes;
        this.log = new boolean[groupSizes.length];
        for (int i = 0; i < groupSizes.length; i++) {
            if (!log[i]) {
                resultList.add(search(i));
            }
        }

        return resultList;
    }

    private List<Integer> search(int p) {
        List<Integer> list = new LinkedList<>();
        list.add(p);
        log[p] = true;
        int size = this.groupSizes[p];
        for (int i = p + 1; i < this.groupSizes.length; i++) {
            if (list.size() == size) {
                break;
            }
            if (this.groupSizes[i] == size) {
                list.add(i);
                log[i] = true;
            }
        }
        return list;
    }

}
