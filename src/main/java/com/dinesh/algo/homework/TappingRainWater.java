package com.dinesh.algo.homework;

public class TappingRainWater {


    //Here first finding out MaxLeft and max right

    //if right is max i.e. leftMax<rightMax --> left++ then we can go towards right from left

    //else move towards left from right

    //result will be already calculated result + rightMax - height[right] incase if we moving towards left from right

    //result will be already calculated result + leftMax - height[left] incase if we moving towards left from right

    public int trap(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int leftMax = height[left];
        int rightMax = height[right];
        int result = 0;
        while(left<right) {
            //[3,1,0,2] should return 3
            //leftMax -> 3
            //rightMax ->2
            //result = if(leftMax>rightMax) --> result+rightMax-height[right] ->0+2-2 =0

            //rightMax = 2
            //leftMax->3
            //height->0
            //result -> if(leftMax>rightMax) -> result+rightMax-height[right]  ->0+2-0 ->2

            //rightMax =2
            //leftmax ->3
            //height ->1
            //result = result(2)+rightMax(2)-height(1) =3

            //l<


            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                result += leftMax - height[left];
                left++;
            } else {
                result += rightMax - height[right];
                right--;
            }
        }
        return result;
    }
}
