// Jacob Achenbach
// 6/29/2025

// Program sorts arrays using bubble sort with the Comparable and Comparator methods.

import java.util.Comparator;

public class GenericBubbleSort {

    // Generic bubble sort using Comparable
    public static <T extends Comparable<T>> void bubbleSortComparable(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Generic bubble sort using Comparator
    public static <T> void bubbleSortComparator(T[] array, Comparator<T> comp) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (comp.compare(array[j], array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Utility method to print arrays
    public static <T> void printArray(T[] array) {
        System.out.print("[ ");
        for (T item : array) {
            System.out.print(item + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        
    }
}