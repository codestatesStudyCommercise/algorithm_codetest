package jeonjinwoo.programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static java.util.stream.Collectors.*;

public class Solution42578 {
    // 첫번째 풀이 : 재귀 사용 : 실행 시간 초과
    public int solution1(String[][] clothes) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for( String[] clothe : clothes ){
            if (map.containsKey(clothe[1])) {
                ArrayList<String> clotheNames = map.get(clothe[1]);
                clotheNames.add(clothe[0]);
            } else {
                ArrayList<String> clotheNames = new ArrayList<>();
                clotheNames.add(clothe[0]);
                map.put(clothe[1],  clotheNames);
            }
        }

        Integer[] clothesSizes = map.values().stream().map(ArrayList::size).toArray(Integer[]::new);

        // 방법 1
        boolean[] visited = new boolean[clothesSizes.length];

        int n = clothesSizes.length;
        int r;
        int result = 0;

        // 조합
        result += Arrays.stream(clothesSizes).mapToInt(x -> x).sum();
        if (n < 2) {
            return result;
        }

        for (int i = 2; i <= n; i++) {
            r = i;
            result += combination(clothesSizes, visited, 0, n, r);
        }

        return result;
    }

    // 조합
    public int combination(Integer[] arr, boolean[] visited, int depth, int n, int r){

        if (r == 0) {
            int temp = 1;
            for (int i = 0; i < n; i++) {
                if (visited[i]){
                    temp *= arr[i];
                }
            }
            return temp;
        }

        if (depth == n){
            return 0;
        }

        int result = 0;

        // 선택
        visited[depth] = true;
        result += combination(arr, visited, depth + 1, n, r - 1);

        // 자리 교체
        visited[depth] = false;
        result += combination(arr, visited, depth + 1, n, r);
        return  result;
    }

    // 두번째 풀이 : 풀이 결과만 코드로 구현
    public int solution2(String[][] clothes) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for( String[] clothe : clothes ){
            if (map.containsKey(clothe[1])) {
                ArrayList<String> clotheNames = map.get(clothe[1]);
                clotheNames.add(clothe[0]);
            } else {
                ArrayList<String> clotheNames = new ArrayList<>();
                clotheNames.add(clothe[0]);
                map.put(clothe[1],  clotheNames);
            }
        }

        Integer[] clothesSizes = map.values().stream().
                map(ArrayList::size).toArray(Integer[]::new);

        // 방법 2
        int result = 1;
        for (Integer clothesSize : clothesSizes) {
            result *= (clothesSize + 1);
        }
        return result -1;
    }

    // 세번째 풀이 : 람다 사용
    public int solution3(String[][] clothes) {
        // 방법 3
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1)))
                .intValue() - 1;
    }
}
