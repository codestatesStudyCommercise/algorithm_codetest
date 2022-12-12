package gwakhunjeong.programers.lv3;

public class Solution43162 {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int vertex = 0; vertex < visited.length; vertex++) {
            if (!visited[vertex]) {
                count++;
                visited = dfs_array(computers, vertex, visited);
            }
        }
        return count;
    }
    public static boolean[] dfs_array(int[][] computers, int vertex, boolean[] visited) {
        visited[vertex] = true;

        for(int i = 0; i < computers.length; i++) {
            if(computers[vertex][i] == 1 && !visited[i]) {
                dfs_array(computers, i, visited);
            }
        }
        return visited;
    }
}
