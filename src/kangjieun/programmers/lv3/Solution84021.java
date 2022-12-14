package kangjieun.programmers.lv3;

import java.util.*;

public class Solution84021 {
    public static void main(String[] args) {

        int result = solution(
                new int[][] {
                        {1,1,0,0,1,0},
                        {0,0,1,0,1,0},
                        {0,1,1,0,0,1},
                        {1,1,0,1,1,1},
                        {1,0,0,0,1,0},
                        {0,1,1,1,0,0}},

                new int[][]{
                        {1,0,0,1,1,0},
                        {1,0,1,0,1,0},
                        {0,1,1,0,1,1},
                        {0,0,1,0,0,0},
                        {1,1,0,1,1,0},
                        {0,1,0,0,0,0}
                }
        );
        System.out.println(result); // 14

        int result1 = solution(
               new int[][] {
                       {0,0,0},
                       {1,1,0},
                       {1,1,1}
               },
                new int[][] {
                        {1,1,1},
                        {1,0,0},
                        {0,0,0}
               }
        );
        System.out.println(result1); //0


        int result2 = solution(
                new int[][] {
                        {1,1,0,0},
                        {0,0,1,1},
                        {0,1,1,1},
                        {1,0,0,0}
                },
                new int[][] {
                        {1,0,1,1},
                        {1,0,1,1},
                        {0,0,0,0},
                        {0,1,1,1}
                }
        );
        System.out.println(result2); //5


        int result3 = solution(
                new int[][] { //gameboard
                        {1,1,0,0},
                        {0,0,1,1},
                        {0,1,1,1},
                        {1,0,0,0}
                },
                new int[][] { //table
                        {1,0,1,1},
                        {1,0,0,1},
                        {0,0,0,0},
                        {0,1,1,1}
                }
        );
        System.out.println(result3); //8
    }
    public static int solution(int[][] game_board, int[][] table) {

        length = table.length;
        //table에서 1을 발견하면, 해당 위치로부터 bfs(상하좌우)돌면서 상대 좌표 저장

        boolean[][] visited = new boolean[length][length];
        boolean[][] visitedGame = new boolean[length][length];


        ArrayList<ArrayList<Pair>> 테이블_리스트 = new ArrayList<ArrayList<Pair>>();
        ArrayList<ArrayList<Pair>> 게임보드_리스트 = new ArrayList<ArrayList<Pair>>();


        for (int i=0; i<length;i++) {
            for (int j=0; j<length;j++) {
                if (table[i][j] == 1 && !visited[i][j]) {
                    bfs(i,j,table, visited, 1, 테이블_리스트 );
                }
                if( game_board[i][j] == 0 && !visitedGame[i][j]) {
                    bfs(i,j,game_board, visitedGame, 0, 게임보드_리스트 );
                }
            }
        }


        //미리정렬
        sortArray(테이블_리스트);
        sortArray(게임보드_리스트);

        // 데이터 : 전체_상대좌표_4방향[puzzle인덱스][칸의개수][방향] . r/c
        //게임보드 순회

        int answer = 0;

        int gameBoard_Num = 게임보드_리스트.size();
        int table_Puzzle_Num = 테이블_리스트.size();
        boolean[] visitedBoard = new boolean[gameBoard_Num];

        for(int t=0; t<table_Puzzle_Num; t++) {
            ArrayList<Pair> 퍼즐 = 테이블_리스트.get(t);
            for(int g=0 ;g<gameBoard_Num;g++) {
                ArrayList<Pair> 퍼즐들어갈곳 = 게임보드_리스트.get(g);
                if(퍼즐.size()== 퍼즐들어갈곳.size()  && !visitedBoard[g]) {
                    //rotate
                    if(rotateArray(퍼즐들어갈곳, 퍼즐)){
                        answer += 퍼즐들어갈곳.size()+1; //0,0을 상대좌표에서 처리를 안해줬다.
                        visitedBoard[g] = true;
                    }
                }
            }
        }

        return answer;
    }

    static void sortArray(ArrayList <ArrayList<Pair>> 들어온배열) {
        for(int i=0;i<들어온배열.size();i++) {
            MyComparator myComparator = new MyComparator();
            Collections.sort(들어온배열.get(i), myComparator);
        }
    }

    static boolean rotateArray(ArrayList<Pair> 퍼즐들어갈곳, ArrayList<Pair> 퍼즐) {

        boolean returnCheck = false;

        //퍼즐을 최대 4번까지 돌리면서, 게임판 빈칸과 매칭이 되는지 확인 된다
        int puzzleSize = 퍼즐.size();
        int check = puzzleSize;

        for(int kan = 0; kan <puzzleSize; kan++) {
            int 퍼즐칸r = 퍼즐.get(kan).r, 퍼즐칸c = 퍼즐.get(kan).c;
            int 퍼즐들어갈곳칸r = 퍼즐들어갈곳.get(kan).r , 퍼즐들어갈곳칸c =퍼즐들어갈곳.get(kan).c;

            for(int i = 0; i<4; i++) {
                if (퍼즐칸r == 퍼즐들어갈곳칸r && 퍼즐칸c == 퍼즐들어갈곳칸c ) {
                    check --;
                    break;
                }
                //여기문제!
                int tmp = 퍼즐칸r;
                퍼즐칸r = 퍼즐칸c;
                퍼즐칸c = -tmp;
            }
        }
        if(check == 0) {
            returnCheck = true;
        }

        return returnCheck;
    }

    static int length;
    static int[][] d = {{-1,0},{1,0},{0,1},{0,-1}};

    public static void bfs( int y, int x,  int[][] array , boolean[][] visited, int n, ArrayList <ArrayList<Pair>> 전체_리스트) {

        ArrayList<Pair> 상대좌표배열 = new ArrayList<>();
//        상대좌표배열.add(new Pair(0,0));
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{y,x});
        visited[y][x] = true;

        while (!queue.isEmpty()) {

            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];

            for (int i=0; i<4; i++) {
                int dr = r+d[i][0];
                int dc = c+d[i][1];

                if( dr<0 || dr>=length || dc<0 || dc>=length) {
                    continue;
                }

                if(!visited[dr][dc] && array[dr][dc] == n){

                    //상대좌표 저장
                    상대좌표배열.add(new Pair(dr-y,dc-x));

                    visited[dr][dc] =true;
                    queue.add(new int[] {dr,dc});
                }
            }
        }

        전체_리스트.add(상대좌표배열);
        //전체_상대좌표_4방향.add(상대좌표_4방향);
    }

}

class Pair {
    int r, c;

    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class MyComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair p1, Pair p2) {
        if (p1.r > p2.r) {
            return 1; // x에 대해서는 오름차순
        }
        else if (p1.r == p2.r) {
            if (p1.c > p2.c) { // y에 대해서도 오름차순
                return 1;
            }
        }
        return -1;
    }
}