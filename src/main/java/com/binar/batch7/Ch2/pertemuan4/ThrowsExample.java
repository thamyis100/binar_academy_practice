package com.binar.batch7.Ch2.pertemuan4;

import java.io.IOException;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class ThrowsExample {
        public static void main(String[] args) {
        //throw
//        try {
//            // Panggil method yang bisa melemparkan eksepsi
//            validateAge(15);
//        } catch (InvalidAgeException e) {
//            System.out.println("Exception caught: " + e.getMessage());
//        }

        //throws
        try {
            // Panggil method yang dapat melemparkan IOException
            readFromFile("example.txt");
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
            System.out.println("test");
        }
    }
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        }
    }
    static void readFromFile(String filename) throws IOException {
        // Simulasi membaca dari file
        // Jika file tidak ditemukan atau ada masalah lain saat membaca, lempar IOException
        throw new IOException("File not found: " + filename);
    }
}
