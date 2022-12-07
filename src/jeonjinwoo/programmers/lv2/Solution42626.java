package jeonjinwoo.programmers.lv2;

import java.util.PriorityQueue;

public class Solution42626 {
    // 힙을 위해 PriorityQueue 사용한 풀이
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int scv : scoville) {
            heap.add(scv);
        }

        int ingre1 = 0;
        int ingre2 = 0;
        for (int i = 0; i < scoville.length; i++) {
            if (!heap.isEmpty()) {
                ingre1 = heap.poll();
            } else {
                return -1;
            }
            if (ingre1 < K) {
                if (!heap.isEmpty()) {
                    ingre2 = heap.poll();
                    heap.add(ingre1 + (ingre2 * 2));
                    answer++;
                } else {
                    return -1;
                }
            } else {
                return answer;
            }
        }
        return answer;
    }
}
