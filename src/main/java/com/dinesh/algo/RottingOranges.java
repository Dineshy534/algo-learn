package com.dinesh.algo;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static void main(String[] args) {
        RottingOranges oranges = new RottingOranges();
                      /*
                       {{2,1,1},
                        {1,1,1},
                        {0,1,2}}
                       */
      /*  int[][] grid = {{2,1,1},
                        {1,1,0},
                        {0,1,1}};*/
        int[][] grid = {{0}};
        System.out.println("Num of mins: " + oranges.orangesRotting(grid));
    }


    public int orangesRotting(int[][] grid) {
        int mins = -1;
        //so our main aim is add all the 2's to our queue and check the fresh fruits
        int freshFruits = 0;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                } else if(grid[i][j]==1){
                    freshFruits++;
                }
            }
        }

        if(freshFruits==0){
            return 0;
        }
        while(!q.isEmpty()){
            mins++;
            int size = q.size();
            while(size-->0){
                int[] rotten = q.remove();
                for(int[] dir: dirs){
                    //row
                    int x= rotten[0]+dir[0];
                    //col
                    int y = rotten[1]+dir[1];
                    if(x<0|| y<0|| x>=grid.length || y>=grid[0].length || grid[x][y]==0 || grid[x][y] ==2){
                        continue;
                    }
                    grid[x][y]=2;
                    //Now add this pair to q
                    q.add(new int[]{x,y});
                    freshFruits--;
                }
            }
        }
        mins = freshFruits==0?mins:-1;

        return mins;
    }
}
