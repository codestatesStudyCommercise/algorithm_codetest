package jeonjinwoo.programmers.lv2;

import java.util.Stack;

public class Solution12909 {
    // 첫번째 풀이 : Stack 사용
    boolean solution1(String s) {
        Stack<Character> stack = new Stack<>();

        char[] sCharArr = s.toCharArray();
        for (char c : sCharArr) {
            // 스텍이 비어있는 경우
            if (stack.size() == 0) {
                // '(' 인경우
                if (c == '(') {
                    stack.push(c);
                }
                // ')' 인 경우
                else {
                    return false;
                }
            }
            // 스텍이 비어있지 않은경우
            else {
                // '(' 인경우
                if (c == '(') {
                    stack.push(c);
                }
                // ')' 인 경우
                else {
                    stack.pop();
                }
            }
        }
        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    // 두번째 풀이 : int count 를 통한 해결
    boolean solution2(String s) {
        boolean answer = false;
        int count = 0;
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i) == '('){
                count++;
            }
            if(s.charAt(i) == ')'){
                count--;
            }
            if(count < 0){
                break;
            }
        }
        if(count == 0){
            answer = true;
        }
        return answer;
    }

}
