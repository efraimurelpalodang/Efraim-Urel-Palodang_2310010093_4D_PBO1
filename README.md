# Proyek Akhir Pemrograman Berbasis Objek 1

Proyek ini adalah contoh sederhana aplikasi pemesanan / penyewaan lapangan futsal menggunakan Java sebagai tugas akhir dari mata kuliah pemrograman berbasis objek 1.

## Deskripsi

Aplikasi ini menerima input berupa nama pelanggan, nomor Hp pelanggan, durasi (jam), dan jam mulai sewa dan memberikan output berupa ringkasan pemesanan seperti pemesan, lapangan, durasi, jam sewa, dan total bayar.

Aplikasi ini mengimplementasikan beberapa konsep penting dalam pemrograman berorientasi objek (OOP) seperti Class, Object, Atribut, Method Constructor, Method Mutator, Method Accessor, Encapsulation, Inheritance, Overriding, Seleksi, Perulangan, IO Sederhana, Array, dan Error Handling.

## Penjelasan Kode

Berikut adalah bagian kode yang relevan dengan konsep OOP yang dijelaskan:

1. **Class** adalah template atau blueprint dari object. Pada kode ini, `FutsalManager`, `FutsalManagerBeraksi`, `Lapangan`, `LapanganPremium`, `Pelanggan`, dan `Pemesanan`, adalah contoh dari class.

```bash
public class FutsalManager {
    ...
}

public class FutsalManagerBeraksi {
    ...
}

public class Lapangan {
    ...
}

public class LapanganPremium extends Lapangan {
    ...
}

public class Pelanggan {
    ...
}

public class Pemesanan {
    ...
}
```

2. **Object** adalah instance dari class. Pada kode ini, `Pelanggan pelangganBaru = new Pelanggan(nama, nohp);` adalah contoh pembuatan object.

```bash
Pelanggan pelangganBaru = new Pelanggan(nama, nohp);
```

3. **Atribut** adalah variabel yang ada dalam class. Pada kode ini, `nama` dan `nomor` adalah contoh atribut.

```bash
private String nama;
private String nomor;
```

4. **Constructor** adalah method yang pertama kali dijalankan pada saat pembuatan object. Pada kode ini, constructor ada di dalam class `FutsalManager`, `Lapangan`, `LapanganPremium`, `Pelanggan` dan `Pemesanan`.

```bash
public FutsalManager() {
    lapanganList[0] = new Lapangan("Lapangan No. 1", 120000);
    lapanganList[1] = new Lapangan("Lapangan No. 2", 120000);
    lapanganList[2] = new Lapangan("Lapangan No. 3", 120000);
    lapanganList[0] = new LapanganPremium("Lapangan VIP", 150000, 30000);
}

public Lapangan(String nama, int hargaPerJam) {
    this.nama = nama;
    this.hargaPerjam = hargaPerjam;
}

public LapanganPremium(String nama, int hargaPerJam, int fasilitasTambahan) {
    super(nama, hargaPerJam);
    this.fasilitasTambahan = fasilitasTambahan;
}

public Pemesanan(Pelanggan pelanggan, Lapangan lapangan, int durasi) {
    this.pelanggan = pelanggan;
    this.lapangan = lapangan;
    this.durasi = durasi;
}

public Pelanggan(String nama, String nomor) {
    this.nama = nama;
    this.nomor = nomor;
}
```

5. **Mutator** atau setter digunakan untuk mengubah nilai dari suatu atribut. Pada kode ini, `setNama`, `setNomor`, dan `setJamMulai` adalah contoh method mutator.

```bash
public void setNama(String nama) {
    this.nama = nama;
}

public void setNomor(String nomor) {
    this.nomor = nomor;
}

public void setJamMulai(String jamMulai) {
    this.jamMulai = jamMulai;
}
```

6. **Accessor** atau getter digunakan untuk mengambil nilai dari suatu atribut. Pada kode ini, `getNama`, `getNomor`, `getNama`, `getHargaPerJam`, `getDurasi`, dan `getJamMulai`, adalah contoh method accessor.

```bash
public String getNama() {
    return nama;
}

public String getNomor() {
    return nomor;
}

public String getNama() {
    return nama;
}

public int getHargaPerJam() {
    return hargaPerJam;
}

public int getDurasi() {
    return durasi;
}

public String getJamMulai() {
    return jamMulai;
}

```

7. **Encapsulation** adalah konsep menyembunyikan data dengan membuat atribut menjadi private dan hanya bisa diakses melalui method. Pada kode ini, atribut `nama`, `hargaPerJam`, `nama`, `nomor`, `durasi`, dan `jamMulai` dienkapsulasi dan hanya bisa diakses melalui method getter dan setter.

