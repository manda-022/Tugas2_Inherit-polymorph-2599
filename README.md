# Tugas 2 Praktikum PBO: Inheritance, Composition, dan Polimorfisme

| Keterangan | Isi |
|---|---|
| Nama lengkap | **[Hermanda Saputra]** |
| NPM | **[250810701100099]** |
| Kelas praktikum | A |
| Repository | `https://github.com/manda-022/Tugas2_Inherit-polymorph-2599.git` |

## Deskripsi Singkat

Tugas ini berisi empat soal Java (tanpa BlueJ) yang melatih inheritance, composition, dan polimorfisme dari Praktikum 6 dan 7. Soal 1 sampai 3 menguji konsep satu per satu, sedangkan Soal 4 menggabungkan semuanya dalam program kecil toko digital. Jawaban analisis dan pertanyaan tambahan ada di bagian akhir README ini.

## Fitur Utama

- **Soal 1:** menampilkan ringkasan laptop, ponsel, dan laptop gaming; menghitung pajak 10 persen; menghitung harga laptop setelah diskon; menolak harga negatif dan merek kosong dengan pesan yang jelas.
- **Soal 2:** mendemonstrasikan urutan pembuatan objek, pemanggilan method yang tepat lewat polimorfisme, downcast yang gagal, dan downcast aman dengan `instanceof`.
- **Soal 3:** membuat garis dari dua titik, menghitung panjangnya, dan menjaga isi garis tidak berubah oleh titik di luar garis.
- **Soal 4:** membuat keranjang belanja berisi produk fisik, digital, dan langganan; mencetak struk dengan harga akhir tiap jenis; merekap jumlah per jenis; menolak kode produk ganda.

## Konsep OOP yang Diterapkan

| Konsep | Lokasi penerapan | Alasan singkat |
|---|---|---|
| Inheritance (multi level) | `Perangkat` > `Laptop` > `LaptopGaming` (soal1) | Laptop gaming adalah laptop, laptop adalah perangkat, sehingga data dan perilaku dasar dipakai ulang |
| `protected` | `Perangkat.harga`, diakses di `Laptop.hitungHargaPromo` | Subclass perlu akses langsung ke harga, kelas lain tidak |
| `super(...)` dan `super.method()` | Semua constructor subclass; `infoSingkat()` di soal1 | Memakai ulang inisialisasi dan teks superclass tanpa menyalin kode |
| Konstanta | `TARIF_PAJAK`, `GARANSI_TAMBAHAN_BULAN`, `ONGKOS_KIRIM_PER_KG`, `DISKON_DIGITAL`, `DISKON_LANGGANAN`, `BATAS_BULAN_DISKON` | Menghindari magic number, tarif cukup diubah di satu tempat |
| Method overriding | `infoSingkat()`, `hitungHargaAkhir()`, `deskripsi()`, `suara()`, `luas()` | Tiap subclass punya perilaku sendiri untuk kontrak yang sama |
| Method overloading | Constructor `Garis` dan `Titik` (soal3) | Satu kelas bisa dibuat dengan beberapa bentuk input |
| Composition (has-a) | `Garis` memiliki dua `Titik`; `Keranjang` memiliki daftar `Produk` | Garis bukan sebuah titik, keranjang bukan sebuah produk |
| Polimorfisme | `Keranjang.hitungTotal()` dan `cetakStruk()` | Satu perulangan atas `Produk` menghasilkan perilaku berbeda tanpa `instanceof` |
| Downcast aman | `instanceof` di `Keranjang.hitungPerJenis()` dan `TesSoal2Lanjutan` | Memeriksa tipe sebelum memperlakukan objek sebagai subclass |
| Defensive copy | Constructor, getter, dan setter `Garis` memakai `new Titik(...)` | Isi `Garis` tidak berubah oleh objek di luar kelas |
| Exception | `IllegalArgumentException`, `IllegalStateException` | Data tidak valid dan kode ganda ditolak sedini mungkin |

## Struktur Project

```
Tugas2_Inherit-polymorph-Npmawalakhir/
├── src/
│   ├── soal1/  Perangkat, Laptop, Ponsel, LaptopGaming, TesSoal1
│   ├── soal2/  Hewan, Kucing, A, B, Lingkaran, Titik, TesSoal2, TesSoal2Lanjutan
│   ├── soal3/  Titik, Garis, TesSoal3
│   └── soal4/  Produk, ProdukFisik, ProdukDigital, Langganan, Keranjang, TesSoal4
├── .gitignore
└── README.md
```

