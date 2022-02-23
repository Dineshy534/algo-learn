package com.dinesh.algo.homework;

public class PrimeNumbersWithInInputNumber {

    public static void main(String[] args) {
        System.out.println(numOfPrimes(20));
        //2,3,5,7,11,13,17,19
    }
    private static int numOfPrimes(int n){
        int count=0;

        boolean[] nonPrimeNumbers = new boolean[n];

        for(int i=2; i*i<n; i++){
            for(int j=i; j*i<n; j++){
                nonPrimeNumbers[i*j] = true;
            }
        }

        for(int k=2; k<n;k++){
            if(!nonPrimeNumbers[k]){
                count++;
            }
        }

        return count;
    }

}
