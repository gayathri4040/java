import java.io.*;
import java.util.*;

class LinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    int len = 0;

    void insert(int data) {
        len += 1;
        if(head == null) {
            head = new Node(data);
            return;
        }
        
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
    }

    void reverse() {
        Node temp = null, reversedHead = null; 
        while(head != null) {
            temp = head.next;
            head.next = reversedHead;
            reversedHead = head;
            head = temp;
        }
        head = reversedHead;
    }

    //Algorithm:
    /* For example: list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> null, and k = 3
        --create a new list, where the final list would be: 7 -> 8 -> 4 -> 5 -> 6 -> 1 -> 2 -> 3 -> null
        Iterate head till head is null.
            store the 1st head in the start(would be 1 in the first iteration)
            For k-1 times and till head.next is null
                move the head: head = head.next
            store the kth head in the end (would be 3 in the first iteration)
            move head to point the head of next group, head = head.next;

            make end.next to the head of new list
            make new list head as start
        --Now reversing this new list would be our desired output: 3 -> 2 -> 1 -> 6 -> 5 -> 4 -> 8 -> 7 -> null
    */
    void reverseByK(int k) {
        Node reversedHead = null, start = null, end = null;
        int it = 1;
        while(head != null) {
            start = head;
            while(it++ < k && head.next!=null)    
                head = head.next;
            
            end = head;

            //moving head to the next head of next group
            head = head.next;

            //updating reversedHead
            end.next = reversedHead;
            reversedHead = start;
            
            it = 1;
        }
        head = reversedHead;
        reverse();
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
        int n = sc.nextInt();

        LinkedList list = new LinkedList();
        while(n-- > 0) 
            list.insert(sc.nextInt());
        
        //read group size to reverse in the linked list
        int k = sc.nextInt();

        list.reverseByK(k);
        list.print();
        
        sc.close();
    }
}
