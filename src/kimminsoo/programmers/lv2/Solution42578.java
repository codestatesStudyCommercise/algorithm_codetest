package kimminsoo.programmers.lv2;

import java.util.HashMap;
import java.util.Map;

public class Solution42578 {
    public int solution(String[][] clothes) {
        int answer = 0;
        int count = 1;
        //해시맵 선언
        Map<String, Integer> hashmap = new HashMap<>();
        //해시맵의 키에 종류, 값에 해당 종류의 갯수를 넣어준다
        for(int i = 0; i < clothes.length; i++) {
            if(hashmap.containsKey(clothes[i][1])) {
                hashmap.put(clothes[i][1] , hashmap.get(clothes[i][1]) + 1);
            } else {
                hashmap.put(clothes[i][1], 1);
            }
        }

        //각 종류의 갯수를 꺼내고 각각 곱해줌
        for(int value : hashmap.values()) {
            count *= (value + 1);
        }
        //어느것도 입지 않았을 경우 -1
        answer = --count;

        return answer;
    }
}
