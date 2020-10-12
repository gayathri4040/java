import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;  

class Result {

    public static int maximumPower(StringBuffer s) {
        
        boolean allCharsAreSame = s.toString().matches("(.)\\1+");
        //If all the characters in the string are 1, then return 0, because it is odd and is not divisible by 0.
        if(allCharsAreSame && s.charAt(0) == '1')
            return 0;
        
        //If all the characters in the string are 0, then return -1, because 0 is not divisible by any number.
        if(allCharsAreSame && s.charAt(0) == '0')
            return -1;
        
        //If all characters are not same
        //and if the first char is 0, shift until the first char is 1.
        //understood with example: 
        // if you don't shift - this will be the case - 0101100 - max continous zeroes length - 2
        // if you shift - this will be the case - 1011001 - max continous zeroes length - 3 -- this is correct
        while(s.charAt(0) == '0')
            shift(s);
        
        String[] zeroes = s.toString().trim().split("1+");
        int max = 0;
        for(int i=0; i<zeroes.length; i++)
            max = Math.max(zeroes[i].length(), max);

        return max;
    }
    
    public static void shift(StringBuffer s) {
        char temp = s.charAt(s.length()-1);
        s.deleteCharAt(s.length()-1);
        s.insert(0, temp);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuffer binary = new StringBuffer(sc.next());
        
        System.out.println(Result.maximumPower(binary));
    }
}
