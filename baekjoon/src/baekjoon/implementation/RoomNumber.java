package baekjoon.implementation;

import java.util.*;

public class RoomNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        System.out.println(getRequiredSetNumber(str));

        sc.close();
    }

    public static int getRequiredSetNumber(String str) {
        int[] arr = new int[10];

        String[] pieces = str.split("");
        for(String piece: pieces) {
            Integer num = Integer.parseInt(piece);

            if(num == 9 && arr[6] < arr[9]) {
                arr[6] += 1;
                continue;
            } else if(num == 6 && arr[6] > arr[9]) {
                arr[9] += 1;
                continue;
            }

            arr[num] += 1;
        }
//        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);

        return arr[arr.length-1];
    }
}
