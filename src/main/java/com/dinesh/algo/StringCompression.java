package com.dinesh.algo;

public class StringCompression {

    public static void main(String[] args){
        char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(compress(chars));
    }
    private static int compress(char[] chars){
        int index =0;
        int i =0;
        while(i<chars.length){
            int j = i;
            while (j<chars.length && chars[i] == chars[j]){
                j++;
            }
            chars[index++] = chars[i];
            if(j-i>1){
                String countString = j-i+"";
                for(char c: countString.toCharArray()){
                    chars[index++] = c;
                }
            }
            i= j;
        }
        return index;
    }
}
