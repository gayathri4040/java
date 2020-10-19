//Check if a given number is power of 2 or not 
//1 <= N <= 10^18

import java.io.*;
import java.util.*;
import java.math.BigInteger;

class Solution {

    static boolean powerOf2(long n) {
        //n & n-1 unsets the right most set (least significant) bit to 0
        //the numbers which are power of 2, have only one significant bit in their binary representation
        //if that one bit is unset, the number becomes zero
        //if it doesn't become zero then the number is not a power of 2
        if((n & n-1) == 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = Long.parseLong(sc.next());
        System.out.println(powerOf2(n));

        sc.close();
    }
}