package gwakhunjeong.programers.lv2;

import java.util.HashSet;

public class Solution42839 {
    static HashSet<Integer> set = new HashSet<>(); //소수 검증을 통과한 값 저장
    static char[] arr; //종이 조각에 적힌 수 하나씩 저장
    static boolean[] visited; // 종이 조각 사용여부 체크
    public int solution(String numbers) {

        int numLeng = numbers.length();
        arr = new char[numLeng];
        visited = new boolean[numLeng];

        for (int i = 0; i < numLeng; i++) {
            arr[i] = numbers.charAt(i);
        }//종이조각 하나씩 배열에 입력

        dfs("", 0); //재귀 void (결과로 가져올 set 등을 전역변수로 설정하여서 리턴값이 없어도 됨)

        return set.size();
    }
    public static void dfs(String str, int idx) { // 완전탐색 DFS
        int num;
        if (str != "") { //문자열에 수가 있다면 소수 판별
            num = Integer.parseInt(str);
            if(isPrime(num)) set.add(num); //소수면 결과  set에 저장
        }
        if (idx == arr.length) return; //종이조각 탐색 마지막종이조각까지오면 끝.

        for (int i = 0; i < arr.length; i++) {
            if(visited[i]) continue; //사용한 종이조각이면 넘어감
            visited[i] = true; //처음 사용하는 종이조각이면 사용했다고 체크
            dfs(str+arr[i], idx+1); //종이조각 조합을 위해 종이조각을 하나 더 넣고 다음 종이조각을 추가하는 재귀로 진행
            visited[i] = false; //백트래킹, 재귀가 돌고 결과 저장이 되면 다시 사용하지 않은 종이조각으로 체크
        }
    }

    public static boolean isPrime(int n) { //소수 판별
        if(n==0 || n ==1) return false;  // 0, 1은 소수가 아님
        for (int i = 2; i <= (int) Math.sqrt(n); i++) { // for문 검사수를 줄이기 위한 Math.sqrt() 사용
            if (n % i == 0 ) {
                return false;
            }
        }
        return true;
    }
}
