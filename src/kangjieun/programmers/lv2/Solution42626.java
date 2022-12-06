package kangjieun.programmers.lv2;

import java.util.PriorityQueue;

public class Solution42626 {
    public int solution(int[] scoville, int K) {
        Integer answer = 0;
        Integer one, two;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();//큐 생성

        //할당
        for (int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }

        while(queue.peek() < K) {
            //int형 우선순위가 낮은 숫자 순
            if (queue.size() < 2) {
                return -1;
            }
            else {
                one = queue.poll();
                two = queue.poll();

                one += (two * 2);
                queue.offer(one);
                answer += 1;
            }
        }
        return answer;
    }
}
