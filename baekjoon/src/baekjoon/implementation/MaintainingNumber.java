package baekjoon.implementation;

import java.util.*;

public class MaintainingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        List<Integer> maxList = new ArrayList<>();

        for(int i=0; i<=num; i++) {
            List list = maintainingNumber(num, i);

            if(list.size() > maxList.size()) {
                maxList = list;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<maxList.size(); i++) {
            sb.append(maxList.get(i));

            if(i != maxList.size()-1) {
                sb.append(" ");
            }
        }

        System.out.println(maxList.size());
        System.out.println(sb.toString());

        sc.close();
    }

    public static List maintainingNumber(int num, int next) {
        List<Integer> list = new ArrayList<>();
        list.add(num);
        list.add(next);

        int temp = 0;
        while(true) {
            temp = num - next;
            num = next;
            next = temp;

            if(temp < 0) {
                break;
            }
            list.add(temp);
        }

        return list;
    }
}
