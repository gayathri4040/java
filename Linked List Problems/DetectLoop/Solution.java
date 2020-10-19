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
  Node insertNode(Node head, int data){
    if(head == null)
      return new Node(data);

    Node temp = head, node = new Node(data);
    while(head.next != null){
      head = head.next;
    }
    head.next = node;
    return temp;
  }

  void print(Node head){
    while(head != null){
      System.out.print(head.data + " ");
      head = head.next;
    }
    System.out.println();
  }

  //Approach 1, store the address in a set, and check if present or not.
  //if present, return true, else false.
  boolean detectLoop(Node head){
    Set<Node> set = new HashSet<Node>();
    while(head != null){
      if(set.contains(head))
        return true;
      set.add(head);
      head = head.next;
    }
    return false;
  }

  //Approach 2
  int hasCycle(Node head){
    int lengthOfLoop = 0;
    boolean found = false;
    Node slow = head, fast = head;
    while(fast!=null && fast.next!=null){
      if(found){
        slow = slow.next;
        lengthOfLoop++;
      } else {
        slow = slow.next;
        fast = fast.next.next;
      }
      if(slow == fast){
        if(found)
          break;
        found = true;
      }
    }
    return lengthOfLoop;
  }
  //used fast as the condition because, slow pointer moves slow,
  //the one that hits null first, would ideally be fast pointer
  //so, if fast==null, null.next.next is pointless, so we break the loop.
  //also, if fast.next==null, null.next is pointless, and so we break the loop
}

class Solution {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    //Position where one of the node is mapped to other node before it, to form a loop.
    //-1 if there is no loop.
    int index = sc.nextInt();
    LinkedList list = new LinkedList();
    Node head = null;
    for(int i=0; i<n; i++){
      head = list.insertNode(head, sc.nextInt());
    }
    //Creating the loop.
    Node temp = head, extra = null;
    for(int i=0; i<n; i++){
      //the index matches with the node index, store its address.
      if(i == index)
        extra = temp;
      if(temp.next!=null)
        temp = temp.next;
    }
    //add the stored address at the end of the last node.
    temp.next = extra;

    System.out.println(list.hasCycle(head));
    sc.close();
  }
}
