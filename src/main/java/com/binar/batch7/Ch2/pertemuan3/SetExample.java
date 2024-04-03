package com.binar.batch7.Ch2.pertemuan3;

import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        // Create a HashSet to store unique elements
        Set<String> fruits = new HashSet<>();

        // Adding elements to the set
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple"); // Adding a duplicate element (will be ignored)

        // Printing the set
        System.out.println("Fruits Set: " + fruits);

        // Checking if a set contains a specific element
        System.out.println("Does the set contain 'Apple'? " + fruits.contains("Apple"));

        // Removing an element from the set
        fruits.remove("Banana");
        System.out.println("Fruits Set after removing 'Banana': " + fruits);

        // Iterating over the elements of the set
        System.out.println("Iterating over the elements of the set:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Clearing the set
        fruits.clear();
        System.out.println("Fruits Set after clearing: " + fruits);

        ////////////////////////////
        //Union, Intersection, and Difference
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        // Union
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("Union: " + union);

        // Intersection
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("Intersection: " + intersection);

        // Difference (Elements present in set1 but not in set2)
        Set<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println("Difference (set1 - set2): " + difference);
    }
}
