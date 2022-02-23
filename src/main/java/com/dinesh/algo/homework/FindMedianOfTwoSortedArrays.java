package com.dinesh.algo.homework;

public class FindMedianOfTwoSortedArrays {
    //Simple logic to apply by shifting both the arrays at the sametime.. So just partition
    //Based on the small input array and check the left and right.. and move direction accordingly
    //This solution applicable to all the edge case scenarios

    public static void main(String[] args) {
       /* int[] x = {1, 3, 8, 9, 15};
        int[] y = {7, 11, 19, 21, 18, 25};*/
        int[] x = {1, 2};
        int[] y = {3,4};
        double median =  findMedianOfTwoArrays(x,y);
        System.out.println("Median"+median);
    }

    private static double findMedianOfTwoArrays(int[] input1, int[] input2) {

        if(input1.length>input2.length){
            return findMedianOfTwoArrays(input2,input1);
        }
        int x = input1.length;
        int y = input2.length;

        //So we have to run a loop until we found the median
        int low = 0;
        int high = x;
        while (low<=high){
            //I'll try to partition as low as possible
            int partitionX = (low+high)/2;
            int partitionY = (x+y+1)/2 - partitionX;

            //Now we have to initialize maxLeftx,minRightx, maxleftY, minRightY
            int maxLeftX = (partitionX==0)?Integer.MIN_VALUE:input1[partitionX-1];
            int minRightX= (partitionX==x)?Integer.MAX_VALUE:input1[partitionX];
            int maxLeftY = (partitionY==0)?Integer.MIN_VALUE:input2[partitionY-1];
            int minRightY= (partitionY==y)?Integer.MAX_VALUE:input2[partitionY];

            //Now we have to find out maxLeftX < minRightY && maxLeftY<minRightX..

            if(maxLeftX<=minRightY && maxLeftY<=minRightX){
                if((x+y)%2==0){
                    return ((double)(Math.max(maxLeftX,maxLeftY)+Math.min(minRightX,minRightY))/2);
                } else {
                    return  (double) (Math.max(maxLeftX,maxLeftY));
                }
            }

            else if(maxLeftX>minRightY){
                //Shift input arry to left
                high = partitionX-1;
            }
            else {
                //Shift input array to right
                low = partitionX+1;
            }

        }
        throw new IllegalArgumentException("");
    }
}
