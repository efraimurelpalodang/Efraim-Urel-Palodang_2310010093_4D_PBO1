
package uas;

// Inheritance
public class LapanganPremium extends Lapangan {
    private int fasilitasTambahan;

    public LapanganPremium(String nama, int hargaPerJam, int fasilitasTambahan) {
        super(nama, hargaPerJam);
        this.fasilitasTambahan = fasilitasTambahan;
    }

    // polymorpism ( override )
    @Override
    public String getInfo() {
        return super.getInfo() + ", Tambahan: Rp" + fasilitasTambahan + " Sudah dapat minum gratis dan fasilitas lengkap";
    }

    public int getTotalHargaPerJam() {
        return super.getHargaPerJam() + fasilitasTambahan;
    }
}
