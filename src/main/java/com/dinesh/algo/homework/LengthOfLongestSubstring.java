package com.dinesh.algo.homework;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public static void main(String args[]){
        System.out.println(lengthOfLongestSubstring("abcbdcab"));
    }
    private static int lengthOfLongestSubstring(String s){
        int max =0;
        int dif = 0;
        int count =0;
        Map<Character,Integer> sMap = new HashMap<>();
        if(s!=null && s.length()>0) max=1;
        for(int i=0; i<s.length(); i++)
        {
            count++;
            if(sMap.get(s.charAt(i))!=null) {
                //You have to find the length from last position it started in that string
                dif = i - sMap.get(s.charAt(i));
                //The reason why we are taking min is "cccc" , in this case it has to be 1
                count = Math.min(dif,count);
            }
            max = Math.max(count,max);
            sMap.put(s.charAt(i),i);
        }
        return max;
    }
}
