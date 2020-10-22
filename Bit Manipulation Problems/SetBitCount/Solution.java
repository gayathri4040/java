//Find the number of set bits in a given integer

import java.util.*;

class Solution {

    static int setBitCount(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            n = n&(n-1); //clears the right most set bit
        }
        return count;
    }

    static int recursiveSetBitCount(int n) {
        if(n == 0)
            return 0;
        return 1+recursiveSetBitCount(n&(n-1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(setBitCount(n));
        
        sc.close();
    }
}
