package com.dinesh.algo.homework;

import com.dinesh.algo.TreeNode;

public class IsSameTree {
    public static void main(String[] args) {
        TreeNode nodeP = new TreeNode(2);
        nodeP.left = new TreeNode(1);
        nodeP.right = new TreeNode(3);
        TreeNode nodeq = new TreeNode(2);
        nodeq.left = new TreeNode(1);
        nodeq.right = new TreeNode(3);
        IsSameTree sameTree = new IsSameTree();
        sameTree.isSameTree(nodeP,nodeq);

    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null ){
            return true;
        }else if( p!=null && q!= null && p.value==q.value){
            return true;
        } else if((p!=null && q==null)|| (q!=null && p==null) ){
            return false;
        }else if(p.value!=q.value){
            return false;
        }else {
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }

    }
}
