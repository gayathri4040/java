import java.io.*;
import java.util.*;

class LinkedList {
  Node head;
  class Node {
    int data;
    Node down;
    Node next;

    Node(int data) {
      this.data = data;
      this.down = null;
      this.next = null;
    }
  }

  LinkedList insertNode(LinkedList list, int data, int index, boolean down) {
    Node node = new Node(data);
    if(!down) {
      if(list.head == null) {
        list.head = node;
        return list;
      }
      Node head = list.head;
      while(head.next != null) {
        head = head.next;
      }
      head.next = node;
      return list;
    } else {
      Node head = list.head;
      //Move head to the index position
      while(index-- > 0 && head != null) {
        head = head.next;
      }
      if(head == null) {
        list.head = node;
        return list;
      }
      while(head.down != null) {
        head = head.down;
      }
      head.down = node;
      return list;
    }
  }

  /*
    Till there are only two lists in the Biglist.
      1. Passing the heads of first two vertical lists to merge. --> merge(head, head.next);
      2. Store the head of the 3rd vertical list. --> head = head.next.next;
      3. Then we remove the first two vertical lists. --> list.head = result.head;
      4. Add the result.head we get in front of remaining vertical lists --> list.head.next = head;
      5. Store head of list in head pointer for iteration --> head = list.head;
    --> Since the resultant list is vertical list, we convert it into a horizontal one to flatten it. (Not sure if it is a requirement or not)
  */
  LinkedList flattenList(LinkedList list) {
    //For a single list
    if(list.head.next == null)
      return list;

    LinkedList result = new LinkedList();
    Node head = list.head;
    while(head != null && head.next != null) {
      result = merge(head, head.next);
      if(head.next.next == null)
        break;
      head = head.next.next;
      list.head = result.head;
      list.head.next = head;
      head = list.head;
    }
    //convert the vertical list to horizontal list
    Node temp = result.head;
    while(temp != null) {
      temp.next = temp.down;
      temp.down = null;
      temp = temp.next;
    }
    return result;
  }

  LinkedList merge(Node head1, Node head2) {
    LinkedList list = new LinkedList();
    if(head1 == null) {
      list.head = head2;
      return list;
    }
    if(head2 == null) {
      list.head = head1;
      return list;
    }

    while(head1 != null && head2 != null) {
      if(head1.data < head2.data) {
        list = insertNode(list, head1.data, 0, true);
        head1 = head1.down;
      } else {
        list = insertNode(list, head2.data, 0, true);
        head2 = head2.down;
      }
    }
    Node temp = list.head;
    while(temp.down != null)
      temp = temp.down;

    if(head1 != null)
      temp.down = head1;
    if(head2 != null)
      temp.down = head2;

    return list;
  }

  void print(Node head) {
    while(head != null) {
      Node temp = head;
      while(temp != null) {
        System.out.print(temp.data + " ");
        temp = temp.down;
      }
      head = head.next;
    }
    System.out.println();
  }

}

class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    LinkedList list = new LinkedList();
    for(int i=0; i<n; i++){
      arr[i] = sc.nextInt();
    }
    for(int i=0; i<n; i++) {
      for(int j=0; j<arr[i]; j++){
        if(j==0)
          list = list.insertNode(list, sc.nextInt(), i, false);
        else
          list = list.insertNode(list, sc.nextInt(), i, true);
      }
    }
    list.print(list.flattenList(list).head);
    sc.close();
  }
}
