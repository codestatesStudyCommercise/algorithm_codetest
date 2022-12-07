package gwakhunjeong.programers.lv2;

import java.util.Stack;

public class Solution12909 {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }

            if (s.charAt(i) == ')') {
                stack.pop();
            }
        }

        if (stack.size() != 0) answer = false;

        return answer;
    }
}