import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    int len = 0;

    void insert(int data) {
        len += 1; 
        if(head == null) {
            head = new Node(data);
            return;
        }

        Node temp = head;
        while(temp.next != null)
            temp = temp.next;
        temp.next = new Node(data);
    }

    void reverse() {
        Node reverseHead = null, temp = null;
        while(head != null) {
            temp = head.next;
            head.next = reverseHead;
            reverseHead = head;
            head = temp;
        }
        head = reverseHead;
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

    static LinkedList addLists(LinkedList list1, LinkedList list2) {
        int carry = 0;
        //reverse both the lists, to perform the addition from the rightmost number
        list1.reverse();
        list2.reverse();

        LinkedList sumList = new LinkedList();
        Node head1 = list1.head, head2 = list2.head;
        while(head1 != null && head2 != null) {
            carry = computeAndInsert(sumList, head1.data + head2.data + carry, carry);
            
            head1 = head1.next;
            head2 = head2.next;
        }
        while(head1 != null) {
            carry = computeAndInsert(sumList, head1.data + carry, carry);

            head1 = head1.next;
        }
        while(head2 != null) {
            carry = computeAndInsert(sumList, head2.data + carry, carry);

            head2 = head2.next;
        }
        if(carry != 0)
            sumList.insert(carry);
        
        //reverse the sumList, so that to get the desired the sum
        sumList.reverse();

        //reverse both list1 and list 2 to obtain the original lists
        list1.reverse();
        list2.reverse();

        return sumList;
    }

    static int computeAndInsert(LinkedList sumList, int sum, int carry) {
        carry = sum / 10;
        sum = sum % 10;

        sumList.insert(sum);
        return carry;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //read length of list 1
        int n = sc.nextInt();
        //read numbers in list 1
        LinkedList list1 = new LinkedList();
        while(n-- > 0)
            list1.insert(sc.nextInt());
        
        //read length of list 2
        n = sc.nextInt();
        //read numbers in list 2
        LinkedList list2 = new LinkedList();
        while(n-- > 0)
            list2.insert(sc.nextInt());
        
        LinkedList sumList = addLists(list1, list2);
        sumList.print();

        sc.close();
    }

}
