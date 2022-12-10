package gwakhunjeong.programers.lv2;

import java.util.LinkedList;
import java.util.Queue;
public class Solution1844 {
    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<Point> myqueue = new LinkedList<>();
        visited[0][0] = true; // 문제상에선 1,1
        myqueue.add(new Point(0, 0, 1)); //시작시 밟은 거리도 1

        while (!myqueue.isEmpty()) { //큐에 뭔가 있으면 반복 --> curr 가 제거 된 뒤 다른 갈곳이 없으면 while문 종료.
            Point curr = myqueue.remove();
            if (curr.row == maps.length-1 && curr.col == maps[0].length-1) { //현재 위치가 마지막 위치에 도달한 경우. n,m
                return curr.dist;
            }
            for (int i = 0; i < 4; i++) { //2차원 배열 D에 저장한 값으로 돌릴것이기 때문에 i 0~3 반복
                int nr = curr.row + D[i][0]; //전부 한칸씩 움직이는 경우를 상정한 배열저장임.
                int nc = curr.col + D[i][1];
                if (nr < 0 || nr > maps.length-1 || nc <0 || nc > maps[0].length-1) continue; //다음 이동한 곳의 위치가 맵의 범위를 넘어선 경우 건너뛰기
                if(visited[nr][nc]) continue;
                if(maps[nr][nc] == 0)continue; //벽(0) 인 경우 건너뛰기 , 위의 사항을 전부 만족했다면 방문
                visited[nr][nc] = true;
                myqueue.add(new Point(nr, nc, curr.dist + 1)); //이동한곳을 큐에 넣어줌. Point 클래스, 거리1 늘려줌
            }
        }
        return -1; //마지막 위치에 도달하지 못했는데 while문에서 나온경우, 도달할 수 없는 곳임. -1 리턴
    }
    public static  class Point{
        Point(int r, int c, int d) {
            row = r; col = c; dist = d;
        }
        int row, col, dist;
    }

    public static int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
}
