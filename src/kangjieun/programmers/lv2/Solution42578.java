package kangjieun.programmers.lv2;

import java.util.HashMap;
import java.util.Map;

public class Solution42578 {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> clothesHash = new HashMap<>();

        String type;
        //01) 들어온 데이터를 옷의 종류에 따라 해시맵으로 만들어준다.
        for (int i = 0; i<clothes.length; i++) {
            type = clothes[i][1]; //종류

            if (clothesHash.containsKey(type)){
                clothesHash.put(type,clothesHash.get(type)+1);
            }
            else {
                clothesHash.put(type,1);
            }
        }

        //02) clothesHash.size 는 옷타입 수
        //    clothesHash.EntrySet으로 가져와서, 각 value (해당 옷타입의 실제 개수)로 연산한다.
        int result = 1;

        for( Map.Entry<String, Integer> entry : clothesHash.entrySet()) {
            result *= entry.getValue()+1;
        }

        return result-1;
    }
}