```bash
private String nama;
private int hargaPerJam;
private String nama;
private String nomor;
private int durasi;
private String jamMulai;
```

8. **Inheritance** adalah konsep di mana sebuah class bisa mewarisi property dan method dari class lain. Pada kode ini, `LapanganPremium` mewarisi `Lapangan` dengan sintaks `extends`.

```bash
public class LapanganPremium extends Lapangan {
    ...
}
```

9. **Polymorphism** adalah konsep di mana sebuah nama dapat digunakan untuk merujuk ke beberapa tipe atau bentuk objek berbeda. Ini memungkinkan metode-metode dengan nama yang sama untuk berperilaku berbeda tergantung pada tipe objek yang mereka manipulasi, polymorphism bisa berbentuk Overloading ataupun Overriding. Pada kode ini, method `getInfo` di `LapanganPremium` merupakan override dari method `getInfo` di `Lapangan`.

```bash
@Override
public String getInfo() {
    ...
}
```

10. **Seleksi** adalah statement kontrol yang digunakan untuk membuat keputusan berdasarkan kondisi. Pada kode ini, digunakan seleksi `if else` dalam method `hitungTotalDenganDiskon`, di class `Pemesanan` dan ada 4 `if tunggal` dan 1 `if else` di dalam class `FutsalManager`. 

```bash
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

if (nama.trim().isEmpty()) {
    System.out.println("Nama tidak boleh kosong.");
    continue;
}

if (!nohp.matches("\\d+")) {
    System.out.println("Nomor HP harus berupa angka.");
    continue;
}

if (lIndex < 0 || lIndex >= lapanganList.length) {
    System.out.println("Nomor lapangan tidak valid.");
    scanner.nextLine();
    continue;
}

if (durasi < 1) {
    System.out.println("Durasi minimal adalah 1 jam.");
    scanner.nextLine();
    continue;
}

if (jawab.equalsIgnoreCase("y")) {
    ulangi = true;
} else {
    ulangi = false;
    System.out.println("Terima kasih telah menggunakan layanan kami.");
}

```

11. **Perulangan** adalah statement kontrol yang digunakan untuk menjalankan blok kode berulang kali. Pada kode ini, digunakan perulangan `for` di method `tampilkanLapangan()` untuk menampilkan semua data lapangan yang ada di dalam array. Selain itu, perulangan `while` digunakan pada method `prosesPemesanan()` agar user bisa melakukan pemesanan berkali-kali sampai memilih untuk keluar.

```bash
for (int i = 0; i < lapanganList.length; i++) {
    System.out.println((i + 1) + ". " + lapanganList[i].getInfo());
}

while (ulangi) {
    ...
}

```

12. **Input Output Sederhana** digunakan untuk menerima input dari user dan menampilkan output ke user. Pada kode ini, digunakan class `Scanner` untuk menerima input dan method `System.out.println` untuk menampilkan output.

```bash
Scanner scanner = new Scanner(System.in);
System.out.print("Masukkan nama pelanggan: ");
String nama = scanner.nextLine();

System.out.print("Masukkan nomor HP: ");
String nohp = scanner.nextLine();

System.out.println(pemesanan.getRingkasan());
System.out.print("Apakah ingin memesan lagi? (y/n): ");
```

13. **Array** adalah struktur data yang digunakan untuk menyimpan beberapa nilai dalam satu variabel. Pada kode ini, `private Lapangan[] lapanganList = new Lapangan[4];` adalah contoh penggunaan array.

```bash
private Lapangan[] lapanganList = new Lapangan[4];
```

14. **Error Handling** digunakan untuk menangani error yang mungkin terjadi saat runtime. Pada kode ini, digunakan `try catch` untuk menangani error.

```bash
try {
    .....
} catch (Exception e) {
    System.out.println("Terjadi kesalahan: " + e.getMessage());
}
```

## Usulan nilai

| No  | Materi         |  Nilai  |
| :-: | -------------- | :-----: |
|  1  | Class          |    5    |
|  2  | Object         |    5    |
|  3  | Atribut        |    5    |
|  4  | Constructor    |    5    |
|  5  | Mutator        |    5    |
|  6  | Accessor       |    5    |
|  7  | Encapsulation  |    5    |
|  8  | Inheritance    |    5    |
|  9  | Polymorphism   |   10    |
| 10  | Seleksi        |    5    |
| 11  | Perulangan     |    5    |
| 12  | IO Sederhana   |   10    |
| 13  | Array          |   15    |
| 14  | Error Handling |   15    |
|     | **TOTAL**      | **100** |

## Pembuat

Nama: Efraim Urel Palodang
NPM: 2310010093
