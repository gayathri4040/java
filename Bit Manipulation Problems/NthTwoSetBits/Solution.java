// Look at the following sequence:
// 3, 5, 6, 9, 10, 12, 17, 18, 20....

// All the numbers in the series has exactly 2 bits set in their binary representation. 
// Your task is simple, you have to find the Nth number of this sequence.

// Constraints
// 1 <= T <= 10^5
// 1 <= N <= 10^14

import java.util.*;

class Solution {

    static long m = 1000000007;
    
    static long aPowerB(long a, long b) {
        long result = 1;
        while(b!=0) {
            if((b&1) == 1) 
                result = (result*a)%m;
            a = (a*a)%m;
            b = b>>1;
        }
        return result;
    }
    
    static long nthTwoSetBitNumber(long s) {
        
        //using s, we need to find the partition which it resides in.
        //ideally, n*(n+1)/2 = s
        //and quadratic equation would be - n^2 + n - 2*s = 0
        //as we know, ax^2 + bx + c = 0 => x = (-b + sqrt(b^2 - 4ac))/2a
        //using that, n^2 + n - 2*s = 0 => n = (-1 + sqrt(1+8s))/2
        long n = (long)(Math.ceil((-1 + Math.sqrt(1+8*s))/2));
        long left_most = aPowerB(2, n)%m;
        
        //n*(n+1)/2 would be the last number in the previous partition
        //s-(n*(n+1)/2)-1 would give the number of shifts to be done, i.e 2 power (number)
        long right_most = aPowerB(2, (s-(long)(n*(n-1)/2)-1))%m;
        
        //Adding both left most bit number and right most bit number would be the final result
        long result = (left_most + right_most)%m;
        return result;   
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            System.out.println(nthTwoSetBitNumber(sc.nextLong()));
        }

        sc.close();
    }    
}

//https://www.hackerrank.com/contests/smart-interviews/challenges/si-two-set-bits
