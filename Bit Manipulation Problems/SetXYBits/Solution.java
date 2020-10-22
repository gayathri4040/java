//Give 2 position x and y, return a number with x and y bits set
// x = 1, y = 2 => number => 0 1 1 0 => 6

import java.util.*;

class Solution {

    static long setXYBits(long x, long y) {
        //left shift 1 to x positions -> if x = 1, after left shift x would be (0 0 1 0)
        //left shift 1 to y positions -> if y = 2, after left shift y would be (0 1 0 0)
        //performing OR would return a number that has both x and y bits set
        return (1<<x | 1<<y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        long y = sc.nextLong();
        
        System.out.println(setXYBits(x, y));

        sc.close();
    }    
}
