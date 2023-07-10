public class SortAlgoTimeComplexity {
    public static void main(String[] args) {

        // calculate the time complexity of each sorting algorithm
        long[][] time = new long[4][6];
        for (int i = 0; i < 6; i++) {
            int n = 1000 * (i + 1);
            Object[] unsorted = generate(n);
            time[0][i] = timeComplexity(unsorted, "selection");
            time[1][i] = timeComplexity(unsorted, "insertion");
            time[2][i] = timeComplexity(unsorted, "bubble");
            time[3][i] = timeComplexity(unsorted, "merge");
        }

        // print the table of time complexity
        System.out.println("                  +--------+--------+--------+--------+--------+--------+");
        System.out.format("  %15s | %6d | %6d | %6d | %6d | %6d | %6d |\n", "", 1000, 2000, 3000, 4000, 5000, 6000);
        System.out.println("+-----------------+--------+--------+--------+--------+--------+--------+");
        System.out.format("| %15s | %6s | %6s | %6s | %6s | %6s | %6s |\n", "Selection Sort", time[0][0] + "ms", time[0][1] + "ms", time[0][2] + "ms", time[0][3] + "ms", time[0][4] + "ms", time[0][5] + "ms");
        System.out.format("| %15s | %6s | %6s | %6s | %6s | %6s | %6s |\n", "Insertion Sort", time[1][0] + "ms", time[1][1] + "ms", time[1][2] + "ms", time[1][3] + "ms", time[1][4] + "ms", time[1][5] + "ms");
        System.out.format("| %15s | %6s | %6s | %6s | %6s | %6s | %6s |\n", "Bubble Sort", time[2][0] + "ms", time[2][1] + "ms", time[2][2] + "ms", time[2][3] + "ms", time[2][4] + "ms", time[2][5] + "ms");
        System.out.format("| %15s | %6s | %6s | %6s | %6s | %6s | %6s |\n", "Merge Sort", time[3][0] + "ms", time[3][1] + "ms", time[3][2] + "ms", time[3][3] + "ms", time[3][4] + "ms", time[3][5] + "ms");
        System.out.println("+-----------------+--------+--------+--------+--------+--------+--------+");
    }

    // bubble sort method
    static Object[] bubbleSort(Object[] unsorted) {
        Object[] sorted = unsorted;
        int n = sorted.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (sorted[j - 1].toString().compareTo(sorted[j].toString()) > 0) {
                    Object temp = sorted[j - 1];
                    sorted[j - 1] = sorted[j];
                    sorted[j] = temp;
                }
            }
        }
        return sorted;
    }

    // selection sort method
    static Object[] selectionSort(Object[] unsorted) {
        Object[] sorted = unsorted;
        int n = sorted.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (sorted[j].toString().compareTo(sorted[min].toString()) < 0) {
                    min = j;
                }
            }
            if (i != min) {
                Object temp = sorted[i];
                sorted[i] = sorted[min];
                sorted[min] = temp;
            }
        }
        return sorted;
    }

    // insertion sort method
    static Object[] insertionSort(Object[] unsorted) {
        Object[] sorted = unsorted;
        int n = sorted.length;
        for (int i = 1; i < n; i++) {
            Object key = sorted[i];
            int j = i - 1;
            while (j >= 0 && sorted[j].toString().compareTo(key.toString()) > 0) {
                sorted[j + 1] = sorted[j];
                j = j - 1;
            }
            sorted[j + 1] = key;
        }
        return sorted;
    }

    // merge sort method
    static Object[] mergeSort(Object[] unsorted) {
        Object[] sorted = unsorted;
        int n = sorted.length;
        if (n > 1) {
            int mid = n / 2;
            Object[] left = new Object[mid];
            Object[] right = new Object[n - mid];
            for (int i = 0; i < mid; i++) {
                left[i] = sorted[i];
            }
            for (int i = mid; i < n; i++) {
                right[i - mid] = sorted[i];
            }
            left = mergeSort(left);
            right = mergeSort(right);
            sorted = merge(left, right);
        }
        return sorted;
    }

    // merge method
    static Object[] merge(Object[] left, Object[] right) {
        Object[] sorted = new Object[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].toString().compareTo(right[j].toString()) < 0) {
                sorted[k] = left[i];
                i++;
            } else {
                sorted[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            sorted[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            sorted[k] = right[j];
            j++;
            k++;
        }
        return sorted;
    }

    // Object generator method
    static Object[] generate(int n) {
        Object[] items = new Object[n];
        for (int i = 0; i < n; i++) {
            items[i] = (int) (Math.random() * n);
        }
        return items;
    }

    // time calculation method
    static long timeComplexity(Object[] items, String sort) {
        long start = System.currentTimeMillis();
        if (sort.equals("bubble")) {
            bubbleSort(items);
        } else if (sort.equals("selection")) {
            selectionSort(items);
        } else if (sort.equals("insertion")) {
            insertionSort(items);
        } else if (sort.equals("merge")) {
            mergeSort(items);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
}
