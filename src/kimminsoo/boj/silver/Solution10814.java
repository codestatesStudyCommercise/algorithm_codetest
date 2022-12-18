package kimminsoo.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] age = new String[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            age[i][0] = st.nextToken();
            age[i][1] = st.nextToken();
        }

        //나이 기준으로 정렬 이름은 들어온 순서라서 나이만 정렬하면 됨
//        Arrays.sort(age, Comparator.comparing(o1 -> o1[0]));
        Arrays.sort(age, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.println(age[i][0] + " " + age[i][1]);
        }
    }
}
