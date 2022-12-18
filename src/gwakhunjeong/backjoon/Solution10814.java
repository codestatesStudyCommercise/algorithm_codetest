package gwakhunjeong.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution10814 {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine()); //IOException

        String[][] arr = new String[num][2];

        //띄어쓰기를 구분자로 2차원 배열에 {나이, 이름} 입력
        for (int i = 0; i < num; i++) {
            String[] st = br.readLine().split(" ");
            arr[i][0] = st[0];
            arr[i][1] = st[1];
        }

        //sort 오버라이드
        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {//2차원 배열이면 String[], 1차원 배열이면 String
                //o1 은 첫번째 행 o2 는 두번째 행 리턴값이 양수라면 앞의 o1이 먼저 정렬됨. 음수면 뒤가 정렬
                if (o1[0] == o2[1]) {// 같을땐 순서대로.
                    return 1;
                } else {
                    //음수나오면 뒷값이 더큼 -> 뒷값 먼저 정렬
                    return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
                }
            }
        });

        //출력
        for (int i = 0; i < num; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }

    }
}
