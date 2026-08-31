// 3. Write a Java program that prompts the user for an integer and then 
// print out all the prime numbers upto that integer

import java.util.Scanner;
public class PrimeNumber{
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        // Prompt the user
        System.out.print("Enter an integer: ");
        int n = input.nextInt();
        System.out.println("Prime numbers upto "+ n + " are: ");
        // Check each number from 2 to n
        for(int i = 2; i<=n; i++){
            boolean isPrime = true;
            // Test if i is divisible by any number from 2 to sqrt(i)
            for(int j = 2; j<= Math.sqrt(i); j++){
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }
            // Print the number if it is prime
            if(isPrime){
                System.out.print(i + " ");
            }
        }
        input.close();
    }
}