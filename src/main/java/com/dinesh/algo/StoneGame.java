package com.dinesh.algo;

public class StoneGame {
    public static void main(String[] args) {
     int[] stoneValue = {1,2,3,7,3,5,9,7,6};
        System.out.println(stoneGame(stoneValue));
    }

    public static int helper(int[] stoneValue, int i){
       if(i>=stoneValue.length) return 0;
       else {
           int ans= Integer.MIN_VALUE;
           ans = Math.max(ans,stoneValue[i]-helper(stoneValue,i+1));
           if(i+1<stoneValue.length){
               ans = Math.max(ans,stoneValue[i]+stoneValue[i+1]-helper(stoneValue,i+2));
           }
           if(i+2 <stoneValue.length){
               ans = Math.max(ans,stoneValue[i]+stoneValue[i+1]+stoneValue[i+2]-helper(stoneValue,i+3));
           }

           return ans;
       }

    }
    public static String stoneGame(int[] stoneValue){
        int value = helper(stoneValue,0);
        if(value>0) return "Alice";
        if(value==0) return "Tie";
        else return "Bob";

    }
}
