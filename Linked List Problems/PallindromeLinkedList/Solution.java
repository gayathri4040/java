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
    Node head;
    int len;

    void insert(int data) {
        len += 1;
        if(head == null) {
            head = new Node(data);
            return;
        }

        Node temp = head;
        while(temp.next != null)
            temp = temp.next;
        temp.next = new Node(data);
    }

    Node findMid() {
        Node slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    void reverse(Node mid) {
        if(len == 1)
            return;
        Node reverseHead = null, temp = null, last = head;
        while(head != mid) {
            temp = head.next;
            head.next = reverseHead;
            reverseHead = head;
            head = temp;
        }
        
        last.next = head;
        head = reverseHead;
    }

    boolean compare(Node head1, Node head2) {
        while(head1 != null && head2 != null) {
            if(head1.data != head2.data)
                return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
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
        int n = sc.nextInt();
        
        LinkedList list = new LinkedList();
        while(n-- > 0)
            list.insert(sc.nextInt());
        
        //Find the middle element of the linked list
        Node mid = list.findMid();

        //Reverse the first half of the list, i.e, [head, mid)
        list.reverse(mid);
        
        //If the length of the list is even, [1,2,3,4,5,6,7,8] 
            // including mid{5} - we have to compare [head, mid) - i.e [1,2,3,4] and [mid, last] - i.e [5,6,7,8]
        //If the length of thelist is odd, [1,2,3,4,5,6,7]
            // excliding mid{4} - we have to compare [head,mid) - i.e [1,2,3] and (mid,last] - i.e [5,6,7]
        if((list.len & 1) == 0)
            System.out.println(list.compare(list.head, mid));
        else    
            System.out.println(list.compare(list.head, mid.next));
        
        
        //Contructing the original list again, by reversing the first half
        list.reverse(mid);

        sc.close();
    }
}
