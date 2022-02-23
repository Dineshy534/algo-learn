package com.dinesh.algo;

//This is memoisation or topdown DP
public class StoneGameMemoisation {
    static int  dp[] = new int[50001];
    public static void main(String[] args) {
        int[] stoneValue = {1,2,3,7,3,5,9,7,6};
        System.out.println(stoneGame(stoneValue));
    }

    public static int helper(int[] stoneValue, int i){
        if(i>=stoneValue.length) return 0;
        if(dp[i]!=-1) return dp[i];
        else {
            int ans= Integer.MIN_VALUE;
            ans = Math.max(ans,stoneValue[i]-helper(stoneValue,i+1));
            if(i+1<stoneValue.length){
                ans = Math.max(ans,stoneValue[i]+stoneValue[i+1]-helper(stoneValue,i+2));
            }
            if(i+2 <stoneValue.length){
                ans = Math.max(ans,stoneValue[i]+stoneValue[i+1]+stoneValue[i+2]-helper(stoneValue,i+3));
            }
            dp[i] = ans;
            return ans;
        }

    }
    public static String stoneGame(int[] stoneValue){
        for(int i=0; i<stoneValue.length;i++){
            dp[i] = -1;
        }
        int value = helper(stoneValue,0);
        if(value>0) return "Alice";
        if(value==0) return "Tie";
        else return "Bob";

    }
}
