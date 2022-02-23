package Important;

import com.dinesh.algo.TreeNode;

public class ValidateBinaryTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(1);
        node.right = new TreeNode(5);
        node.right.left= new TreeNode(2);
        node.right.right = new TreeNode(6);
        /*node.right.right.left = new TreeNode(4);
        node.right.right.right= new TreeNode(9);
        node.right.right.left.left = new TreeNode(6);
        node.right.right.left.right = new TreeNode(5);
        node.right.left= new TreeNode(8);
        node.right.right = new TreeNode(6);*/
        System.out.println(isValidBinaryTree(node,null,null));
    }

    private static boolean isValidBinaryTree(TreeNode root, Integer max, Integer min) {
        if(root==null){
            return true;
        } //breaking condition
        else if((max != null && max< root.value) || (min!=null && root.value<min)){
            return false;
        } else {
            //Traverse binary tree from both left and right as is
            return isValidBinaryTree(root.left,root.value,min) &&
                    isValidBinaryTree(root.right,max,root.value);
        }
    }

}

