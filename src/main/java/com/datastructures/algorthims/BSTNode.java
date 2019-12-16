package com.datastructures.algorthims;

/* This is the type of node a tree has i.e. a left node, a right node, and a data field*/
class BSTNode {
    BSTNode left;
    int data;
    BSTNode right;

    public BSTNode(int data) {
        this.left = null;
        this.data = data;
        this.right = null;
    }
}