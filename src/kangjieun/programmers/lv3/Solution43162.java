package kangjieun.programmers.lv3;

import java.util.LinkedList;

//43162 네트워크
public class Solution43162 {
    public static void main(String[] args) {
        int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(solution(3, computers));
        //2

        int[][] computers2 = {{1,1,0},{1,1,1},{0,1,1}};
        System.out.println(solution(3, computers2));
        //1
    }
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        //네트워크의 개수를 리턴하시오
        int length = computers.length;

        int [] visited = new int[length];

        for(int i=0; i<length; i++ ){
            if (visited[i] == 0) {
                dfs(i, computers, visited);
                answer++;
            }
        }

        return answer;
    }
    public static void dfs(int node, int[][]computers, int[]visited) {

        visited[node] = 1;

        //node와 연결된 컴퓨터 찾기
        for(int i=0 ; i<computers.length; i++) {
            if (visited[i] == 0 && computers[node][i] == 1) {
                dfs(i,computers, visited);
            }
        }

        return;
    }
}
