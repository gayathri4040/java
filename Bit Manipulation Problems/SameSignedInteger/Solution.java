//Check if 2 given two signed integers are of the same sign.

import java.io.*;
import java.util.*;

class Solution {

    static boolean sameSignedInteger(int a, int b) {
        //If the signed bits are different (a=-ve, b=+ve || a=+ve, b=-ve), XOR of both the numbers would result to a negative number
        //If the signed bits are same (a=+ve, b=+ve || a=-ve, b=-ve), XOR of both the number would result to a negative number
        if((a^b) >= 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(sameSignedInteger(a, b));
        
        sc.close();
    }    
}
