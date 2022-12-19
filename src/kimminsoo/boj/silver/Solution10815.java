package kimminsoo.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String result 로 사용했을때 시간초과 나서 StringBuilder 사용
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] first = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            first[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(first);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            sb.append(binarySearch(Integer.parseInt(st.nextToken()), first));
        }

        System.out.println(sb);
    }

    //이진탐색 사용
    public static String binarySearch(int i, int[] first) {
        int lIdx = 0;
        int rIdx = first.length - 1;
        while(lIdx <= rIdx) {
            int mIdx = (lIdx + rIdx) / 2;

            if(i < first[mIdx]) {
                rIdx = mIdx - 1;
            } else if(i > first[mIdx]) {
                lIdx = mIdx + 1;
            } else {
                return "1 ";
            }
        }
        return "0 ";
    }
//      1차 완전 탐색 이용 시간초과
//    public static void solution1() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        ArrayList<Integer> first = new ArrayList<>();
//        ArrayList<Integer> second = new ArrayList<>();
//        String result = "";
//
//        int n = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for(int i = 0; i < n; i++) {
//            first.add(Integer.valueOf(st.nextToken()));
//        }
//
//        int m = Integer.parseInt(br.readLine());
//        StringTokenizer st2 = new StringTokenizer(br.readLine());
//        for(int i = 0; i < m; i++) {
//            second.add(Integer.valueOf(st2.nextToken()));
//        }
//
//        //두번째를 돌면서 첫번째 ArrayList 에 있는지 확인
//        for(int i = 0; i < m; i++) {
//            if(first.contains(second.get(i))) {
//                result += "1 ";
//            } else {
//                result += "0 ";
//            }
//        }
//        result.substring(0, result.length() - 1);
//
//        System.out.println(result);
//    }

//      이분탐색을 사용해도 시간초과
//    public static void solution2() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String result = "";
//
//        int n = Integer.parseInt(br.readLine());
//        int[] first = new int[n];
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for(int i = 0; i < n; i++) {
//            first[i] = (Integer.valueOf(st.nextToken()));
//        }
//        Arrays.sort(first);
//
//        int m = Integer.parseInt(br.readLine());
//        int[] second = new int[m];
//        StringTokenizer st2 = new StringTokenizer(br.readLine());
//        for(int i = 0; i < m; i++) {
//            second[i] = (Integer.valueOf(st2.nextToken()));
//        }
//
//        //값을 하나하나 대입
//        for(int i = 0; i <m; i++) {
//            result += binarySearch(second[i], first);
//        }
//
//        //마지막에 공백이 포함되어있어 잘라냄
//        result = result.substring(0, result.length() - 1);
//
//        System.out.println(result);
//    }
}

