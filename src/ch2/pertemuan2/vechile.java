package ch2.pertemuan2;

abstract class Vehicle {
    // Atribut
    String brand;
    int year;

    // Constructor
    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    // Abstract method untuk menghitung biaya servis kendaraan
    abstract double calculateServiceCost();

}