package geeksforgeeks.trees;

import sun.plugin2.liveconnect.BrowserSideObject;

import java.util.LinkedList;
import java.util.Queue;

public class Trees {

    static int max_level = 0;

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
        // root = insert(root, 13);  // trying for duplicity in the tree
        // root = insert(root, 28);

        System.out.println("Inorder Traversal:");
       // inorder(root); // prints tree elements
        //minimumElementInBSTIterative(root);
        // minimumElementInBSTRecursive(root);
        // maximumElementInBSTRecursive(root);
        // leftViewOfBST(root);
        //leftView(root);
        bfsTraversal(root);
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
            if (data <= root.data) {
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
     *
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
     *
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
     *
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


    /**
     * left view of a tree
     */
    public static void leftViewOfBST(BSTNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null) {
            System.out.print(root.data + " ");
        }

        leftViewOfBST(root.left);
        //leftViewOfBST(root.right);
    }


    // recursive function to print left view
    public static void leftViewUtil(BSTNode node, int level) {
        // Base Case
        if (node == null)
            return;

        // If this is the first node of its level
        if (max_level < level) {
            System.out.print(" " + node.data);
            max_level = level;
        }

        // Recur for left and right subtrees
        leftViewUtil(node.left, level + 1);
        leftViewUtil(node.right, level + 1);
    }

    // A wrapper over leftViewUtil()
    public static void leftView(BSTNode root) {
        leftViewUtil(root, 1);
    }

    public static void bfsTraversal(BSTNode root) {
        Queue<BSTNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BSTNode tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
}
