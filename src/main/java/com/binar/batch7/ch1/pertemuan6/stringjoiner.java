package com.binar.batch7.ch1.pertemuan6;

import java.util.StringJoiner;

public class stringjoiner {
    public static void main(String[] args) {
        // Membuat StringJoiner dengan delimiter ","
        StringJoiner joiner1 = new StringJoiner(",", "{", "]");
        joiner1.add("Apple");
        joiner1.add("Banana");
        joiner1.add("Orange");

        // Mengonversi StringJoiner menjadi string
        String fruits1 = joiner1.toString();
        System.out.println(fruits1); // Output: Apple,Banana,Orange
    }


}