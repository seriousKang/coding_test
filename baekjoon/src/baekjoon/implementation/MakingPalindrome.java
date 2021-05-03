package baekjoon.implementation;

import java.io.*;
import java.util.*;

public class MakingPalindrome {
    static int CHAR_LEN = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int[] charCntArr = new int[CHAR_LEN];

        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            charCntArr[c-'A'] += 1;
        }

        int oddCnt = 0;
        for(int i=0; i<CHAR_LEN; i++) {
            if(charCntArr[i]%2 != 0) {
                oddCnt++;
            }
        }

        if((str.length()%2 == 0 && oddCnt != 0) || (str.length()%2 != 0 && oddCnt != 1)) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            StringBuilder front = new StringBuilder();
            char middleChar = 0;

            for(int i=0; i<CHAR_LEN; i++) {
                char c = (char)('A' + i);
                int charCnt = charCntArr[i];

                if(charCnt%2 != 0) {
                    charCnt--;
                    middleChar = c;
                }

                for(int j=0; j<charCnt/2; j++) {
                    front.append(c);
                }
            }

            StringBuilder result = new StringBuilder();
            result.append(front);
            if(str.length()%2 != 0) result.append(middleChar);
            result.append(front.reverse());

            System.out.println(result);
        }

        br.close();
    }
}
