package com.dinesh.algo;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreasureIslandDFS {
    public static void main(String[] args) {
        char[][] island = new char[][]{
                {'O', 'O', 'O', 'O'},
                {'D', 'O', 'D', 'O'},
                {'O', 'O', 'O', 'O'},
                {'X', 'D', 'D', 'O'}
        };

        //Our main aim here is just traverse through the grid and figure out which are all safe to move, by adding safest one
        // to Queue so that you can traverse through that point, and when you see X.. return the steps
        // Use ArrayDeque as it keeps the order

        /*
        There are 4 possible directions you can go from a point.
        Let's decide those directions as [-1,0],[0,-1],[1,0],[0,1] by adding row and column values with these dirs
        eg: from (1,2) -> you can move to [0,2],[1,1],[2,2],[1,3]
         so you just have to make sure row and column values are with in that grid
        Let's say you started at point(0,0), you can move to [0,1] and [1,0] as remaining two points are out of grid
        Add [0,0] to queue initially and poll from queue and mark it as visited, so that you can count how many are visited
         */
        System.out.println(findShortestRoute(island));
    }

    private static int findShortestRoute(char[][] island) {
       if(island==null  || island.length ==0){
           return 0;
       }
       int minSteps = 0;

       for(int i=0; i<island.length; i++ ){
           for(int j=0; j<island[i].length; j++){
               if(island[i][j] == 0 ){
                   minSteps = findMinSteps(island,i,j,0);
               }
           }
       }

       return minSteps;
    }

    private static int findMinSteps(char[][] island, int i, int j, int minSteps) {
        if(i<0 || i>island.length || j<0 || j>island.length || island[i][j] =='D'){
            return 0;
        } else {
            minSteps++;
        }
        if(island[i][j] == 'X'){
             return minSteps;
        }
        island[i][j] = 'D';
        findMinSteps(island,i+1,j,minSteps);
        findMinSteps(island,i-1,j,minSteps);
        findMinSteps(island,i,j-1,minSteps);
        findMinSteps(island,i,j+1,minSteps);

        return minSteps;
    }

    private static boolean isSafe(char[][] island, int row, int col) {
        return  (row>=0 && row<island.length && col>=0 && col<island[0].length && island[row][col]!='D');
    }

    private static class Point{
        int r,c;
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
