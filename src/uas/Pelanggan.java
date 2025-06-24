
package uas;

public class Pelanggan {
    private String nama;
    private String nomor;

    public Pelanggan(String nama, String nomor) {
        this.nama = nama;
        this.nomor = nomor;
    }

    public String getNama() {
        return nama;
    }

    public String getNomor() {
        return nomor;
    }
    
    // Mutator ( Setter )
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }
}
