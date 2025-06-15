// Jacob Achenbach
// 6/15/2025

// Generates a list of 50 random integers from 1 to 20 and returns a new list with all duplicate values removed.


import java.util.ArrayList;
import java.util.Random;
import java.util.LinkedHashSet;

public class Module3Assignment {

    public static void main(String[] args) {
        ArrayList<Integer> originalList = new ArrayList<>();
        Random rand = new Random();

        // Fill the list with 50 random numbers from 1 to 20
        for (int i = 0; i < 50; i++) {
            originalList.add(rand.nextInt(20) + 1);
        }

        System.out.println("Original List:");
        System.out.println(originalList);

        // Remove duplicates
        ArrayList<Integer> uniqueList = removeDuplicates(originalList);

        System.out.println("\nList After Removing Duplicates:");
        System.out.println(uniqueList);
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {

        // Removes duplicates and keeps original order
        return new ArrayList<>(new LinkedHashSet<>(list));
    }
}
