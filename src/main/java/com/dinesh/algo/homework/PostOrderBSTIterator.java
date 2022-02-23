package com.dinesh.algo.homework;

import com.dinesh.algo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderBSTIterator {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
       root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        /*
                        1
                   2        3
                4     5
         */
        List<Integer> test = new ArrayList<>();
        postOrder(root,test);
        System.out.println("Test contains "+test);
    }
    public static void postOrder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        postOrder(root.left,list);
        postOrder(root.right,list);
        list.add(root.value);

    }

}