`TesSoal2` adalah kode Bagian A persis seperti soal dan sengaja berhenti dengan `ClassCastException`. `TesSoal2Lanjutan` menjalankan perbaikan `instanceof`, Bagian B, dan Bagian C.

## Prasyarat

- JDK 17 atau lebih baru (diuji dengan JDK 21)
- IDE yang disarankan: IntelliJ IDEA

## Cara Menjalankan Program

**IntelliJ**

1. Buka folder project, lalu tandai folder `src` sebagai *Sources Root* (klik kanan `src`, *Mark Directory as*, *Sources Root*).
2. Buka kelas uji (misalnya `soal1/TesSoal1.java`), klik ikon run di samping `main`.
3. Atau buat *Run Configuration* bertipe *Application* dengan *Main class* `soal1.TesSoal1` (ganti sesuai soal).

**Command line** (dari root project)

```bash
mkdir out
javac -d out src/soal1/*.java src/soal2/*.java src/soal3/*.java src/soal4/*.java

java -cp out soal1.TesSoal1
java -cp out soal2.TesSoal2
java -cp out soal2.TesSoal2Lanjutan
java -cp out soal3.TesSoal3
java -cp out soal4.TesSoal4
```

## Contoh Output

> Tambahkan screenshot hasil eksekusi di bawah tiap blok (ganti baris `![...]`). Teks di bawah adalah output asli dari program.

### Soal 1 (skenario normal dan exception tertangani)

```
Asus | garansi 24 bulan | RAM 16 GB | layar 14.0 inci
Samsung | garansi 12 bulan | 128 GB | 3 kamera
MSI | garansi 18 bulan | RAM 32 GB | layar 15.6 inci | GPU RTX 4060
Pajak laptop: Rp800000
Promo laptop 10 persen: Rp7200000
Gagal (Harga negatif): Harga tidak boleh negatif: -1.0
Gagal (Merek kosong): Merek tidak boleh kosong
```



### Soal 2

`TesSoal2`:

```
Hewan dibuat: Tom
Kucing dibuat
Tom makan
meong
meong
Tom memanjat
Hewan dibuat: Generik
Exception in thread "main" java.lang.ClassCastException: class soal2.Hewan cannot be cast to class soal2.Kucing ...
	at soal2.TesSoal2.main(TesSoal2.java:24)
```

`TesSoal2Lanjutan`:

```
=== Bagian A (perbaikan instanceof) ===
Hewan dibuat: Generik
h2 bukan Kucing, downcast dibatalkan
=== Bagian B ===
A dibuat
init B, nilai=0
B dibuat, nilai=5
=== Bagian C ===
78.53981633974483
0.0
0.0
```



### Soal 3

```
(0.0, 0.0) - (3.0, 4.0) panjang=5.0
(1.0, 1.0) - (5.0, 5.0)
```



### Soal 4 (skenario normal dan exception tertangani)

```
F01 | Keyboard Mekanik | fisik 1.5 kg | Rp515000
D01 | Ebook Java | digital 20.0 MB | Rp90000
L01 | Kelas Online | langganan 12 bulan | Rp1440000
TOTAL: Rp2045000
Fisik: 1, Digital: 1, Langganan: 1
Gagal: Kode produk sudah ada di keranjang: F01
Gagal: Nama produk tidak boleh kosong
```



---

## Jawaban Soal dan Analisis Konsep

### Soal 1: Pertanyaan Tambahan

Setelah `harga` diubah menjadi `private` di `Perangkat`, kompilasi menghasilkan:

```
soal1/Laptop.java:47: error: harga has private access in Perangkat
        return harga - (harga * diskonPersen / PERSEN_PENUH);
               ^
soal1/Laptop.java:47: error: harga has private access in Perangkat
        return harga - (harga * diskonPersen / PERSEN_PENUH);
                        ^
2 errors
```

