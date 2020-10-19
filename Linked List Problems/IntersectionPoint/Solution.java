import java.io.*;
import java.util.*;

class Node<T> {
  T data;
  Node<T> next;

  Node(T data) {
    this.data = data;
    this.next = null;
  }
}

class LinkedList<T> {
  Node<T> insertNode(Node<T> head, T data) {
    Node<T> node = new Node<T>(data);
    if(head == null)
      return node;
    Node<T> temp = head;
    while(head.next != null) {
      head = head.next;
    }
    head.next = node;
    return temp;
  }

  void findIntersection(Node<T> head1, Node<T> head2) {
    Node<T> prev = head2, temp1 = head1, temp2 = head2;
    LinkedList<T> list = new LinkedList<T>();
    int len1 = length(head1);
    int len2 = length(head2);
    int diff = Math.abs(len1-len2);
    while(diff-- > 0) {
      if(len1 > len2)
        head1 = head1.next;
      else {
        prev = head2;
        head2 = head2.next;
      }
    }
    while(head1 != null && head2 != null && head1 != head2) {
      head1 = head1.next;
      prev = head2;
      head2 = head2.next;
    }
    prev.next = null;
    //After removing the intersection point
    list.print(temp1);
    list.print(temp2);
    //Intersection point
    System.out.println(head1.data);
  }

  int length(Node<T> head) {
    int len = 0;
    while(head != null) {
      len++;
      head = head.next;
    }
    return len;
  }

  void print(Node<T> head) {
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
    LinkedList<Integer> list = new LinkedList<Integer>();

    //Read position to merge
    int index = sc.nextInt();

    //Read list1
    Node<Integer> head1= null;
    int n1 = sc.nextInt();
    for(int i=0; i<n1; i++)
      head1 = list.insertNode(head1, sc.nextInt());

    //Read list2
    Node<Integer> head2 = null;
    int n2 = sc.nextInt();
    for(int i=0; i<n2; i++)
      head2 = list.insertNode(head2, sc.nextInt());

    //iterate head1 till you meet the node at 'index'
    Node<Integer> temp1 = head1;
    for(int i=0; i<index; i++)
      temp1 = temp1.next;

    //iterate head2 till the end and attach temp1 to head2.
    Node<Integer> temp2 = head2;
    for(int i=0; i<n2; i++) {
      if(temp2.next != null)
        temp2 = temp2.next;
    }
    temp2.next = temp1;

    list.findIntersection(head1, head2);
    
    sc.close();
  }
}

/*
    Algorithm:
    1. Find the length of both the lists.
    2. Skip the nodes of the bigger list by the difference of their lengths.
    3. Now, iterate both the lists till the "address " of their nodes match.
    4. Once the iterations are done, return head1.data / head2.data

    Time Complexity: O(n+m) Space Complexity: O(1)
*/
