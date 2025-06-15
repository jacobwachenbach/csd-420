// Jacob Achenbach
// 6/15/2025

// Program shows that using an Iterator to go through a LinkedList is much faster than using get(index) because get(index) is slow in linked lists.


import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListTraversalTest {

    public static void main(String[] args) {
        // Test with 50,000 integers
        System.out.println("Testing with 50,000 integers:");
        runTraversalTest(50_000);

        System.out.println("\n------------------------------\n");

        // Test with 500,000 integers
        System.out.println("Testing with 500,000 integers:");
        runTraversalTest(500_000);
    }

    // Method to run traversal tests
    public static void runTraversalTest(int size) {
        LinkedList<Integer> list = new LinkedList<>();

        // Fill the LinkedList with integers from 0 to size - 1
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        // Traverse using Iterator and measure time
        long startTime = System.nanoTime();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long endTime = System.nanoTime();
        long iteratorTime = endTime - startTime;

        System.out.println("Iterator traversal time: " + iteratorTime / 1_000_000.0 + " ms");

        // Traverse using get(index) and measure time
        startTime = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        endTime = System.nanoTime();
        long indexTime = endTime - startTime;

        System.out.println("get(index) traversal time: " + indexTime / 1_000_000.0 + " ms");

        // Functional test to ensure data is correctly stored
        if (list.get(0) == 0 && list.get(list.size() - 1) == size - 1) {
            System.out.println("Test passed: Data correctly stored in LinkedList.");
        } else {
            System.out.println("Test failed: Data not correctly stored.");
        }

        // Analysis
        System.out.println("Analysis:");
        System.out.println("- Iterator is efficient for LinkedList traversal because it avoids repeated node lookup.");
        System.out.println("- get(index) is slow for LinkedList because each get(i) has O(i) complexity, making total traversal O(n^2).");
    }
}