Error muncul karena anggota `private` hanya bisa diakses dari dalam kelas yang mendeklarasikannya. Subclass memang mewarisi atribut tersebut sebagai bagian dari objek, tetapi tidak boleh menyentuhnya langsung. `hitungHargaPromo()` di `Laptop` menulis `harga` dua kali, maka ada dua error. Solusinya `protected` (sesuai soal) atau getter `getHarga()`.

### Soal 2: Analisis Output, Error, dan Polimorfisme

**Bagian A**

**1. Output lengkap** (prediksi saya sama dengan hasil sebenarnya):

```
Hewan dibuat: Tom
Kucing dibuat
Tom makan
meong
meong
Tom memanjat
Hewan dibuat: Generik
Exception in thread "main" java.lang.ClassCastException: class soal2.Hewan cannot be cast to class soal2.Kucing
```

Constructor superclass berjalan lebih dulu (`Hewan dibuat`, lalu `Kucing dibuat`). `h.makan()` mencetak "Tom makan" lalu memanggil `suara()` versi Kucing ("meong"). `h.suara()` mencetak "meong" lagi. Setelah `Hewan dibuat: Generik`, program berhenti di downcast `(Kucing) h2`.

**2. `h.panjat()` tanpa komentar:** terjadi **error kompilasi**, bukan runtime.

```
error: cannot find symbol
        h.panjat();
         ^
  symbol:   method panjat()
  location: variable h of type Hewan
```

Kompiler hanya memeriksa tipe statis variabel (`Hewan`). Kelas `Hewan` tidak punya `panjat()`, walaupun objek aslinya `Kucing`.

**3. Baris penyebab `ClassCastException`:** `Kucing k2 = (Kucing) h2;`. Objek yang ditunjuk `h2` dibuat dengan `new Hewan(...)`, jadi bukan `Kucing`. Perbaikan tanpa mengubah tipe variabel `h2`:

```java
Hewan h2 = new Hewan("Generik");
if (h2 instanceof Kucing) {
    Kucing k2 = (Kucing) h2;
    k2.panjat();
} else {
    System.out.println("h2 bukan Kucing, downcast dibatalkan");
}
```

**4. `suara()` milik kelas mana pada `h.makan()`:** milik **Kucing**. Tipe statis `h` adalah `Hewan`, tetapi tipe dinamis objeknya `Kucing`. Method `makan()` memang ditulis di `Hewan`, namun pemanggilan `suara()` di dalamnya dipilih saat runtime (dynamic dispatch) berdasarkan tipe dinamis, sehingga versi `Kucing` yang berjalan.

**Bagian B**

**5. Output `new B();`:**

```
A dibuat
init B, nilai=0
B dibuat, nilai=5
```

Nilai pada "init B" adalah 0, bukan 5, karena urutan pembuatan objek: constructor `A` berjalan lebih dulu, sedangkan field `nilai` milik `B` baru diisi 5 setelah `super()` selesai. Saat `A()` memanggil `init()`, dispatch dinamis sudah menjalankan versi `B`, padahal field `B` masih bernilai default (0). Risikonya: method yang di-override bisa berjalan pada objek yang belum selesai diinisialisasi, sehingga membaca nilai setengah jadi atau memicu `NullPointerException` pada field objek. Karena itu constructor sebaiknya hanya memanggil method `private`, `static`, atau `final`.

**Bagian C**

**6.** `l3.luas()` menghasilkan 0.0 karena `luas()` dipilih berdasarkan tipe dinamis (`Titik`), bukan tipe variabel (`Lingkaran`). Relasi "Titik adalah sebuah Lingkaran" kurang masuk akal sebagai is-a: titik secara matematis memang lingkaran berjari-jari 0, tetapi dalam kode ia melanggar harapan pengguna `Lingkaran` (luas selalu positif), sehingga melanggar prinsip substitusi Liskov. Akibatnya, method yang mengharapkan `Lingkaran` dengan luas lebih dari nol, misalnya membagi dengan luas, bisa menghasilkan pembagian dengan nol atau hasil keliru ketika diberi `Titik`. Desain lebih aman: `Lingkaran` dan `Titik` sama-sama subclass dari satu superclass abstrak `Bangun`, bukan saling mewarisi.

### Soal 3: Titik dan Garis

**1. Baris kedua sebelum perbaikan** (prediksi lalu diverifikasi dengan menjalankan versi tanpa salinan):

