package kangjieun.programmers.lv2;
import java.util.*;
public class Solution12909 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        for (int i= 0 ; i< length ; i++ ) {
            Character now = s.charAt(i);

            if (now == '(') {
                stack.push(now);
            }
            else { //now == ')'
                if (stack.empty()) {
                    return false;
                }
                stack.pop();
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }
}
