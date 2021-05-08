package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class CardCombinationGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cardNum;
        int combinationNum;
        Long[] cards;

        String[] conditions = br.readLine().split(" ");
        cardNum = Integer.valueOf(conditions[0]);
        combinationNum = Integer.valueOf(conditions[1]);

        cards = new Long[cardNum];
        String[] strCards = br.readLine().split(" ");

        for(int i=0; i<cardNum; i++) {
            cards[i] = Long.valueOf(strCards[i]);
        }

        for(int i=0; i<combinationNum; i++) {
            combination(cards);
//            System.out.println(Arrays.toString(cards));
        }

        Long result=0l;
        for(Long card:cards) {
            result += card;
        }
        System.out.println(result);

        br.close();
    }

    public static void combination(Long[] cards) {
        Arrays.sort(cards);

        Long sum = cards[0] + cards[1];
        cards[0] = cards[1] = sum;
    }
}
