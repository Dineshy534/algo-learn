package com.dinesh.algo.homework;

public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] grid) {

        //obstacleGrid[obstcleGrid.length][obstacleGrid[0].length]

        //This is for sure dfs solution/Dynamic programming solution

        if(grid==null || grid.length==0){
            return 0;
        }


        int[][] dp = new int[grid.length][grid[0].length];

        //So we are trying to find out possible ways  and removing obstacles within that path

        for(int i=0;i<dp.length;i++){
            if(grid[i][0]!=1){
                dp[i][0] = 1;
            } else {
                dp[i][0] = 0;
                break;
            }

        }
        for(int i=0;i<dp[0].length;i++){
            if(grid[0][i]!=1){
                dp[0][i] = 1;
            } else {
                dp[0][i] = 0;
                break;
            }
        }


        for(int i=1;i<grid.length;i++){
            for(int j=1; j<grid[i].length;j++){
                if(grid[i][j]!=1){
                    dp[i][j] = dp[i][j-1]+dp[i-1][j];
                } else{
                    dp[i][j] =0;
                }
            }
        }


        return dp[dp.length-1][dp[0].length-1];
    }
}
