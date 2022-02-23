package com.dinesh.algo.homework;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {

    public static void main(String[] args) {
        // [[0, 30],[5, 10],[15, 20]]

        Interval[] intervals = new Interval[6];
        intervals[0] = new Interval(0,30);
        intervals[1] = new Interval(5,10);
        intervals[2] = new Interval(15,20);
        intervals[3] = new Interval(15,20);
        intervals[4] = new Interval(15,20);
        intervals[5] = new Interval(15,20);
        System.out.println("Minimum meeting rooms required is "+minMeetingRooms(intervals));
    }
    public static int minMeetingRooms(Interval[] intervals){
        //Our logic is very simple.. Let's sort intervals based on start time
        //and then just verify end time is greater than max greater available
        // So for storing end time, we can create minHeap to just store the max and other end times
       Arrays.sort(intervals,(i1,i2) -> i1.start- i2.start);
       PriorityQueue<Integer> minQueue = new PriorityQueue<>();
       minQueue.add(intervals[0].end);
       for(int i=1; i<intervals.length; i++){
           //minQueue.peek will return smallest endTime
           if(intervals[i].start>=minQueue.peek()){
               minQueue.poll();
           }
           minQueue.add(intervals[i].end);
       }
       return minQueue.size();
    }

}
class Interval{
    int start;
    int end;
    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}
