//You are given an array with size n, which contains elements from range 1 to n. 
//One element is repeated and one element is missing. Find these 2 elements.

import java.util.*;

class Solution {

    static void findMissingAndRepeating(int[] arr, int n) {
        //Find XOR of array elements and also numbers [1, n]
        int XOR = arr[0];
        for(int i=1; i<n; i++)
            XOR = XOR ^ arr[i];
        for(int i=1; i<=n; i++)
            XOR = XOR ^ i;
        
        //The final XOR would be -> Repeating element ^ Missing element = XOR

        //Find the right most set bit of the XOR
        int setBit = XOR & (~(XOR-1));

        //Create 2 sets, by iterating array elements and numbers [1, n]
        //x -> containse XOR of elements which does not have the setBit
        //y-> containse XOR of elements which have the setBit
        int x = 0, y = 0;
        for(int i=0; i<n; i++) {
            if((arr[i] & setBit) == 0)
                x = x ^ arr[i];
            else 
                y = y ^ arr[i];
        }
        for(int i=1; i<=n; i++) {
            if((i & setBit) == 0)
                x = x ^ i;
            else
                y = y ^ i;
        }

        //Search for x in array, 
        //if x is found, x is repeating and y is missing
        //if x is not found, x is missing and y is repeating
        boolean found = false;
        for(int i=0; i<n; i++)
            if(arr[i] == x) {
                found = true;
                break;
            }
        
        if(found)
            System.out.println("Repeating ELement: " + x + "\nMissing Element: " + y);
        else
            System.out.println("Repeating ELement: " + y + "\nMissing Element: " + x);
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        
        findMissingAndRepeating(arr, n);
        
        sc.close();
    }
}
