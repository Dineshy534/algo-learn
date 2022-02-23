package com.dinesh.algo.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharByFrequency {
    public static void main(String[] args) {
        System.out.println("tree in sorted order   "+ frequencySort("tree"));
    }
    private static String frequencySort(String s){
        Map<Character,Integer> charMap = new HashMap<>();

        for(char c: s.toCharArray()){
            charMap.put(c,charMap.getOrDefault(c,0)+1);
        }

        PriorityQueue<Character> characterQueue = new PriorityQueue<>((o1, o2) -> charMap.get(o2)-charMap.get(o1));
        characterQueue.addAll(charMap.keySet());
        StringBuilder sb = new StringBuilder();
        while (!characterQueue.isEmpty()){
            Character c = characterQueue.remove();
            for(int i=0; i<charMap.get(c);i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
