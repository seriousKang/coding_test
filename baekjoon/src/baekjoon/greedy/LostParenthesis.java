package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class LostParenthesis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String statement = br.readLine();
        List<String> list = new ArrayList<>();

        int cursor=0;
        for(int i=0; i<statement.length(); i++) {
            char c = statement.charAt(i);
            if(c == '-' || c == '+') {
                String num = statement.substring(cursor, i);
                list.add(num);
                list.add(Character.toString(c));
                cursor = i+1;
            }

            if(i == statement.length()-1) {
                list.add(statement.substring(cursor));
            }
        }

        Stack<String> stack = new Stack<>();
        for(int i=0; i<list.size(); i++) {
            String str = list.get(i);
            if(str.equals("+")) {
                int before = Integer.parseInt(stack.pop());
                int after = Integer.parseInt(list.get(++i));

                stack.push(String.valueOf(before+after));
            } else {
                stack.push(str);
            }
        }
//        System.out.println(stack);

        List<String> reverseList = new ArrayList<>();
        while(!stack.isEmpty()) {
            reverseList.add(stack.pop());
        }
//        System.out.println(reverseList);

        int result=0;
        for(int i=reverseList.size()-1; i>=0; i--) {
            String str = reverseList.get(i);

            if(str.equals("-")) {
                result -= Integer.parseInt(reverseList.get(--i));
            } else {
                result += Integer.parseInt(str);
            }
        }
        System.out.println(result);

        br.close();
    }
}
