public class QuickSort
{
    // Method to perform quick sort
    static void quickSort(int[] arr, int low, int high)
    {
        if(low<high)
        {
            int pivot = partition(arr, low, high);

            // Sorting elements before pivot
            quickSort(arr, low, pivot-1);

            // Sort elements after pivot
            quickSort(arr, pivot+1, high);
        }
    }
    // partition method
    static int partition(int [] arr, int low, int high)
    {
        int pivot = arr[high];
        int i = low - 1;
        for(int j=low; j<high; j++)
        {
            if(arr[j]<pivot)
            {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // placing pivot at its correct position
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }
    public static void main(String [] args)
    {
        int [] arr = {10, 7, 8, 9, 1, 5};
        System.out.println("Array before sorting:");

        for(int num : arr)
        {
            System.out.print(num + " ");
        }
        quickSort(arr, 0, arr.length - 1);  

        System.out.println("\nArray after sorting:");

        for(int num : arr)
        {
            System.out.print(num + " ");
        }
    }
}

// Output:
// Array before sorting:
// 10 7 8 9 1 5 
// Array after sorting:
// 1 5 7 8 9 10 