package programmers.lv2.stack.queue;

import java.util.*;

class Truck {
    private int weight;
    private int time;
    
    public Truck(int weight, int time) {
        this.weight = weight;
        this.time = time;
    }
    
    public void addTime() {
        time++;
    }
    
    public int getTime() {
        return time;
    }
    
    public int getWeight() {
        return weight;
    }
    
    public String toString() {
        return String.format("%d(t:%d)", weight, time);
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue truckOnBridge = new LinkedList<Truck>();

        int time = 0;
        int truckIdx = 0;
        int truckWeightSum = 0;
        while(true) {
            time++;
            for(Object truck: truckOnBridge) {
                ((Truck)truck).addTime();
            }
            
            if(!truckOnBridge.isEmpty()) {
                Truck truck = (Truck)truckOnBridge.peek();
                
                if(truck.getTime() > bridge_length) {
                    truckOnBridge.remove();
                    truckWeightSum -= truck.getWeight();
                }
            }
            
            if(truck_weights.length > truckIdx && weight >= truckWeightSum+truck_weights[truckIdx]) {
                int currentTruckWeight = truck_weights[truckIdx++];
                truckWeightSum += currentTruckWeight;
                truckOnBridge.add(new Truck(currentTruckWeight, 1));
            }
                        
            if(truckOnBridge.isEmpty()) 
                break;
        }
        
        return time;
    }
}