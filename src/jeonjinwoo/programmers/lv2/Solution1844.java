package jeonjinwoo.programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1844 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int N;
    static int M;
    static int[][] map;

    public static int solution(int[][] maps) {
        int answer = 0;
        map = maps;
        N = maps.length;
        M = maps[maps.length -1].length;
        visited = new boolean[N][M];

        answer = BFS(0, 0);
        if (answer == 1) {
            return -1;
        }

        return answer;
    }

    public static int BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()){
            int[] now = queue.poll(); // 큐에서 좌표를 꺼내 진행
            for (int k = 0; k < 4; k++) { // 상하 좌우 탐색
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if (x >= 0 && y >= 0 && x < N && y < M ) { // 좌표 유효성 검사
                    if (map[x][y] != 0 && !visited[x][y]) { // 갈수있는칸 && 방문 여부 검사
                        visited[x][y] = true;
                        map[x][y] = map[now[0]][now[1]] + 1;
                        queue.add(new int[]{x, y}); // 갈 수 있는 칸 queue 에 추가
                    }
                }
            }
        }
        return map[N-1][M-1];
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
    }

}
