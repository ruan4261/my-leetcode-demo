package demo.leetcode.q763;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    static class Partition {
        int start;
        int end;
        Partition next;

        Partition(int start, int end) {
            this.start = start;
            this.end = end;
        }

        /**
         * @return case
         *         case -1: target part before this part.
         *         case 0: overlap.
         *         case 1: target part after this part.
         */
        int isOverlap(int start, int end) {
            if (end < this.start) return -1;
            if (start > this.end) return 1;
            return 0;
        }

        int isOverlap(Partition part) {
            if (part.end < this.start) return -1;
            if (part.start > this.end) return 1;
            return 0;
        }

        void fix(int start, int end) {
            this.start = Math.min(start, this.start);
            this.end = Math.max(end, this.end);
        }

        void fix(Partition part) {
            this.start = Math.min(part.start, this.start);
            this.end = Math.max(part.end, this.end);
        }
    }

    static class PartHandle {
        Partition head;

        void init(int start, int end) {
            head = new Partition(start, end);
        }

        void addLast(int start, int end) {
            Partition curr = head;
            while (curr.next != null) curr = curr.next;
            curr.next = new Partition(start, end);
        }

        void addPart(int start, int end) {
            if (head == null) {
                init(start, end);
                return;
            }

            Partition prev = null;
            Partition curr = head;
            int state = 0;

            // 确定要应该插入的位置，可能重叠
            while (curr != null && (state = curr.isOverlap(start, end)) == 1) {
                prev = curr;
                curr = curr.next;
            }

            if (state == -1) {
                // 插入在curr之前
                Partition insert = new Partition(start, end);
                insert.next = curr;

                if (prev == null) head = insert;
                else prev.next = insert;
            } else if (state == 0) {
                curr.fix(start, end);
                while (curr.next != null && curr.isOverlap(curr.next) == 0) {
                    curr.fix(curr.next);
                    curr.next = curr.next.next;
                }
            } else addLast(start, end);// state == 1 & curr == null
        }

        List<Integer> listPartLength() {
            List<Integer> res = new ArrayList<>();

            Partition curr = head;
            while (curr != null) {
                res.add(curr.end - curr.start + 1);
                curr = curr.next;
            }

            return res;
        }
    }

    public List<Integer> partitionLabels(String S) {
        final int len = S.length();
        final int[] start = new int[26];
        final int[] end = new int[26];
        Arrays.fill(start, -1);// start不为-1才需要end

        for (int i = 0; i < len; i++) {
            int offset = S.charAt(i) - 'a';
            if (start[offset] == -1)
                start[offset] = i;

            end[offset] = i;
        }

        PartHandle handle = new PartHandle();
        for (int i = 0; i < start.length; i++)
            if (start[i] != -1) handle.addPart(start[i], end[i]);

        return handle.listPartLength();
    }

}
