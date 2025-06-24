package uas;

import java.io.PrintWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FutsalManager {
    // array
    private Lapangan[] lapanganList = new Lapangan[4];

    public FutsalManager() {
        lapanganList[0] = new Lapangan("Lapangan No. 1", 120000);
        lapanganList[1] = new Lapangan("Lapangan No. 2", 120000);
        lapanganList[2] = new Lapangan("Lapangan No. 3", 120000);
        lapanganList[3] = new LapanganPremium("Lapangan VIP", 150000, 30000);
    }

    public void tampilkanLapangan() {
        System.out.println("Daftar Lapangan:");
        // perulangan
        for (int i = 0; i < lapanganList.length; i++) {
            System.out.println((i + 1) + ". " + lapanganList[i].getInfo());
        }
    }

    public void prosesPemesanan() {
        Scanner scanner = new Scanner(System.in);
        boolean ulangi = true;
        
        // perulangan
        while (ulangi) {
            try {
                // io sederhana
                System.out.print("Masukkan nama pelanggan: ");
                String nama = scanner.nextLine();

                if (nama.trim().isEmpty()) {
                    System.out.println("Nama tidak boleh kosong.");
                    continue;
                }

                System.out.print("Masukkan nomor HP: ");
                String nohp = scanner.nextLine();

                if (!nohp.matches("\\d+")) {
                    System.out.println("Nomor HP harus berupa angka.");
                    continue;
                }

                // object
                Pelanggan pelangganBaru = new Pelanggan(nama, nohp);

                tampilkanLapangan();

                System.out.print("Masukkan nomor lapangan: ");
                int lIndex;
                
                // Error handling
                try {
                    lIndex = scanner.nextInt() - 1;
                } catch (InputMismatchException ime) {
                    System.out.println("Input harus berupa angka.");
                    scanner.nextLine();
                    continue;
                }

                if (lIndex < 0 || lIndex >= lapanganList.length) {
                    System.out.println("Nomor lapangan tidak valid.");
                    scanner.nextLine();
                    continue;
                }

                System.out.print("Durasi pemesanan (jam): ");
                int durasi;
                try {
                    durasi = scanner.nextInt();
                } catch (InputMismatchException ime) {
                    System.out.println("Durasi harus berupa angka.");
                    scanner.nextLine();
                    continue;
                }

                
                if (durasi < 1) {
                    System.out.println("Durasi minimal adalah 1 jam.");
                    scanner.nextLine();
                    continue;
                }
                
                scanner.nextLine();
                System.out.print("Masukkan jam mulai (format 24 jam, contoh 19:00): ");
                String jamMulai = scanner.nextLine();

                // object
                Pemesanan pemesanan = new Pemesanan(pelangganBaru, lapanganList[lIndex], durasi);
                pemesanan.setJamMulai(jamMulai);
                
                System.out.println(pemesanan.getRingkasan());

                // error handling dengan try-catch
                try (PrintWriter out = new PrintWriter("log_pemesanan.txt")) {
                    out.println(pemesanan.getRingkasan());
                } catch (IOException e) {
                    System.out.println("Gagal menyimpan data.");
                }
 
                System.out.print("Apakah ingin memesan lagi? (y/n): ");
                String jawab = scanner.next();
                scanner.nextLine();
                
                // Seleksi
                // if else menu ulang
                if (jawab.equalsIgnoreCase("y")) {
                    ulangi = true;
                } else {
                    ulangi = false;
                    System.out.println("Terima kasih telah menggunakan layanan kami.");
                }

            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }
        }
    }
}
