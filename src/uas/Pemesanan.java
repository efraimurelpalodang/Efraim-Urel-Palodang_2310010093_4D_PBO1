package uas;

public class Pemesanan {
    private Pelanggan pelanggan;
    private Lapangan lapangan;
    private int durasi;
    private String jamMulai;

    public Pemesanan(Pelanggan pelanggan, Lapangan lapangan, int durasi) {
        this.pelanggan = pelanggan;
        this.lapangan = lapangan;
        this.durasi = durasi;
    }
    
    public int getDurasi() {
        return durasi;
    }
    
    public String getJamMulai() {
        return jamMulai;
    }
    
    public void setJamMulai(String jamMulai) {
        this.jamMulai = jamMulai;
    }
    
    private String hitungJamSelesai() {
        try {
            String[] parts = getJamMulai().split(":");
            int jam = Integer.parseInt(parts[0]);
            int menit = Integer.parseInt(parts[1]);

            jam += durasi;
            if (jam >= 24) jam -= 24;

            return String.format("%02d:%02d", jam, menit);
        }   catch (Exception e) {
            return "salah penulisan format pada jam";
        }
    }

    public double hitungTotal() {
        return lapangan.hitungHarga(getDurasi());
    }

    public String hitungTotalDenganDiskon() {
        double total = hitungTotal();
        if (durasi >= 3) {
            double diskon = total * 0.20;
            total -= diskon;
            return "\nAnda mendapatkan diskon 20%" +
                    "\nHarga sebelum Diskon : Rp " + (int) hitungTotal() +
                    "\nTotal bayar setelah diskon : Rp " + (int) total;
        } else {
            return "\nTotal bayar: Rp " + (int) total;
        }
    }

    public String getRingkasan() {
        return "-------- RINGKASAN PEMESANAN ----------" +
           "\nPemesanan oleh: " + pelanggan.getNama() +
           "\nLapangan: " + lapangan.getNama() +
           "\nDurasi: " + durasi + " jam" +
           "\nJam sewa: " + jamMulai + " - " + hitungJamSelesai() +
           hitungTotalDenganDiskon() + 
           "\n----------------------------------------";
    }

}