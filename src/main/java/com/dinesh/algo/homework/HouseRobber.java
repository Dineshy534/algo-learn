package com.dinesh.algo.homework;

public class HouseRobber {
    public static void main(String[] args) {
        //You can rob a house if they are not adjacent, Find the max you can rob
        int[] houseMoney = {5,20,34,8,3,3};
        int maxMoney = startRobbing(houseMoney);
        System.out.println(maxMoney);
    }

    private static int startRobbing(int[] nums) {
        //You can rob a max amount not from adjacent houses
       //Let's rob it

        if(nums ==null || nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i=2; i<nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }

        return dp[nums.length-1];

    }
}
