package com.dinesh.algo;

import java.util.ArrayList;
import java.util.List;

public class CloneGraph {
    public static void main(String[] args) {
        Node rootNode = new Node();
        Node node1 = new Node();
        node1.val = 1;
        Node node2 = new Node();
        node2.val = 2;
        Node node3 = new Node();
        node3.val = 3;
        Node node4 = new Node();
        node4.val = 4;
        node1.neighbors = new ArrayList<Node>();
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors = new ArrayList<Node>();
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors = new ArrayList<Node>();
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors = new ArrayList<Node>();
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        rootNode.neighbors = new ArrayList<Node>();
        rootNode.neighbors.add(node1);
        rootNode.neighbors.add(node2);
        rootNode.neighbors.add(node3);
        rootNode.neighbors.add(node4);
        System.out.println(rootNode);
    }
}

class Node{
    int val;
    List<Node> neighbors;
}
