package baekjoon.dynamic.programming;

import java.io.*;

public class ClimbingStairs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[] distances = new int[size+1];
        int[] maxDistances = new int[size+1];

        for(int i=1; i<=size; i++) {
            distances[i] = Integer.parseInt(br.readLine());
        }

        int maxDistance = getMaxDistance(distances, maxDistances);
        System.out.println(maxDistance);

        br.close();
    }

    public static int getMaxDistance(int[] distances, int[] maxDistances) {
        int size = distances.length - 1;

        int maxDistance = 0;
        if(size < 3) {
            for(int i=1; i<=size; i++) {
                maxDistance += distances[i];
            }
        } else {
            maxDistances[1] = distances[1];
            maxDistances[2] = distances[1] + distances[2];

            for(int j=3; j<=size; j++) {
                maxDistances[j] = Math.max(maxDistances[j-2], maxDistances[j-3] + distances[j-1]) + distances[j];
            }

            maxDistance = maxDistances[size];
        }

        return maxDistance;
    }
}
