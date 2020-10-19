import java.io.*;
import java.util.*;

class LinkedList {
    Node head;
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    void insert(int data) {
        if(head == null) {
            head = new Node(data);
            return;
        }

        Node temp = head;
        while(temp.next != null) 
            temp = temp.next;
        
        temp.next = new Node(data);
    }

    //Swaps the links
    void pairSwap() {
        if(head == null || head.next == null) 
            return;

        Node finalHead = head.next, prev = null, prevprev = null;
        while(head != null && head.next != null) {
            prevprev = prev;
            prev = head;
            head = head.next;

            prev.next = head.next;
            head.next = prev;
            if(prevprev != null)
                prevprev.next = head;
            head = prev;

            head = head.next;
        }
        head = finalHead;
    }

    //Swaps the data
    void pairwiseSwap() {
        if(head == null || head.next == null)
            return;

        Node temp = head;
        while(temp != null && temp.next != null) {
            int swap = temp.data;
            temp.data = temp.next.data;
            temp.next.data = swap;
            temp = temp.next.next;
        }
    }

    void print() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        
        LinkedList list = new LinkedList();
        while(n-- > 0) 
            list.insert(sc.nextInt());
        
        list.pairSwap();
        list.print();
        
        sc.close();
    }
}
