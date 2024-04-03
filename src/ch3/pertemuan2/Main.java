package ch3.pertemuan2;

public class Main {
    Main
    // Membuat objek kategori
    Category category = new Category("Electronics");
    // Membuat objek detail produk dengan kategori
    DetailProduct detailProduct = new DetailProduct("Smartphone", Optional.of(category));
    // Membuat objek produk dengan detail produk
    Product product = new Product("iPhone", Optional.of(detailProduct));
//        Product product = new Product();
}
