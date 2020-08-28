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

  Node head;

  LinkedList insertNode(LinkedList list, int data) {
    Node node = new Node(data);
    if(list.head == null){
      list.head = node;
      return list;
    }
    Node head = list.head;
    while(head.next != null)
      head = head.next;
    head.next = node;
    return list;
  }

  /* Approach 1
    1. find the length of Linked List.
    2. Print the (len – n)th node from the beginning of the Linked List. *1-based index from end
  */
  void findNthNode(Node head, int n) {
    int k = length(head)-n;
    while(k-- > 0)
      head = head.next;
    System.out.println(head.data);
  }

  /* Approach 2:
    1. Maintain two pointers. main pointer and a reference pointer.
    2. Move ref pointer 'n' times.
    3. Now, move both the pointers till ref pointer reaches the end.
    4. return main.data
  */
  void findNthNodeFromEnd(LinkedList list, int n) {
    //if n is greater than the length of list
    if(n > length(list.head))
      return;

    Node main = list.head, ref = list.head;
    while(n-- > 0 && ref != null)
      ref = ref.next;

    while(ref != null) {
      main = main.next;
      ref = ref.next;
    }
    System.out.println(main.data);
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
    while(head != null){
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
    int len = sc.nextInt();
    LinkedList list = new LinkedList();
    while(len-- > 0) {
      list = list.insertNode(list, sc.nextInt());
    }
    list.findNthNodeFromEnd(list, n);
    sc.close();
  }
}
