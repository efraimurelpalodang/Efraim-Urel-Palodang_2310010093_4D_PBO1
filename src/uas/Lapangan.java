
package uas;

// Class
public class Lapangan {
    // Enkapsulation & Attribute
    private String nama;
    private int hargaPerJam;

    // Constructor
    public Lapangan(String nama, int hargaPerJam) {
        this.nama = nama;
        this.hargaPerJam = hargaPerJam;
    }

    // Accessor ( Getter )
    public String getNama() {
        return nama;
    }

    public int getHargaPerJam() {
        return hargaPerJam;
    }
    
    public double hitungHarga(int durasi) {
        return this.getHargaPerJam() * durasi;
    }

    public String getInfo() {
        return nama + " - Harga per jam: Rp" + this.getHargaPerJam();
    }
}
