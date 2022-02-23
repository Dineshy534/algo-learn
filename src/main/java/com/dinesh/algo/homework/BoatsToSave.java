package com.dinesh.algo.homework;

import java.util.Arrays;

public class BoatsToSave {

    public static void main(String[] args) {

    }
    private int numRescueBoats(int[] people, int limit){
        Arrays.sort(people);
        int count= 0;

        //So the actual problem is heavy person goes with lighter person, number of boats will be less

        int i=0;
        int j= people.length-1;
        int numberOfBoats = 0;
        while (i<=j){
            if(people[i]+people[j] <=limit){
                i++;
                j--;
            } else {
                j--;
            }
            numberOfBoats++;
        }
        return numberOfBoats;
    }

}
