package baekjoon.implementation;

import java.io.*;
import java.util.*;

public class RoadAndTrafficLights {
    static int MAX_ROAD_LENGTH = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] conditions = br.readLine().split(" ");
        int trafficLightSize = Integer.valueOf(conditions[0]);
        int roadLength = Integer.valueOf(conditions[1]);
        TrafficLight[] trafficLights = new TrafficLight[MAX_ROAD_LENGTH+1];

        for(int i=0; i<trafficLightSize; i++) {
            String[] trafficLightInfo = br.readLine().split(" ");

            int location = Integer.valueOf(trafficLightInfo[0]);
            int red = Integer.valueOf(trafficLightInfo[1]);
            int green = Integer.valueOf(trafficLightInfo[2]);

            TrafficLight trafficLight = new TrafficLight(red, green);
            trafficLights[location] = trafficLight;
        }
//        System.out.println(Arrays.toString(trafficLights));

        int time=0;
        int currentPosition=0;
        while(currentPosition != roadLength) {
            currentPosition++;
            time++;

            TrafficLight currentTrafficLight = trafficLights[currentPosition];
            if(currentTrafficLight != null) {
                int red = currentTrafficLight.red;
                int green = currentTrafficLight.green;
                int sum = red + green;

                int tempTime = time % sum;
                while(tempTime < red) {
                    tempTime++;
                    time++;
//                    System.out.println(tempTime);
                }
            }
        }
        System.out.println(time);

        br.close();
    }
}

class TrafficLight {
    int red;
    int green;

    public TrafficLight(int red, int green) {
        this.red = red;
        this.green = green;
    }
}
