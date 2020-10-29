// Given a number, swap the adjacent bits in the binary representation of the number, 
// and print the new number formed after swapping.

// Constraints
// 1 <= T <= 100000
// 0 <= N <= 10^9

import java.util.*;

public class Solution {
    
    static long swapAdjacentBits(long n) {
        // Get all even bits of n
        // 0xAAAAAAAA has all the even bits set and odd bits cleared
        long even_bits = n & 0xAAAAAAAA;  
      
        // Get all odd bits of n 
        // 0x55555555 has all the odd bits set and even bits cleared
        long odd_bits = n & 0x55555555;  
      
        // Right shift even bits 
        even_bits >>= 1;  
          
        // Left shift even bits 
        odd_bits <<= 1;  
          
        // Combine even and odd bits 
        return (even_bits | odd_bits); 
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
            System.out.println(swapAdjacentBits(sc.nextLong()));
        
        sc.close();
    }
}