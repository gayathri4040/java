// Given a number, reverse the bits in the binary representation (consider 32-bit unsigned data) of the number, 
// and print the new number formed.

// Constraints
// 1 <= T <= 100000
// 0 <= N <= 10^9

import java.util.*;
import java.math.BigInteger;

class Solution {

    static BigInteger reverseBits(long n) {
        long[] a = new long[32];
        for(int i=0; i<32; i++)
            a[i] = 0;
        
        int index = 31;
        while(n!=0) {
            a[index] = n&1;
            n = n>>1;
            index--;
        }

        BigInteger result = BigInteger.ZERO;
        for(int i=0; i<32; i++) {
            if(a[i] == 1)
                result = result.add(BigInteger.ONE.shiftLeft(i));
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            long n = sc.nextLong();
            System.out.println(reverseBits(n)); 
        }

        sc.close();
    }
}
