package demo.leetcode.lcp29;

public class Solution {

    public int orchestraLayout(int num, int xPos, int yPos) {
        int padding = Math.min(Math.min(xPos, num - xPos - 1), Math.min(yPos, num - yPos - 1));
        // 4 * (最大宽 + 最小宽 - 2)/2 * padding
        // 2padding * (最大宽 + 最小宽 - 2)
        // 最大宽 = num, 最小宽 = num - 2(padding - 1)
        // 2padding * (num + num - 2(padding - 1)) - (padding << 2)
        // (padding << 1) * ((num << 1) - (padding << 1) + 2) - (padding << 2)
        // (padding << 1) * ((num << 1) - (padding << 1))
        int ans = ((padding << 1) % 9) * (((num << 1) - (padding << 1)) % 9);

        xPos -= padding;
        yPos -= padding;

        int newNum = num - (padding << 1);
        if (xPos == 0)// in the top position
            ans += (yPos % 9) + 1;
        else if (yPos == newNum - 1) {// in the rightest position
            ans += (newNum % 9) + (xPos % 9);
        } else if (xPos == newNum - 1) {// in the bottom position
            ans += (newNum % 9) * 3 - (yPos % 9) + 16;// +16防止负值
        } else {// in the leftest position
            ans += (((newNum % 9) << 2) - 4) - (xPos % 9) + 10;// +10防止负值
        }

        int ans0 = ans % 9;
        return ans0 == 0 ? 9 : ans0;
    }

}
