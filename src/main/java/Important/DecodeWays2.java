package Important;

public class DecodeWays2 {
    //Eg:"12" --> AB or L
    //226 -> BBF, WF, BZ
    public static void main(String[] args){

        System.out.println(numDecodings("2367"));//2 ways 1. bcfg, 2. wfg
    }

    private static int numDecodings(String s) {
        // Create a dp array and increase the each value based on the possibilities
        int[] dp = new int[s.length()+1];
        //Let's assign some values for dp array as 0th element as 1 so that we can assign
        //values greater than 10 and less than 26
        dp[0] =1;
        dp[1] = s.charAt(0)=='0'?0:1;
        //Now loop through the String and assign values
        for(int i=2; i<=s.length(); i++){
            // need to find out 1 digit possibilities
            int oneDigit = Integer.parseInt(s.substring(i-1,i));
            int twoDigit = Integer.parseInt(s.substring(i-2,i));
            if(oneDigit<10){
                dp[i] += dp[i-1];
            }
            if(twoDigit<=26 && twoDigit>10){
                dp[i] += dp[i-2];
            }

        }
        return dp[s.length()];
    }
}
