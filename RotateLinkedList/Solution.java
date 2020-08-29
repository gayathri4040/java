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

  void insertNode(int data) {
    Node node = new Node(data);
    if(head == null){
      head = node;
      return;
    }
    Node temp = head;
    while(temp.next != null)
      temp = temp.next;
    temp.next = node;
  }


  //Approach 1, works only when k < length
  void rotateList(int k) {
    int len = length();
    if(k >= len)
      return;

    Node temp = head, prev = head;
    //Skip the nodes k times, note the prev node before moving onto next node.
    while(k-- > 0) {
      prev = temp;
      temp = temp.next;
    }
    prev.next = null;

    //go till the end of temp node to store the changed head node at the back of it.
    Node main = temp;
    while(temp.next != null)
      temp = temp.next;

    temp.next = head;
    head = main;
  }

  /* Approach 2, irrespective of k and length.
    1. Make the list a circular list.
    2. Skip k-1 nodes
    3. make the end of the k-1th node to null
  */
  void rotate(int k) {
    if(head == null)
      return;

    k = k % length();
    if(k == 0)
      return;

    Node temp = head, main = head;
    while(temp.next != null)
      temp = temp.next;

    //Making the list circular
    temp.next = main;

    //(k-- > 1) to skip k-1 nodes
    while(k-- > 1)
      main = main.next;
    head = main.next;
    main.next = null;
  }

  //Approach 3, irrespective of k and length.
  void rotateByK(int k) {
    if(head == null)
      return;

    k = k % length();
    Node temp = head, tail = null;

    //Storing the tail of the list.
    while(temp.next != null)
      temp = temp.next;
    tail = temp;

    //Moving head node to the back of tail k times.
    while(k-- > 0) {
      temp = head;
      tail.next = temp;
      tail = temp;
      head = head.next;
      tail.next = null;
    }
  }

  int length() {
    Node temp = head;
    int len = 0;
    while(temp != null) {
      len++;
      temp = temp.next;
    }
    return len;
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
    LinkedList list = new LinkedList();
    int n = sc.nextInt();
    while(n-- > 0)
      list.insertNode(sc.nextInt());

    int k = sc.nextInt();

    list.rotate(k);
    list.print();
    sc.close();
  }
}
