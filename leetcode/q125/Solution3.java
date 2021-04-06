package demo.leetcode.q125;

public class Solution3 {

    public boolean isPalindrome(String s) {
        int low = 'a' - 'A';
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char ic = s.charAt(i);
            char jc = s.charAt(j);
            if (ic == jc) {
                i++;
                j--;
            } else if (ic < '0' || (ic > '9' && ic < 'A') || (ic > 'Z' && ic < 'a') || ic > 'z') {
                i++;
            } else if (jc < '0' || (jc > '9' && jc < 'A') || (jc > 'Z' && jc < 'a') || jc > 'z') {
                j--;
            } else if (ic > '9' && jc > '9' && Math.abs(ic - jc) == low) {
                i++;
                j--;
            } else return false;
        }
        return true;
    }

}
