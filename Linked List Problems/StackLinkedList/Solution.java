// Implement a Stack using Linked List. 
// A Query Q is of 2 Types
// (i) 1 x   (a query of this type means  pushing 'x' into the stack)
// (ii) 2     (a query of this type means to pop an element from the queue and print the poped element)
// (iii) 3    (a query of this type means to display the top element of the stack)
// (iv) 4     (a query of this type means to display all the elements of the stack)

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class StackLinkedList {
    Node top;

    void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;

    }

    int pop() {
        if(top == null)
            return -1;
        
        Node popped = top;
        top = popped.next;
        popped.next = null;

        return popped.data;
    }

    int peek() {
        if(top == null) {
            System.out.println("Stack is empty!");
            return -1;
        }

        return top.data;
    }

    void display() {
        if(top == null)
            System.out.println("Stack is empty!");

        Node temp = top;
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
        int queries = sc.nextInt();

        StackLinkedList stack = new StackLinkedList();
        while(queries-- > 0) {
            int query = sc.nextInt();
            switch(query) {
                case 1:
                    stack.push(sc.nextInt());
                    break;
                case 2:
                    System.out.println("Deleted element - " + stack.pop());
                    break;
                case 3:
                    System.out.println("Top element of the stack - " + stack.peek());
                    break;
                case 4: 
                    System.out.print("Elements in the stack are - ");
                    stack.display();
            }
        }
        
        sc.close();
    }
}
