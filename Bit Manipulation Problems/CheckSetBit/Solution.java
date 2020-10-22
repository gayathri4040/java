//Check if ith bit is set in a given integer n.

import java.util.*;

class Solution {

    static boolean checkSetBit(long n, long i) {
        //Right shift n by i positions
        //performing AND with 1, would result in 1 if the bit is set, otherwise 0
        return ((n>>i&1) == 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long i = sc.nextInt();

        System.out.println(checkSetBit(n, i));
        
        sc.close();
    }
}
