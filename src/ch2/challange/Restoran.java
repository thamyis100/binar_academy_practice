package ch2.challange;


import lombok.Getter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;


@Getter
class Order{
    private  String menu;
    private  Integer qty;

    public Order(String menu, Integer qty) {
        this.menu = menu;
        this.qty = qty;
    }
}

public class Restoran {
    private static final Logger logger = Logger.getLogger(Restoran.class.getName());
    private static final Map<String, Integer> menu = new HashMap<>();
    private static final List<Order> orders = new ArrayList<>();
    static {
        menu.put("Nasi Goreng", 15000);
        menu.put("Mie Goreng", 13000);
        menu.put("Nasi + Ayam", 18000);
        menu.put("Es Teh Manis", 3000);
        menu.put("Es Jeruk", 5000);
    }
    public static void main(String[] args) {
        // buat variabel
        Scanner scanner = new Scanner(System.in);
        int choice;
        Map<String, Integer> order = new HashMap<>();

        do {
            logger.info("""
                    ==========================
                    Selamat datang di BinarFud
                    ==========================
                    """);
            choice = -1;
            //loop menu makanan
            System.out.println("\nSilahkan pilih makanan :");
            int count = 1;
            //looping manggil menu
            for (Map.Entry<String, Integer> entry : menu.entrySet()) {
                System.out.println(count + ". " + entry.getKey() + "\t" + "\t| " + entry.getValue());
                count++;
            }

            System.out.println("99. Pesan dan Bayar");
            System.out.println("0. Keluar aplikasi");
            System.out.print("\nPilihan Anda: ");

            //masukkan input
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else { // debugging
                System.out.println("Input tidak valid. Mohon masukkan angka.");
                if (scanner.hasNext()) {
                    String nonIntValue = scanner.next();
                    System.out.println("Input is not an integer: " + nonIntValue);
                } else {
                    System.out.println("No more input available.");
                }
                scanner.nextLine();
            }

            //logika pilihan
            if (choice >= 1 && choice <= menu.size()) {
                int qty =0;
                do {
                String chosenItem = (String) menu.keySet().toArray()[choice - 1];
                int price = menu.get(chosenItem);
                System.out.println("\n==========================");
                System.out.println("Berapa pesanan anda");
                System.out.println("==========================\n");
                System.out.println(chosenItem + "\t| " + price);
                System.out.print("(input 0 untuk kembali)\n\nqty => ");
                try {
                    qty = Integer.parseInt(scanner.next());
                    if (qty == 0) {
                        System.out.println("\n==========================");
                        System.out.println("Minimal 1 jumlah pesanan");
                        System.out.println("==========================\n");

                        scanner = new Scanner(System.in);
                        scanner.nextLine(); // Wait for the user to press enter
                    } else {
                        Order order1 = new Order(chosenItem, price*qty);
                        orders.add(order1);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input tidak valid. Mohon masukkan angka.");
                }
                }while (qty==0);

            } else if (choice == 99) {
                confirmOrder(order);
            }


        }while (choice!=0);
        System.out.println("Terima kasih telah menggunakan aplikasi.");
        System.exit(0);
    }
    // melakukan konfirmasi pembelian
    public static void confirmOrder(Map<String, Integer> order) {
        //variabel
        int total = 0;


        System.out.println("\n==========================");
        System.out.println("Konfirmasi & Pembayaran");
        System.out.println("==========================\n");
        for (Order order1:orders){
            System.out.println(
                    order1.getMenu() + "\t" + "\t" + (order1.getQty() / menu.get(order1.getMenu())) + "\t" + order1.getQty());
            total += order1.getQty();
        }
        System.out.println("------------------------------ +");
        System.out.println("Total\t\t\t" + total);
        System.out.println("\n1. Konfirmasi dan Bayar");
        System.out.println("2. Kembali ke menu utama");
        System.out.println("0. Keluar aplikasi");
        System.out.println("");
        System.out.print("=>");

//input
        Scanner scanner = new Scanner(System.in);
        int choice2 = scanner.nextInt();
//logika input
        switch (choice2) {
            case 1:
                //receipt.txt
                generatePaymentReceipt(order, total);
                //text show receipt
                System.out.println("\n==========================");
                System.out.println("BinarFud");
                System.out.println("==========================\n");
                System.out.println("Terima kasih sudah memesan di BinarFud\n");
                System.out.println("Dibawah ini adalah pesanan anda\n");
                for (Map.Entry<String, Integer> entry : order.entrySet()) {
                    System.out.println(entry.getKey() + "\t" + (entry.getValue() / menu.get(entry.getKey())) + "\t"
                            + entry.getValue());
                }
                System.out.println("------------------------------ +");
                System.out.println("Total\t\t\t" + total);
                System.out.println("\nPembayaran: BinarCash");
                System.out.println("\n==========================");
                System.out.println("Simpan struk ini sebagai\nbukti pembayaran");
                System.out.println("==========================\n");

                confirmLeave();
                break;
            case 2:
                //do nothing to go back
                break;
            case 0:
                System.out.println("Terima kasih telah menggunakan aplikasi.");
                System.exit(0);
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    private static void generatePaymentReceipt(Map<String, Integer> order, int total) {
        // Prepare the receipt content using StringBuilder
        StringBuilder receiptContent = new StringBuilder();
        receiptContent.append("==========================\n");
        receiptContent.append("BinarFud\n");
        receiptContent.append("==========================\n");
        receiptContent.append("Terima kasih sudah memesan di BinarFud\n\n");
        receiptContent.append("Dibawah ini adalah pesanan anda\n\n");
        for (Order order1:orders){
            System.out.println(
                    order1.getMenu() + "\t" + "\t" + (order1.getQty() / menu.get(order1.getMenu())) + "\t" + order1.getQty());
            total += order1.getQty();
        }
        receiptContent.append("------------------------------ +\n");
        receiptContent.append("Total\t\t\t").append(total).append("\n\n");
        receiptContent.append("Pembayaran: BinarCash\n\n");
        receiptContent.append("==========================\n");
        receiptContent.append("Simpan struk ini sebagai\nbukti pembayaran\n");
        receiptContent.append("==========================\n");

        // Write the receipt content to file
        try (FileWriter fileWriter = new FileWriter("payment_receipt.txt")) {
            fileWriter.write(receiptContent.toString());
            System.out.println("Receipt created successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while creating the receipt.");
            e.printStackTrace();
        }
    }

    private static void confirmLeave(){
        System.out.println("\n==========================");
        System.out.println("Mohon masukkan input");
        System.out.println("pillihan anda");
        System.out.println("==========================\n");
        System.out.println("(y) untuk lanjut");
        System.out.println("(n) untuk keluar");
        System.out.println("=> ");
        //input
        Scanner scanner = new Scanner(System.in);
        String choice3 = scanner.next();
        if (choice3.equals("n")){
            System.out.println("Terima kasih telah menggunakan aplikasi.");
            System.exit(0);
        }


    }


}
