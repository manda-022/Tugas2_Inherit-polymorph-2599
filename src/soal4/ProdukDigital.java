package soal4;

/**
 * Merepresentasikan produk digital yang mendapat diskon digital.
 */
public class ProdukDigital extends Produk {

    /** Diskon produk digital sebesar 10 persen. */
    public static final double DISKON_DIGITAL = 0.10;

    private final double ukuranMb;

    /**
     * Membuat produk digital baru.
     *
     * @param kode       kode unik produk
     * @param nama       nama produk
     * @param hargaDasar harga dasar dalam rupiah
     * @param ukuranMb   ukuran berkas dalam MB, tidak boleh negatif
     * @throws IllegalArgumentException jika data dasar tidak valid atau ukuran negatif
     */
    public ProdukDigital(String kode, String nama, double hargaDasar, double ukuranMb) {
        super(kode, nama, hargaDasar);
        if (ukuranMb < 0) {
            throw new IllegalArgumentException("Ukuran tidak boleh negatif: " + ukuranMb);
        }
        this.ukuranMb = ukuranMb;
    }

    /**
     * Menghitung harga akhir: harga dasar dikurangi diskon digital.
     *
     * @return harga akhir dalam rupiah
     */
    @Override
    public double hitungHargaAkhir() {
        return super.hitungHargaAkhir() * (1 - DISKON_DIGITAL);
    }

    /**
     * Mengembalikan keterangan jenis dan ukuran produk.
     *
     * @return teks seperti "digital 20.0 MB"
     */
    @Override
    public String deskripsi() {
        return "digital " + ukuranMb + " MB";
    }
}
