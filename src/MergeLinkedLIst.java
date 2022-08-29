import org.w3c.dom.Node;

import java.util.LinkedList;

public class MergeLinkedLIst {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void printList(Node head) {
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    public Node MergeSortedLL(Node a, Node b) {
        Node resultHead = new Node(0);
        Node resultTail;

        resultTail = resultHead;

        while (a != null && b != null) {
            if (a.data <= b.data) {
                resultTail.next = a;
                a = a.next;
            } else {
                resultTail.next = b;
                b = b.next;
            }
            resultTail = resultTail.next;
        }
        if (b == null) {
            resultTail.next = a;
        }else{
            resultTail.next = b;
        }
        return resultHead.next;
    }

    public Node MergeSortedLLRecursion(Node a, Node b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (a.data <= b.data) {
            a.next = MergeSortedLLRecursion(a.next, b);
            return a;
        } else {
            b.next = MergeSortedLLRecursion(a, b.next);
            return b;
        }
    }


    public static void main(String[] args) {
        Node one1 = new Node(2);
        one1.next = new Node(3);
        one1.next.next = new Node(6);
        one1.next.next.next = new Node(10);
        Node one2 = new Node(5);
        one2.next = new Node(8);
        one2.next.next = new Node(9);
        one2.next.next.next = new Node(11);

        MergeLinkedLIst aa = new MergeLinkedLIst();
        aa.printList(one1);
        aa.printList(one2);
        System.out.println("-----------");
        aa.printList(aa.MergeSortedLL(one1,one2));
        //aa.printList(aa.MergeSortedLLRecursion(one1, one2));

    }
}
