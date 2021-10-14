package com.dinesh.algo;
//Dynamic programming question
//Bottom up processing
public class DecodeWays {
    //Eg:"12" --> AB or L
    //226 -> BBF, WF, BZ
    public static void main(String[] args){

        System.out.println(numDecodings("2367"));//2 ways 1. bcfg, 2. wfg
    }
    private static int numDecodings(String s){
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0)=='0'?0:1;

        for(int i=2; i<=s.length(); i++){
            int oneDigit = Integer.parseInt(s.substring(i-1,i));
            int twoDigit = Integer.parseInt(s.substring(i-2,i));
            if(oneDigit>=1){
                dp[i] += dp[i-1];
            }
            if(twoDigit>=10 && twoDigit<=26)
            {
                dp[i] += dp[i-2];
            }
        }


        return dp[s.length()];
    }
}
