package com.dinesh.algo.homework;

import com.dinesh.algo.TreeNode;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    //Inorder traversal is left-->root--> right
    BSTIterator(TreeNode root){
        pushAll(root);
    }

    private void pushAll(TreeNode root) {
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
    }

    public int next(){
        TreeNode temp = stack.pop();
        pushAll(temp.right);
        return temp.value;
    }

    public boolean hasNext(){
        return !stack.isEmpty();
    }
}
