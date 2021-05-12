package baekjoon.implementation;

import java.io.*;

/**
 * #2941 크로아티아 알파벳(https://www.acmicpc.net/problem/2941)
 */
public class CroatianAlphabet {
    static String[] CRO_ALP = {
            "c=", "c-", "dz=", "d-", "lj",
            "nj", "s=", "z="
    };
    static String TEMP_STR = "X";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        for(String ca: CRO_ALP) {
            if(str.contains(ca)) {
                str = str.replaceAll(ca, TEMP_STR);
            }
        }
//        System.out.println(str);
        System.out.println(str.length());

        br.close();
    }
}
