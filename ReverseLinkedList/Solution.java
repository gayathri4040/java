import java.io.*;
import java.util.*;

class Node {
  int data;
  Node next;

  Node(int data){
    this.data = data;
    this.next = null;
  }
}

class LinkedList {
  Node insertNode(Node head, int data){
    if(head==null)
      return new Node(data);
    Node temp = head;
    while(head.next!=null){
      head = head.next;
    }
    Node node = new Node(data);
    head.next = node;
    return temp;
  }

  Node reverse(Node head){
    Node reverse = null, temp = head;
    while(head!=null){
      temp = head.next;
      head.next = reverse;
      reverse = head;
      head = temp;
    }
    return reverse;
  }

  void print(Node head){
    while(head!=null){
      System.out.print(head.data + " ");
      head = head.next;
    }
    System.out.println();
  }
}

class Solution{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    LinkedList list = new LinkedList();
    Node head = null;
    while(n-- > 0)
      head = list.insertNode(head, sc.nextInt());
    list.print(list.reverse(head));
    sc.close();
  }
}
