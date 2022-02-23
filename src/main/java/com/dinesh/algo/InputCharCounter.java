package com.dinesh.algo;

public class InputCharCounter {

    public static void main(String args[]){
        String s = "aaabbcc";
        System.out.println("Returning char count of given string "+ s );
        System.out.println(countCharNum(s));
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    private static String countCharNum(String s) {
        if(s == null ||s.length()==0){
            return "";
        }
        int counter =0;
        char previousChar=0;
        char[] charArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c: charArray){
            if(c!=0 && c==previousChar){
                counter++;
            }
            else {
                if((previousChar!=0 ) ){
                    sb.append(previousChar);
                    sb.append(counter);
                }
                previousChar=c;
                counter=1;
            }
        }

        sb.append(previousChar);
        sb.append(counter);

        return sb.toString();
    }
    public static int lengthOfLongestSubstring(String s) {
        // Easiest is check if the character repeated or not
        //If char repeats then do not even think about it

        char[] charArray= s.toCharArray();

        int count =0;

        int previousCount = 0;

        //Main logic here is finding the last character where it started.. and
        //
        return previousCount;
    }
}

/*
Learnt
DFS
BFS
InputCharcount

 */
