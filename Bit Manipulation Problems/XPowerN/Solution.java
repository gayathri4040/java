//Given x and n, compute x power n i.e x^n

import java.util.*;
import java.lang.Math;

class Solution {

    // if n = 13(1101) -> x^n => x^1 * x^4 * x^8
    //So, whenever the bit is set, we multiply the repective power value to the result
    static long xPowerN(long x, long n) {
        long result = 1;
        while(n != 0) {
            if((n&1) == 1)
                result = result * x;
            x *= x;
            n = n>>1;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        long n = sc.nextLong();

        System.out.println(xPowerN(x, n));

        sc.close();
    }    
}
