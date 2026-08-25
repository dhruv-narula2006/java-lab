// 2. Write a Java program that implements bubble Sort algorithm for sorting in descending order
// and also shows the number of interchanges occurred for a given set of integers.

public class BubbleSortDescending {
    public static void main(String [] args){
        int[] arr = {1, 5, 4, 13, 11, 8, 20, 7};
        int n = arr.length;
        int interchanges = 0;
        
        // Before sorting
        System.out.println("Array before sorting: ");
        for(int num : arr){
            System.out.print(num + " ");
        }
        // Bubble Sort in descending order
        for(int i = 0; i<n-1; i++){
            for(int j = 0; j < n-i-1; j++){
                if(arr[j] < arr[j+1]){     //Swapping
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    interchanges++;
                }
            }
        }
        // After sorting
        System.out.println("\n\nArray after sorting in descending order: ");
        for(int num : arr){
            System.out.print(num + " ");
        }
        System.out.println("\n\nNumber of interchanges: " + interchanges);
    }
}
