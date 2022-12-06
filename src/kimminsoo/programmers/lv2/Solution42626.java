package kimminsoo.programmers.lv2;

import java.util.PriorityQueue;

public class Solution42626 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        //우선순위 큐 선언
        PriorityQueue<Integer> que = new PriorityQueue();

        //모든 요소들 큐에 add
        for(int n : scoville){
            que.add(n);
        }

        //우선순위가 제일 높은 요소 peek 해서 K와 비교
        while(que.peek() <= K) {

            //que 의 요소가 하나 남았는데 K보다 작을 경우 return -1
            if(que.size() == 1) {
                return -1;
            }

            //작은 수를 차례대로 두번 poll 하고 계산 후 que 에 add
            que.add(que.poll() + que.poll() * 2);

            //연산++
            answer++;
        }

        return answer;
    }
}
