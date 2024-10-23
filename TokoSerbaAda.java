package tokoserbaada;

import java.util.Scanner;

public class TokoSerbaAda {

    public static void main(String[] args) {
        // Input Scanner
        Scanner scanner = new Scanner(System.in);
        
        // Daftar barang
        Barang[] barang = {
            new Barang("a001", "Buku", 3000),
            new Barang("a002", "Pensil", 4000),
            new Barang("a003", "Pulpen", 5000)
        };
        
        int jumlahItem = 3;  // Jumlah item yang akan dibeli
        int[] jumlahBeli = new int[jumlahItem];
        int totalBayar = 0;
        
        System.out.println("TOKO SERBA ADA");
        System.out.println("**********************");
        
        // Input barang
        for (int i = 0; i < jumlahItem; i++) {
            System.out.println("Data ke " + (i + 1));
            System.out.print("Masukkan kode : ");
            String kode = scanner.nextLine();
            System.out.print("Masukkan jumlah beli : ");
            jumlahBeli[i] = scanner.nextInt();
            scanner.nextLine();  // Bersihkan newline
            
            boolean found = false;
            for (int j = 0; j < barang.length; j++) {
                if (kode.equals(barang[j].kode)) {
                    found = true;
                    totalBayar += barang[j].harga * jumlahBeli[i];
                    break;
                }
            }
            
            if (!found) {
                System.out.println("Kode barang tidak ditemukan!");
                return;
            }
        }
        
        // Output tabel
        System.out.println();
        System.out.println("TOKO SERBA ADA");
        System.out.println("No   Kode      Nama Barang    Harga   Jumlah Beli   Jumlah Bayar");
        System.out.println("=================================================================");
        
        for (int i = 0; i < jumlahItem; i++) {
            int jumlahBayarPerBarang = barang[i].harga * jumlahBeli[i];
            System.out.printf("%-5d%-10s%-15s%7d%13d%15d\n", 
                (i + 1), barang[i].kode, barang[i].nama, barang[i].harga, jumlahBeli[i], jumlahBayarPerBarang);
        }
        
        System.out.println("=================================================================");
        System.out.printf("Total Bayar                                           %d\n", totalBayar);
    }
}
