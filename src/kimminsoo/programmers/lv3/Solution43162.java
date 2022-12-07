package kimminsoo.programmers.lv3;

public class Solution43162 {
    static int[] check;

    public int solution(int n, int[][] computers) {
        //노드의 개수 만큼 check 배열 선언
        check = new int[computers.length];

        //연결된 네트워크 개수
        int cnt = 0;

        //각 노드를 확인
        for(int i = 0; i < computers.length; i++) {
            //check 배열의 해당 노드 인덱스가 1일 경우 이미 들렀기 때문에 확인할 필요 없음
            if(check[i] != 1) {
                dfs(computers, check, i);
                //dfs 메소드를 통과했으면 해당 노드와 연결된 노드를 모두 들렀으므로 cnt++
                cnt++;
            }
        }
        return cnt;
    }

    public void dfs(int[][] computers, int[] check, int i) {
        //해당 노드를 들렀으므로 check 배열의 해당 노드 인덱스의 값을 1로 변경
        check[i] = 1;

        //해당 노드가 방문할 수 있는 노드 탐색
        for(int j = 0; j < computers.length; j++) {
            //해당 노드가 자신의 노드도 1이므로 제외하고 check 배열의 값이 1이 아니고 computers 배열이 1인경우 탐색 가능
            if (i != j && check[j] != 1 && computers[i][j] == 1) {
                dfs(computers, check, j);
            }
        }
    }
}
