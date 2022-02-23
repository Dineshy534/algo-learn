package com.dinesh.algo.homework;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println( findNumberOfWaysForClimbingStairs(5));
    }

    //You can climb stairs either 1 or 2 at a time..
    /*Let's say you have 3 steps,
    you can do 1,1,1 --> 1way , 2,1 -> 1way, 1,2 -> 1 way... Total 3 ways*/

    private static int findNumberOfWaysForClimbingStairs(int n) {
        //Let's climb the stairs
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<n+1;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
