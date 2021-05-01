package baekjoon.implementation;

import java.util.ArrayList;
import java.util.List;

public class SelfNumber {
    public static void main(String[] args) {
        List list = new ArrayList<>();

        for(int i=1; i<=10000; i++) {
            int num = d(i);
            if(!list.contains(num)) list.add(num);
        }

        for(int i=1; i<=10000; i++) {
            if(!list.contains(i)) System.out.println(i);
        }
    }

    public static int d(Integer num) {
        int result = num;

        String str = num.toString();
        String[] arr = str.split("");

        for(int i=0; i<arr.length; i++) {
            result += Integer.parseInt(arr[i]);
        }

        return result;
    }
}
