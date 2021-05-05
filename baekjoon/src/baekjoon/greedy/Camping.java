package baekjoon.greedy;

import java.io.*;
import java.util.*;

/**
 * #4769 캠핑(https://www.acmicpc.net/problem/4796)
 */
public class Camping {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new ArrayList<>();
        while(true) {
            String condition = br.readLine();
            if(condition.equals("0 0 0")) {
                break;
            }
            list.add(condition);
        }

        for(int i=0; i<list.size(); i++) {
            String[] condition = list.get(i).split(" ");
            int L = Integer.parseInt(condition[0]);
            int P = Integer.parseInt(condition[1]);
            int V = Integer.parseInt(condition[2]);

            System.out.printf("Case %d: %d", i+1, maxDate(L, P, V));
            if(i != list.size()-1) {
                System.out.println();
            }
        }

//        String[] condition = "5 40 40".split(" ");
//        int L = Integer.parseInt(condition[0]);
//        int P = Integer.parseInt(condition[1]);
//        int V = Integer.parseInt(condition[2]);
//        System.out.println(maxDate(L, P, V));

        br.close();
    }

    public static int maxDate(int L, int P, int V) {
        int maxDate = 0;
        int division = V/P;
        int remain = V%P;

        maxDate += division*L;
        if(remain <= L) {
            maxDate += remain;
        } else {
            maxDate += L;
        }

        return maxDate;
    }
}
