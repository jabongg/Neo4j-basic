package geeksforgeeks;

/* package whatever; // don't place package name! */

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Remove_Duplicate_From_LL {
    Node head;

    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;

            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            Remove_Duplicate_From_LL llist = new Remove_Duplicate_From_LL();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            GfG g = new GfG();
            llist.head = g.removeDuplicates(llist.head);
            llist.printList();

            t--;
        }
    }
}

/*This is a function problem.You only need to complete the function given below*/
/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/
class GfG {
    // head: head node
    Node removeDuplicates(Node root) {
        // Your code here

        Node p, q;
        p = q = root;
        while (q != null && q.next != null) {

            if (q.data != q.next.data) {
                q = q.next;
                p = q;
            } else {
                while (q.data == q.next.data) {
                    q = q.next;
                    if (q.next == null) {
                        break;
                    }

                }

                p.next = q.next;
                q.next = null;

                q = p.next;
                p = q;
            }
        }
        return root;
    }
}
