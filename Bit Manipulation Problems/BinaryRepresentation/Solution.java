//Print Binary representation of a given number.

import java.io.*;
import java.util.*;

class Solution {

    static String binary(int n) {
        if(n == 0)
            return "0";
        
        StringBuffer binaryString = new StringBuffer();
        while(n!=0) {
            if((n&1) == 0)
                binaryString.insert(0, '0');
            else 
                binaryString.insert(0, '1');
            n = n>>1;
        }
        return binaryString.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(binary(n));
        
        sc.close();
    }
}
