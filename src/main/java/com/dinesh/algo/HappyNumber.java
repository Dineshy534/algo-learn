package com.dinesh.algo;

import java.util.ArrayList;
import java.util.List;

public class HappyNumber {
    public static void main(String[] args) {
        List<String> testList = new ArrayList<>();
        testList.add("test");
        testList.add("test1");
        testList.add("test2");
        testList.remove("test");

        System.out.println(testList);


        isHappy(19);
    }
    public static boolean isHappy(int n) {

        int totalSum = 0;

        while(totalSum !=1){

            while(n>0){
                int remainder = n%10;
                totalSum += remainder* remainder;
                n = n/10;
            }
            if(totalSum ==1){
                return true;
            } else{
                n = totalSum;
                totalSum =0 ;
            }
        }


        return false;

    }
}
