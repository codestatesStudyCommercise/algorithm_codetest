package jeonjinwoo.programmers.lv3;

import java.util.ArrayList;

public class Solution43162 {
    static boolean[] visited;
    static ArrayList<Integer>[] list;

    public static int solution(int n, int[][] computers) {
        visited = new boolean[computers.length + 1]; // 계산용의성을 위해 computers.length + 1 만큼 할당
        list = new ArrayList[computers.length + 1]; // 계산용의성을 위해 computers.length + 1 만큼 할당
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        // 베열 인접 리스트 전환
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (i != j && computers[i][j] == 1) {
                    list[i+1].add(j+1);
                }
            }
        }
        int count = 0;
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }
        return count;
    }

    public static void DFS(int v) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        for (Integer i : list[v]) {
            if (visited[i] == false) {
                DFS(i);
            }
        }
    }

    public static void main(String[] args) {

        // return 2
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }
}
