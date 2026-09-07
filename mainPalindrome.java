// b. mainPalindrome.java
import java.util.Scanner;
import Palindrome.PalindromeCheck;

public class mainPalindrome{  
    public static void main(String [] args){
        System.out.print("Enter a string: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        PalindromeCheck obj = new PalindromeCheck();
        if(obj.isPalindrome(str)){  
            System.out.println(str + " is a palindrome.");
        } else {
            System.out.println(str + " is not a palindrome.");
        }
        sc.close();
    }
}