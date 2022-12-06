package kimminsoo.programmers.lv2;

import java.util.Stack;

public class Solution12909 {
    boolean solution1(String s) {
        boolean answer = true;

        //스택 생성
        Stack<Character> stack = new Stack<>();

        //문자를 하나씩 나눠서 비교
        for(int i = 0; i < s.length(); i++) {
            //여는 괄호는 stack에 push
            if(s.charAt(i) == '(') {
                stack.push(s.charAt(i));
                //닫는 괄호이고 스택에 비어있지 않는 경우 stack에서 pop
            } else if(s.charAt(i) == ')' && !stack.isEmpty()) {
                stack.pop();
                //닫는 괄호인데 스택이 비어 있으면 괄호가 올바르지 않음 false return
            } else {
                return false;
            }
        }
        //연산이 끝났는데 stack에 남아있으면 올바른 괄호가 아님
        if(!stack.isEmpty()) {
            return false;
        }

        return answer;
    }

    public boolean solution2(String s) {
        boolean answer = true;

        //“(”의 개수와 “)” 개수 카운팅
        int cnt = 0;

        //for문으로 문자를 하나씩 나눠서 비교
        for(int i = 0; i < s.length(); i++) {
            //여는 괄호가 있으면 cnt++
            if(s.charAt(i) == '(') {
                cnt++;
                //닫는 괄호이고 cnt가 0이 아닌경우 cnt--
            } else if(s.charAt(i) == ')' && cnt != 0) {
                cnt--;
                //닫는 괄호인데 cnt가 0인 경우 짝이 맞지 않기 때문에 false return
            } else {
                return false;
            }
        }
        //연산이 끝났는데 cnt가 0이 아닌 경우 false return
        if(cnt != 0) {
            return false;
        }

        return answer;
    }
}
