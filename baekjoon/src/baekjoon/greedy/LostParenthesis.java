package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class LostParenthesis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String statement = br.readLine();
        String[] arr = statement.split("-");

        List<Integer> list = new ArrayList<>();
        for(String str: arr) {
            if(str.contains("+")) {
                String[] subArr = str.split("\\+");
                Integer sum = 0;
                for(int i=0; i<subArr.length; i++) {
                    sum += Integer.parseInt(subArr[i]);
                }
                list.add(sum);
            } else {
                list.add(Integer.parseInt(str));
            }
        }

        int result = list.get(0);
        for(int i=1; i<list.size(); i++) {
            result -= list.get(i);
        }
        System.out.println(result);

        br.close();
    }
}
