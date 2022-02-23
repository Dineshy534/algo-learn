package com.dinesh.algo;

import java.util.Arrays;

//This is memoisation or topdown DP
public class StoneGameBottomUp {
    //static int  dp[] = new int[50001];
    public static void main(String[] args) {
        int[] stoneValue = {1,2,3,7};
        System.out.println(stoneGame(stoneValue));
    }

    public static String stoneGame(int[] stoneValue){
        int[] dp = new int[stoneValue.length+1];

        Arrays.fill(dp,0);
        int i = stoneValue.length-1;

        while(i>=0){
            int ans = Integer.MIN_VALUE;
            ans = Math.max(ans,stoneValue[i]-dp[i+1]);
            if(i+1<stoneValue.length){
                ans = Math.max(ans,stoneValue[i]+stoneValue[i+1]-dp[i+2]);
            }
            if(i+2 <stoneValue.length){
                ans = Math.max(ans,stoneValue[i]+stoneValue[i+1]+stoneValue[i+2]-dp[i+3]);
            }
            dp[i] = ans;
            i--;
        }

        int value = dp[0];
        if(value>0) return "Alice";
        if(value==0) return "Tie";
        else return "Bob";

    }
}
