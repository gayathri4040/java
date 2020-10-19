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
    Node node = new Node(data), temp = head;
    while(head.next != null){
      head = head.next;
    }
    head.next = node;
    return temp;
  }

  Node detectLoop(Node head){
    Node slow = head, fast = head;
    while(fast!=null && fast.next!=null){
      slow = slow.next;
      fast = fast.next.next;
      if(slow == fast){
        fast = fast.next;
        slow.next = null;
        return removeLoop(head, fast);
      }
    }
    return head;
  }

  Node removeLoop(Node head1, Node head2){
    Node temp1 = head1, temp2 = head2, main = head1, prev = null;
    int len1 = length(head1);
    int len2 = length(head2);
    int diff = Math.abs(len1 - len2);
    //skip the nodes of the bigger list.
    while(diff-- > 0){
      if(len1 > len2)
        head1 = head1.next;
      else {
        prev = head2;
        head2 = head2.next;
      }
    }
    //iterate both head1 and head2 till they meet.
    while(head2 != null && head1 != null && head2 != head1){
      head1 = head1.next;
      prev = head2;
      head2 = head2.next;
    }
    //edge case when there is only one element in the list and is a loop.
    if(prev==null)
      return main;
    //removing the nodes after the point of intersection in head2.
    prev.next = null;
    //iterate head1 till it reaches the end
    while(temp1.next != null){
      temp1 = temp1.next;
    }
    //at the end of head1, insert head2
    temp1.next = temp2;
    //return head1
    return main;
  }

  int lengthOfLoop(Node slow, Node fast){
    int len = 1;
    while(slow!=fast){
      len++;
      slow = slow.next;
    }
    return len;
  }

  int length(Node head){
    int len = 0;
    while(head != null){
      len++;
      head = head.next;
    }
    return len;
  }

  void print(Node head){
    while(head != null){
      System.out.print(head.data + " ");
      head = head.next;
    }
    System.out.println();
  }
}

class Solution2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int index = sc.nextInt();
    LinkedList list = new LinkedList();
    Node head = null;
    for(int i=0; i<n; i++)
      head = list.insertNode(head, sc.nextInt());
    //Creating the loop.
    Node temp = head, extra = null;
    for(int i=0; i<n; i++){
      if(i == index)
        extra = temp;
      if(temp.next != null)
        temp = temp.next;
    }
    temp.next = extra;

    list.print(list.detectLoop(head));
    sc.close();
  }
}
