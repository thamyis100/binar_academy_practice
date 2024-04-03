package com.binar.batch7.ch1.pertemuan6;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

class Contact {
    private String name;
    private String phoneNumber;
    private LocalDateTime addedTime;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.addedTime = LocalDateTime.now();
    }
    public Contact(String name, String phoneNumber, LocalDateTime addedTime) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.addedTime = addedTime;
    }

    // Getters for name, phoneNumber, and addedTime
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public LocalDateTime getTime() {
        return addedTime;
    }

    public String toString() {
        return name + ", " + phoneNumber + ", " + addedTime;
    }
}

public class latihan {
    // Specify the file path
    private static final String FILE_PATH = "phonebook.txt";
    private static final List<Contact> contacts = new ArrayList<>();
    public static void main(String[] args) {
        // Check if the file exists, if not, create it
        File file = new File(FILE_PATH);

        // Check if the file exists
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("File created: " + FILE_PATH);
                } else {
                    System.out.println("Failed to create file: " + FILE_PATH);
                }
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
        else{
            // Load contacts from the file
            addContactsFromFile(FILE_PATH);
        }

        while (true){
        System.out.println("=== Aplikasi Buku Telepon ===");
        System.out.println("1. Tambah Kontak");
        System.out.println("2. Cetak Buku Telepon");
        System.out.println("3. Tampilkan Riwayat Buku Telepon");
        System.out.println("4. Cetak ke CSV");
        System.out.println("5. Keluar");
        System.out.print("Pilihan: ");


        //input
            Scanner scanner = new Scanner(System.in);
            int choice2 = scanner.nextInt();

            switch (choice2) {
                case 1:
                    tambahKontak();
                    break;
                case 2:
                    cetakBuku();
                    break;
                case 3:
                    tampilkanRiwayat();
                    break;
                case 4:
                    cetakCSV();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan aplikasi.");
                    System.exit(0);
                    break;
                default:
                    break;

            }

        }
    }

    private static void addContactsFromFile(String filePath) {
        try {
            Scanner fileScanner = new Scanner(new File(filePath));

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length == 3) {
                    String name = parts[0];
                    String phoneNumber = parts[1];
                    String timeString = parts[2];

                    // Parse the time string into a LocalDateTime object
                    LocalDateTime time = LocalDateTime.parse(timeString);

                    // Create a new Contact object and add it to the contacts list
                    Contact contact = new Contact(name, phoneNumber, time);
                    contacts.add(contact);
                } else {
                    System.out.println("Invalid data format in the file: " + line);
                }
            }

            fileScanner.close();
            System.out.println("Data from file '" + filePath + "' successfully loaded.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
    }

    private static void saveToFile(Contact contact) {
        try (FileWriter writer = new FileWriter(FILE_PATH);
             PrintWriter printer = new PrintWriter(writer)) {
            printer.println(contact.getName() + "," + contact.getPhoneNumber() + "," + contact.getTime());
        } catch (IOException e) {
            System.out.println("An error occurred while saving to file: " + e.getMessage());
        }
    }

    public static void tambahKontak(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama: ");
        String name = scanner.nextLine();
        System.out.print("Masukkan nomor telepon: ");
        String phoneNumber = scanner.nextLine();
        Contact contact = new Contact(name, phoneNumber);
        contacts.add(contact);
        System.out.println("Kontak berhasil ditambahkan.");
        saveToFile(contact);
    }

    private static void cetakBuku() {
        System.out.println("=== Buku Telepon ===");
        for (Contact contact : contacts) {
            System.out.println(contact.getName() + " - " + contact.getPhoneNumber());
        }

        // Prompt the user to press enter to return
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tekan enter untuk kembali ke menu utama.");
        scanner.nextLine(); // Wait for the user to press enter
    }

    private static void tampilkanRiwayat() {
        System.out.println("=== Riwayat Buku Telepon ===");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }

        // Prompt the user to press enter to return
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tekan enter untuk kembali ke menu utama.");
        scanner.nextLine(); // Wait for the user to press enter
    }


    private static void cetakCSV() {
        try (FileWriter writer = new FileWriter("phonebook.csv");
             PrintWriter printer = new PrintWriter(writer)) {
            for (Contact contact : contacts) {
                StringJoiner joiner = new StringJoiner(",");
                joiner.add(contact.getName())
                        .add(contact.getPhoneNumber())
                        .add(contact.getTime().toString()); // Assuming getTime() returns a String representation of time
                printer.println(joiner.toString());
            }
            System.out.println("Data berhasil disimpan ke phonebook.csv");
        } catch (IOException e) {
            System.out.println("An error occurred while saving to CSV: " + e.getMessage());
        }
    }
}
