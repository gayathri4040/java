// You are given two numbers A and B. 
// Write a program to count the number of bits to be flipped to change the number A to the number B. 
// Flipping a bit of a number means changing a bit from 1 to 0 or vice versa.

import java.util.*;

class Solution {

    static long countFlipBits(long a, long b) {
        //xor of a and b leaves the bits that are left out in a and b, 
        //so flipping them in a would result in b and vice versa
        long xor = a^b;
        long count = 0;
        while(xor != 0) {
            count++;
            xor &= (xor-1);
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();

        System.out.println(countFlipBits(a, b));
        
        sc.close();
    }
}
