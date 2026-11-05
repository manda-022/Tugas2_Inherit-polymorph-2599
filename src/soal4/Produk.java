package soal4;

/**
 * Merepresentasikan produk umum di toko digital. Harga akhir produk umum sama dengan harga dasar;
 * subclass meng-override {@link #hitungHargaAkhir()} dan {@link #deskripsi()}.
 */
public class Produk {

    private final String kode;
    private final String nama;
    private final double hargaDasar;

    /**
     * Membuat produk baru setelah memvalidasi data.
     *
     * @param kode       kode unik produk, tidak boleh kosong
     * @param nama       nama produk, tidak boleh kosong
     * @param hargaDasar harga dasar dalam rupiah, tidak boleh negatif
     * @throws IllegalArgumentException jika kode atau nama kosong, atau harga dasar negatif
     */
    public Produk(String kode, String nama, double hargaDasar) {
        if (kode == null || kode.trim().isEmpty()) {
            throw new IllegalArgumentException("Kode produk tidak boleh kosong");
        }
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama produk tidak boleh kosong");
        }
        if (hargaDasar < 0) {
            throw new IllegalArgumentException("Harga dasar tidak boleh negatif: " + hargaDasar);
        }
        this.kode = kode;
        this.nama = nama;
        this.hargaDasar = hargaDasar;
    }

    /**
     * Mengambil kode produk.
     *
     * @return kode produk
     */
    public String getKode() {
        return kode;
    }

    /**
     * Mengambil nama produk.
     *
     * @return nama produk
     */
    public String getNama() {
        return nama;
    }

    /**
     * Mengambil harga dasar produk.
     *
     * @return harga dasar dalam rupiah
     */
    public double getHargaDasar() {
        return hargaDasar;
    }

    /**
     * Menghitung harga akhir produk. Produk umum tidak punya biaya atau diskon tambahan.
     *
     * @return harga akhir dalam rupiah
     */
    public double hitungHargaAkhir() {
        return hargaDasar;
    }

    /**
     * Mengembalikan keterangan jenis produk.
     *
     * @return keterangan jenis produk
     */
    public String deskripsi() {
        return "umum";
    }

    /**
     * Memformat satu baris struk: kode | nama | deskripsi | RpNNN.
     *
     * @return baris struk produk
     */
    public String formatBarisStruk() {
        return String.format("%s | %s | %s | Rp%.0f", kode, nama, deskripsi(), hitungHargaAkhir());
    }
}
