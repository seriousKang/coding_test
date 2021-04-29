package baekjoon;

import java.util.*;

public class JosephusProblem0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=N; i++) {
            list.add(i);
        }

        int cursor = 0;
        List<Integer> result = new ArrayList<>();
        while(!list.isEmpty()) {
            cursor = (cursor + K - 1) % list.size();

            result.add(list.get(cursor));
            list.remove(cursor);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i=0; i<result.size(); i++) {
            sb.append(result.get(i));

            if(i == result.size()-1)
                break;

            sb.append(", ");
        }
        sb.append(">");

        System.out.println(sb.toString());
        sc.close();
    }
}
