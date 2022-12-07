package gwakhunjeong.programers.lv2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution42626 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

        for (int i = 0; i < scoville.length; i++) {
            heap.add(scoville[i]);
        }

        int firstSco = 0;
        int secondSco = 0;
        int mixSco = 0;
        int count = 0;

        while (heap.peek() < K) {
            if(heap.size() <=1) return -1;
            firstSco = heap.poll();
            secondSco = heap.poll();
            mixSco = firstSco + (secondSco * 2);
            heap.add(mixSco);
            count ++;

        }

        return count;
    }
}
// 스트림 풀이 복습할것
//import java.util.*;
//        import static java.util.stream.Collectors.*;
//
//class Solution {
//    public int solution(String[][] clothes) {
//        return Arrays.stream(clothes)
//                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
//                .values()
//                .stream()
//                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
//    }
//}