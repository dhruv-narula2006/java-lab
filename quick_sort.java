// 1. Write a Java program that implements Quick Sort algorithm for sorting a list of 
// names in ascending order.

class  quick_sort{

    static int partition(String[] names, int low, int high) {
        String pivot = names[high];

        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (names[j].compareTo(pivot) < 0) {
                i++;
                swap(names, i, j);
            }
        }

        swap(names, i + 1, high);
        return i + 1;
    }

    static void swap(String[] names, int i, int j) {
        String temp = names[i];
        names[i] = names[j];
        names[j] = temp;
    }

    static void quickSort(String[] names, int low, int high) {
        if (low < high) {
            int pivot = partition(names, low, high);

            quickSort(names, low, pivot - 1);
            quickSort(names, pivot + 1, high);
        }
    }

    public static void main(String[] args) {
        String[] names = {
            "Kirat", "Dheeraj", "Shaurya", 
            "Harish", "Ritik", "Arshin"
        };

        quickSort(names, 0, names.length - 1);

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }
}

