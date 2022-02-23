package com.dinesh.algo;

import java.util.*;

public class WordLadder {


    public static void main(String[] args) {
        //String[] str = {"hot","dot","dog","lot","log","cog"};
        List<String> str = new ArrayList<>();
        str.add("hot");
        str.add("dot");
        //str.add("c");
        str.add("dog");
        /*str.add("lot");
        str.add("log");
        str.add("cog");*/
        int len = ladderLength("hot","dot",str
                );

        System.out.println("length "+len);
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(wordList==null || wordList.size()==0 || !wordList.contains(endWord)){
            return 0;
        }
        Queue<String> wordQ = new LinkedList<>();

        int depth = 0;

        wordQ.add(beginWord);

        while(!wordQ.isEmpty()){
            depth++;
            for(int k=0; k<wordQ.size(); k++){
                String queueString = wordQ.remove();
                char[] chars = queueString.toCharArray();
                if(endWord.equals(queueString)) {
                    return depth;
                }

                for(int i=0; i<chars.length; i++){
                    char d = chars[i];
                    for (char c = 'a'; c <= 'z'; c++){
                        if(chars[i]==c)
                            continue;
                        else {
                            chars[i] = c;

                            String nb = String.valueOf(chars);

                            if (wordList.contains(nb)) {
                                wordQ.add(nb);
                                wordList.remove(nb);
                            }
                        }

                    }
                    chars[i] = d;
                }
            }
        }


        return 0;
    }
}
