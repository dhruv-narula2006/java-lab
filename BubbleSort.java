class BubbleSort
{
    static void bubbleSort(int[] arr)
    {
        for(int i = 0; i < arr.length-1; i++){
            for(int j = 0; j < arr.length-i-1; j++){
                if(arr[j+1] < arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String [] args)
    {
        int [] numbers = {8, 3, 6, 7, 1, 2, 9, 11, 4};
        System.out.println("Array before Sorting: ");
        for(int num : numbers)
        {
            System.out.print(num + " ");
        }
        System.out.println("\nArray after sorting:");
        bubbleSort(numbers);
        for(int num : numbers)
        {
            System.out.print(num +" ");
        }
    }
}

