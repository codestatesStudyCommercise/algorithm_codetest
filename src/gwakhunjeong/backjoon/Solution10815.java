package gwakhunjeong.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution10815 {
    static int n, m;
    static int[] res;
    static int[] haveCard;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n= Integer.parseInt(br.readLine());

        haveCard = new int[n];
        String[] card = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            haveCard[i] = Integer.parseInt(card[i]);
        }
        Arrays.sort(haveCard);

        m = Integer.parseInt(br.readLine());
        int[] compareCard = new int[m];
        String[] cardX = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            compareCard[i] = Integer.parseInt(cardX[i]);
        }

        res = new int[m];

        br.close();

        for (int i = 0; i < m; i++) {
            res[i] = BinarySearch(compareCard[i]);
        }

        System.out.print(res[0]);
        for (int i = 1; i < m; i++) {
            System.out.print(" " + res[i]);
        }

    }
    //재귀
    private static int BinarySearch(int cardX) {
        int leftIndex = 0;
        int rightIndex = n -1;

        while (leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            int mid = haveCard[midIndex];

            if(cardX < mid ) rightIndex = midIndex - 1;
            else if( cardX > mid) leftIndex = midIndex + 1;
            else return 1;
        }
        return 0;
    }
}
