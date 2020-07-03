package demo.leetcode.q1106;

/**
 * 1106. 解析布尔表达式
 * <p>
 * 给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。
 * <p>
 * 有效的表达式需遵循以下约定：
 * <p>
 * "t"，运算结果为 True
 * "f"，运算结果为 False
 * "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
 * "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND）
 * "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：expression = "!(f)"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：expression = "|(f,t)"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：expression = "&(t,f)"
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：expression = "|(&(t,f,t),!(t))"
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= expression.length <= 20000
 * expression[i] 由 {'(', ')', '&', '|', '!', 't', 'f', ','} 中的字符组成。
 * expression 是以上述形式给出的有效表达式，表示一个布尔值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/parsing-a-boolean-expression
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class Solution {

    /**
     * 一次直接100%
     * 这题是真好做，为啥是hard级的捏....
     * 有些easy都快烦死我了
     *
     * @param expression
     * @return
     */
    public boolean parseBoolExpr(String expression) {
        int type = -1;// 判断当前表达式类型
        switch (expression.charAt(0)) {
            case '!':
                type = 0;
                break;
            case '|':
                type = 1;
                break;
            case '&':
                type = 2;
                break;
            case 't':
                return true;
            case 'f':
                return false;
        }

        // 表达式脱壳
        String express = expression.substring(2, expression.length() - 1);

        // 原则A
        // type==0 脱壳取反
        // type==1 有true就返回true，否则返回false
        // type==2 有false就返回false，否则返回true
        if (type == 0) {
            return !parseBoolExpr(express);
        }

        char[] chars = express.toCharArray();
        int domain = 0;// 当前字符所在的子域是第几层
        int start = 0;// 临时最高级子域头下标，substring时使用

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ',') continue;
            if (domain == 0) {// 当前在最高域内，遇到t和f可以直接判断return
                if (chars[i] == 't') {
                    if (type == 1) return true;
                } else if (chars[i] == 'f') {
                    if (type == 2) return false;
                } else {
                    // 进入子域表达式
                    domain++;
                    start = i;
                }
            } else {// 当前在子域表达式内
                if (chars[i] == '!' || chars[i] == '|' || chars[i] == '&') domain++;
                if (chars[i] == ')') {
                    domain--;
                    if (domain == 0) {
                        boolean temp = parseBoolExpr(express.substring(start, i + 1));
                        if (type == 1 && temp) return true;
                        if (type == 2 && !temp) return false;
                    }
                }
            }
        }

        // 根据原则A返回值
        return type != 1;
    }

}
