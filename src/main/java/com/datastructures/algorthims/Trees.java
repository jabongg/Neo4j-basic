package com.datastructures.algorthims;

public class Trees {
    public static void main(String[] args) {
        BSTNode root = null;
        root = insert(root, 28);
        root = insert(root, 45);
        root = insert(root, 20);
        root = insert(root, 25);
        root = insert(root, 30);
        root = insert(root, 13);
        root = insert(root, 93);
        root = insert(root, 50);
        root = insert(root, 27);
        root = insert(root, 13);  // trying for duplicity in the tree
        root = insert(root, 28);

        System.out.println("Inorder Traversal:");
        inorder(root); // prints tree elements
        //minimumElementInBSTIterative(root);
        minimumElementInBSTRecursive(root);
        maximumElementInBSTRecursive(root);
    }

    /**
     * printing tree nodes using inorder traversal.
     *
     * @param root
     */
    public static void inorder(BSTNode root) {
        if (root == null) {
            return;
        } else {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    /**
     * method to insert a node in the tree.
     *
     * @param root
     * @return
     */
    public static BSTNode insert(BSTNode root, int data) {
        if (root == null) {
            root = new BSTNode(data);
            return root;
        } else {
            if ( data <= root.data) {
                root.left = insert(root.left, data);
            }
            if (data > root.data) {
                root.right = insert(root.right, data);
            }
            return root;
        }
    }

    /**
     * minimum element iterative way
     * @param root
     */
    public static void minimumElementInBSTIterative(BSTNode root) {
       BSTNode current = root;

       while (current.left != null) {
           current = current.left;
       }
        System.out.println("\nminimum element : " + current.data);
    }


    /**
     * minimum element recursive way
     * @param root
     */
    public static void minimumElementInBSTRecursive(BSTNode root) {

        if (root == null) {
            return;
        }
        if (root.left == null) {
            System.out.println("\nminimum element : " + root.data);
        }
        minimumElementInBSTRecursive(root.left);
    }


    /**
     * minimum element recursive way
     * @param root
     */
    public static void maximumElementInBSTRecursive(BSTNode root) {

        if (root == null) {
            return;
        }
        if (root.right == null) {
            System.out.println("\nmaximum element : " + root.data);
        }
        maximumElementInBSTRecursive(root.right);
    }
}
