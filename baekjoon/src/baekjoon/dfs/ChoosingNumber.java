package baekjoon.dfs;

import java.util.*;

public class ChoosingNumber {
    static int N;
    static int[] arr;
    static boolean[] checked;
    static List<Integer> finalList = new ArrayList<Integer>();

    public static boolean dfs(int startIdx, int lastValue, List<Integer> list) {
        if(startIdx == lastValue) {
            for(int value: list) {
                finalList.add(value);
                checked[value] = true;
            }

            return true;
        }

        list.add(lastValue);
        int currentLastValue = arr[lastValue];
        if(!checked[lastValue]) {
            checked[lastValue] = true;
            boolean isFind = dfs(startIdx, currentLastValue, list);
            if(!isFind) {
                checked[lastValue] = false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N+1];
        checked = new boolean[N+1];

        for(int i=1; i<=N; i++) {
            arr[i] = sc.nextInt();
        }
//        System.out.println(Arrays.toString(arr));

        for(int i=1; i<=N; i++) {
            if(!checked[i]) {
                checked[i] = true;
                List<Integer> list = new ArrayList<>();
                list.add(i);
                dfs(i, arr[i], list);
            }
        }

        Collections.sort(finalList);
        System.out.println(finalList.size());
        for(int value: finalList) {
            System.out.println(value);
        }

        sc.close();
    }
}
