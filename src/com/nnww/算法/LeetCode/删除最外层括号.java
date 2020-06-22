package com.nnww.算法.LeetCode;

import java.util.HashMap;
import java.util.Stack;

/**
 * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。

 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。

 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。

 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。



 示例 1：

 输入："(()())(())"
 输出："()()()"
 解释：
 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。

 示例 2：

 输入："(()())(())(()(()))"
 输出："()()()()(())"
 解释：
 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 删除每隔部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。

 示例 3：

 输入："()()"
 输出：""
 解释：
 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 删除每个部分中的最外层括号后得到 "" + "" = ""。



 提示：

 S.length <= 10000
 S[i] 为 "(" 或 ")"
 S 是一个有效括号字符串

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/remove-outermost-parentheses
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 删除最外层括号 {

    public static String removeOuterParentheses(String s) {
        StringBuilder builder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int temp = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                stack.add(c);
            } else if (c == ')') {
                stack.pop();
            }
            if (stack.isEmpty()) {
                builder.append(s.substring(temp + 1, i));
                temp = i + 1;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(删除最外层括号.removeOuterParentheses("(()())(())(()(()))"));
    }


}
