// Implement a Queue using Linked List. 
// A Query Q is of 2 Types
// (i) 1 x   (a query of this type means  pushing 'x' into the queue)
// (ii) 2     (a query of this type means to pop an element from the queue and print the poped element)

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

}

class QueueLinkedList {
    Node front, rear;

    void enQueue(int data) {
        Node newNode = new Node(data);

        if(front == null) {
            front = rear =  newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    int deQueue() {
        if(front == null)
            return -1; 

        Node popped = front;
        front = popped.next;
        popped.next = null;
        
        return popped.data;
    }

}

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int queries = sc.nextInt();

        QueueLinkedList queue = new QueueLinkedList();
        while(queries-- > 0) {
            int query = sc.nextInt();
            switch(query) {
                case 1:
                    queue.enQueue(sc.nextInt());

                    break;
                case 2:
                    System.out.println(queue.deQueue());
            }
        }
        
        sc.close();
    }
}
