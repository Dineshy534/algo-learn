package com.dinesh.algo.homework;

import java.util.HashMap;
import java.util.Map;

public class ZigZagConversion {

    public String convert(String s, int numRows) {

        // So Concept is very simple
        //numRows -1 is the middle
        if(s!=null && (s.length()==1 && s.length()==2 || numRows==1)){
            return s;
        }
        if(numRows>=2){

            //Now let's implement Map logic where in Map you will fill indices as number of rows
            //Create a Map and then get keySet
            Map<Integer,StringBuilder> rowMap = new HashMap<>();

            int row=0;
            int step=1;

            for(int i=0; i<s.length(); i++){
                if(rowMap.get(row)==null){
                    rowMap.put(row,new StringBuilder(""));
                }
                if(rowMap.get(row)!=null){
                    rowMap.put(row,rowMap.get(row).append(s.charAt(i)));
                }

                if(row==0){
                    step =1;
                }
                if(row == numRows-1){
                    step = -1;
                }
                row +=step;
            }
            StringBuilder sb = new StringBuilder();
            for(int key: rowMap.keySet())
            {
                sb.append(rowMap.get(key));
            }
            return sb.toString();

        }


        return "";

    }
}
