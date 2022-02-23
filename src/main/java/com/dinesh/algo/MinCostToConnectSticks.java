package com.dinesh.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostToConnectSticks {

    public static void main(String[] args) {
        MinCostToConnectSticks mc = new MinCostToConnectSticks();
        List<Integer> sticks = new ArrayList<>();
        sticks.add(1);
        sticks.add(8);
        sticks.add(3);
        sticks.add(5);
        System.out.println("Min cost "+minimumCost(sticks));
    }
    public static int minimumCost(List<Integer> sticks) {
        // write your code here
        //Our logic is get the smallest sticks first and get the cost
        //Add smallest sticks if cost is greater than last 2 sticks
        //We can use minHeap priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(Integer i:sticks){
            pq.add(i);
        }
        int cost = 0;
        while(pq.size()>1){
            int sum = pq.remove()+pq.remove();
            cost += sum;
            pq.add(sum);
        }
        return cost;


    }
}
