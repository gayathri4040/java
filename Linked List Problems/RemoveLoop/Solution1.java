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
    while(head.next!=null){
      head = head.next;
    }
    head.next = node;
    return temp;
  }

  Node detectLoop(Node head){
    LinkedList list = new LinkedList();
    Node slow = head, fast = head;
    while(fast!=null && fast.next!=null){
      slow = slow.next;
      fast = fast.next.next;
      if(slow == fast){
        return removeLoop(head, lengthOfLoop(slow.next, fast));
      }
    }
    return head;
  }

  /*
    Algorithm:
      1. Maintain two pointers.
        -> One at the starting point.
        -> The other right after k (length of the loop) nodes.
      2. Iterate both the pointers till they meet.
      3. Now, fix pointer1 and iterate pointer2 until the next address of pointer2 is pointer1.
      4. Replace the next address of pointer2 with pointer1.
  */
  Node removeLoop(Node head, int k){
    Node ptr1 = head, ptr2 = head;
    while(k-- > 0){
      ptr2 = ptr2.next;
    }
    while(ptr1!=ptr2){
      ptr1 = ptr1.next;
      ptr2 = ptr2.next;
    }
    while(ptr2.next != ptr1){
      ptr2 = ptr2.next;
    }
    ptr2.next = null;
    return head;
  }

  int lengthOfLoop(Node slow, Node fast){
    int len = 1;
    while(slow!=fast){
      len++;
      slow = slow.next;
    }
    return len;
  }

  void print(Node head){
    while(head!=null){
      System.out.print(head.data + " ");
      head = head.next;
    }
    System.out.println();
  }
}

class Solution1 {
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
      if(temp.next!=null)
        temp = temp.next;
    }
    temp.next = extra;

    list.print(list.detectLoop(head));
    sc.close();
  }
}
