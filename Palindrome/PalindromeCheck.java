// 4. Write a Java program that checks whether a given string is palindrome or not.

// PalindromeCheck.java
package Palindrome;

public class PalindromeCheck{
    public boolean isPalindrome(String str){
        if(str == null){
            return false;
        }
        str = str.toLowerCase();
        int start = 0;
        int end = str.length() - 1;

        while(start < end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }
}