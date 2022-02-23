package com.dinesh.algo;

import java.util.Arrays;

//Dynamic programming question
//Bottom up processing
public class DecodeWays {
    //Eg:"12" --> AB or L
    //226 -> BBF, WF, BZ


    //2 , 26 (1) -->BZ
    //22,6 (1) ->BB F, WF


    //206
    //2 ,06 ->BF
    //20,6 ->UF

    public static void main(String[] args){

        System.out.println(numDecodings("226"));//bbf, bz,wf
    }

    public static int numDecodings(String s){

        int n = s.length();
        int[] dp = new int[102];
        Arrays.fill(dp,0);
        dp[n+1] = 1;
        dp[n] =1;
        for(int i=n-1; i>=0; i--){
            int num1 = Integer.parseInt(s.substring(i,i+1));;
            int num2 = 0;
            if(i<s.length()-1)
                num2 = Integer.parseInt(s.substring(i,i+2));
            if(num1>0)
                dp[i] += dp[i+1];
            if(num1>0 && num2>0 && num2<=26)
                dp[i] += dp[i+2];
        }

        return dp[0];
    }



    public static int numDecodingsMemoisation(String s) {

        //You have int string s which can be converted into letter Strings
        //We have to find num of ways we can decode
        int[] dp = new int[101];
        Arrays.fill(dp,-1);
        if(s!=null && s.length()>0){
            return helper(s,0,dp);
        }
        return 0;


    }

    static int helper(String s , int i, int[] dp){
        //Let's start coding and finish this stuff
        //Now write the base case, if i crosses string length
        if(i>=s.length()){
            return 1;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int ans =0;
        int num1 = Integer.parseInt(s.substring(i,i+1));;
        int num2 = 0;
        if(i<s.length()-1)
            num2 = Integer.parseInt(s.substring(i,i+2));

        if(num1>0)
            ans += helper(s,i+1,dp);
        if(num1>0&& num2>0 && num2<= 26)
            ans += helper(s,i+2,dp);
        dp[i] = ans;
        return dp[i];
    }
    /*
    public int numDecodings(String s) {
        int n=s.length();
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1] = s.charAt(0)=='0'?0:1;
        for(int i=0;i<n;i--)
            if(s.charAt(i)!='0') {
                dp[i]=dp[i+1];
                if(i<n-1&&(s.charAt(i)=='1'||s.charAt(i)=='2'&&s.charAt(i+1)<'7'))
					dp[i]+=dp[i+2];
            }
        return dp[n];
    }
     */
}