```
(100.0, 1.0) - (5.0, 5.0)
```

`Garis` menyimpan referensi ke objek `Titik` yang sama dengan `t` (aliasing). Saat `t.setX(100)` dipanggil, objek yang sama ikut berubah, sehingga titik awal `g2` menjadi x = 100.

**2. Setelah defensive copy** (constructor, getter, dan setter `Garis` memakai `new Titik(...)`):

```
(1.0, 1.0) - (5.0, 5.0)
```

**3. Kapan masing-masing tepat:** Perilaku sebelum perbaikan (berbagi referensi) tepat bila Garis memang harus *mengikuti* titik, misalnya garis penghubung dua penanda di peta yang bergerak, atau bila objek besar dan salinan terlalu mahal. Perilaku sesudah perbaikan tepat bila Garis harus menjadi data yang stabil dan aman: nilai tidak boleh berubah diam-diam oleh kode lain, terutama pada kelas yang dipakai banyak bagian program atau banyak thread.

**4. Jika `Garis extends Titik`:** relasi is-a tidak masuk akal karena garis bukan sebuah titik, dan has-a yang sebenarnya terjadi (garis *memiliki* dua titik) tidak terwakili. Garis akan mewarisi `x`, `y`, `jarakKe()`, dan `setX()` yang tidak bermakna baginya. Garis butuh dua titik, sedangkan warisan hanya memberi satu set koordinat, sehingga harus ditambahkan titik kedua dan menjadikan koordinat warisan ambigu. Objek Garis juga bisa dipakai di tempat yang meminta `Titik` (substitusi yang salah arti).

### Analisis Konsep

**1. Overriding vs overloading.** Overriding adalah subclass menulis ulang method superclass dengan signature yang sama; method mana yang berjalan ditentukan saat runtime sesuai tipe dinamis objek, sehingga inilah dasar polimorfisme. Contoh dari kode: `Laptop.infoSingkat()` meng-override `Perangkat.infoSingkat()`. Overloading adalah beberapa method atau constructor bernama sama dengan daftar parameter berbeda dalam satu kelas; pilihan ditentukan kompiler saat kompilasi. Contoh: dua constructor `Garis` (`Titik, Titik` dan `x1, y1, x2, y2`). Overriding membutuhkan inheritance, sedangkan overloading tidak.

**2. Inheritance vs composition.** Pilih inheritance bila hubungannya benar-benar is-a dan subclass layak dipakai di mana saja superclass dipakai, contoh: `Langganan` adalah `ProdukDigital` yang adalah `Produk`. Pilih composition bila hubungannya has-a atau hanya ingin memakai fungsionalitas kelas lain, contoh: `Garis` memiliki dua `Titik` dan `Keranjang` memiliki daftar `Produk`. Composition lebih longgar terikatnya dan lebih aman diubah, sehingga menjadi pilihan awal bila ragu.

**3. `cetakStruk()` vs `hitungPerJenis()`.** `cetakStruk()` cukup memanggil `produk.formatBarisStruk()` dan `hitungHargaAkhir()` pada tipe `Produk`; polimorfisme otomatis memilih versi yang benar untuk tiap objek, jadi tidak perlu tahu jenisnya. `hitungPerJenis()` justru perlu *mengetahui* jenis konkret untuk menghitung, sehingga memakai `instanceof`, dan `Langganan` harus dicek sebelum `ProdukDigital` karena ia juga `ProdukDigital`. Downcast tidak selalu aman karena kompiler hanya melihat tipe statis; bila objek aslinya bukan tipe tujuan, terjadi `ClassCastException` saat runtime (seperti pada `h2` di Soal 2). Karena itu downcast harus didahului `instanceof`.

## Batasan dan Pengembangan Lanjutan

- Tantangan opsional `ProdukBundel` belum dikerjakan. Rencananya: kelas turunan `Produk` yang menyimpan beberapa `Produk` (composition) dan menerapkan diskon bundel di `hitungHargaAkhir()`.
- Nilai uang memakai `double` demi kesederhanaan; untuk aplikasi nyata sebaiknya `BigDecimal`.
- Belum ada fitur menghapus produk dari keranjang atau memuat data dari berkas.
- Pengujian masih berupa program `main`; bisa dikembangkan dengan JUnit.
