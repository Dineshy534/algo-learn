package com.dinesh.algo.homework;

import com.dinesh.algo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightsideView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left= new TreeNode(2);
        root.right= new TreeNode(3);
        root.left.left = null;
        root.left.right = new TreeNode(5);
        root.right.left = null;
        root.right.right = new TreeNode(4);
        List<Integer> rhsList = rightSideView(root);
        rhsList.stream().forEach(System.out::println);
    }

    private static List<Integer> rightSideView(TreeNode root) {
        //So when we are traversing from top to bottom and if you want one side go with BFS
        List<Integer> rightSideNodes = new ArrayList<>();
        if(root==null){
           return rightSideNodes;
        }
        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.add(root);

        while(!treeQueue.isEmpty()){
            int size = treeQueue.size();
            for(int i=0; i<size;i++){
                TreeNode current = treeQueue.remove();
                if(i==size-1){
                    rightSideNodes.add(current.value);
                }

                if(current.left!=null){
                    treeQueue.add(current.left);
                }
                if(current.right!=null){
                    treeQueue.add(current.right);
                }

            }
        }
        return rightSideNodes;
    }
}
