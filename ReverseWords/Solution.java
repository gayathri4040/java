import java.io.*;
import java.util.*;

class Solution{

  static StringBuffer reverseWordsInString(StringBuffer s){
    int start = 0, end = s.length()-1;
    reverseString(s, start, end);
    for(int i=0;i<s.length();i++){
      if(s.charAt(i)==' '){
        end = i-1;
        reverseString(s, start, i-1);
        start = i+1;
      }
    }
    reverseString(s, start, s.length()-1);
    return s;
  }

  static StringBuffer reverseString(StringBuffer s, int i, int j){
    int mid = (i+j)/2;
    for(; i<=mid && j>=mid; i++, j--){
      char temp = s.charAt(i);
      s.setCharAt(i, s.charAt(j));
      s.setCharAt(j, temp);
    }
    return s;
  }

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    StringBuffer s = new StringBuffer(sc.nextLine());
    System.out.println(reverseWordsInString(s));
    sc.close();
  }
}
