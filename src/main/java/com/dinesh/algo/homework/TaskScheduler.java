package com.dinesh.algo.homework;

import java.util.*;

public class TaskScheduler {

    /*
    Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.

Return the least number of units of times that the CPU will take to finish all the given tasks.

 

Example 1:

Input: tasks = ["A','A','A','B','B','B"], n = 2
Output: 8
Explanation: 
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.
Example 2:

Input: tasks = ["A','A','A','B','B','B"], n = 0
Output: 6
Explanation: On this case any permutation of size 6 would work since n = 0.
["A','A','A','B','B','B"]
["A','B','A','B','A','B"]
["B','B','B','A','A','A"]
...
And so on.
Example 3:

Input: tasks = ["A','A','A','A','A','A','B','C','D','E','F','G"], n = 2
Output: 16
Explanation: 
One possible solution is
A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
     */
    
  public static void main(String[] args)  {

      char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
      int n = 2;
      //Answer 16

      System.out.println("Least cycles possible "+ leastInterval(tasks,n));

  }
    private static int leastInterval(char[] tasks, int n) {
      //first add the chars based on the most frequency chars
        Map<Character,Integer> map = new HashMap<>();
        for(char c: tasks){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        pq.addAll(map.values());
        int cycles =0;
        while(!pq.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<n+1 ;i++){
                if(!pq.isEmpty()){
                    temp.add(pq.remove());
                }
            }
            for(Integer k: temp){
                if(--k>0){
                    pq.add(k);
                }
            }

            cycles += pq.isEmpty()? temp.size():n+1;

        }

        return cycles;
    }
    
    
}
