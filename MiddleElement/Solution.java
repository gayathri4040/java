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

  LinkedList insertNode(LinkedList list, int data) {
    Node node = new Node(data);
    if(head == null){
      list.head = node;
      return list;
    }
    Node head = list.head;
    while(head.next != null)
      head = head.next;
    head.next = node;
    return list;
  }

  //Approach 1
  //Find the length of the list
  //Iterate length/2 times
  void middleElement(LinkedList list) {
    int len = length(list.head);
    int mid = len/2;
    if((len&1) == 0) {
      //first mid
      System.out.println("First Mid: " + findMid(list.head, mid-1));
      //second mid
      System.out.println("Second Mid: " + findMid(list.head, mid));
    } else {
      System.out.println("Mid: " + findMid(list.head, mid));
    }
  }

  //Approach 2
  //Using slow and fast pointers
  void middleElementOfList(LinkedList list) {
    Node slow = list.head, fast = list.head;
    while(fast != null && fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    if(fast.next != null) {
      //prints the 1st mid if the length of the list is even.
      System.out.print(slow.data + " ");
      slow = slow.next;
    }
    //prints the second mid and also covers the case when the list is odd.
    System.out.print(slow.data + "\n");
  }

  int findMid(Node head, int mid) {
    while(mid-- > 0 && head != null)
      head = head.next;
    return head.data;
  }

  int length(Node head) {
    int len = 0;
    while(head != null) {
      len++;
      head = head.next;
    }
    return len;
  }

  void print(Node head) {
    while(head != null) {
      System.out.print(head.data + " ");
      head = head.next;
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
      list = list.insertNode(list, sc.nextInt());
    list.middleElementOfList(list);
    sc.close();
  }
}
