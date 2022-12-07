package gwakhunjeong.programers.lv2;

import java.util.HashMap;
import java.util.Set;

public class Solution42578 {
    public int solution(String[][] clothes) {

        HashMap<String, Integer> newHash = new HashMap<String, Integer>();

        for(int i =0; i<clothes.length; i++) {
            newHash.put(clothes[i][1], newHash.getOrDefault(clothes[i][1], 0)+1);
        }

        Set<String> keySet = newHash.keySet();

        int result = 1;
        for(String key : keySet) {
            result *= newHash.get(key) + 1;
        }
        return result - 1;
    }
}