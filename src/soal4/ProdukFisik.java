package soal4;

/**
 * Merepresentasikan produk fisik yang dikenai ongkos kirim berdasarkan berat.
 */
public class ProdukFisik extends Produk {

    /** Ongkos kirim per kilogram dalam rupiah. */
    public static final double ONGKOS_KIRIM_PER_KG = 10000;

    private final double beratKg;

    /**
     * Membuat produk fisik baru.
     *
     * @param kode       kode unik produk
     * @param nama       nama produk
     * @param hargaDasar harga dasar dalam rupiah
     * @param beratKg    berat dalam kilogram, tidak boleh negatif
     * @throws IllegalArgumentException jika data dasar tidak valid atau berat negatif
     */
    public ProdukFisik(String kode, String nama, double hargaDasar, double beratKg) {
        super(kode, nama, hargaDasar);
        if (beratKg < 0) {
            throw new IllegalArgumentException("Berat tidak boleh negatif: " + beratKg);
        }
        this.beratKg = beratKg;
    }

    /**
     * Menghitung harga akhir: harga dasar ditambah ongkos kirim (berat dikali tarif per kg).
     *
     * @return harga akhir dalam rupiah
     */
    @Override
    public double hitungHargaAkhir() {
        return super.hitungHargaAkhir() + beratKg * ONGKOS_KIRIM_PER_KG;
    }

    /**
     * Mengembalikan keterangan jenis dan berat produk.
     *
     * @return teks seperti "fisik 1.5 kg"
     */
    @Override
    public String deskripsi() {
        return "fisik " + beratKg + " kg";
    }
}
