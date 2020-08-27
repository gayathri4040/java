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
  Node insertNode(Node head, int data) {
    Node node = new Node(data);
    if(head == null)
      return node;

    Node temp = head;
    while(head.next != null)
      head = head.next;
    head.next = node;
    return temp;
  }

  Node mergeSortedLists(Node head1, Node head2) {
    if(head1 == null)
      return head2;

    if(head2 == null)
      return head1;

    Node temp = null;
    while(head1 != null && head2 != null) {
      if(head1.data < head2.data) {
        temp = insertNode(temp, head1.data);
        head1 = head1.next;

      } else {
        temp = insertNode(temp, head2.data);
        head2 = head2.next;
      }
    }
    Node main = temp;
    while(temp.next != null)
      temp = temp.next;

    if(head1 != null)
      temp.next = head1;
    if(head2 != null)
      temp.next = head2;
    return main;
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
    LinkedList list = new LinkedList();
    //both the lists must be sorted
    //Read list1
    int n1 = sc.nextInt();
    Node head1 = null;
    while(n1-- > 0)
      head1 = list.insertNode(head1, sc.nextInt());

    //Read list2
    int n2 = sc.nextInt();
    Node head2 = null;
    while(n2-- > 0)
      head2 = list.insertNode(head2, sc.nextInt());

    list.print(list.mergeSortedLists(head1, head2));

    sc.close();
  }
}
