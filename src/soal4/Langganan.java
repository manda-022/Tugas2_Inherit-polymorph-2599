package soal4;

/**
 * Merepresentasikan produk langganan, yaitu produk digital yang ditagih per bulan.
 * Langganan tidak memakai diskon digital, tetapi diskon langganan untuk durasi panjang.
 */
public class Langganan extends ProdukDigital {

    /** Diskon langganan sebesar 20 persen. */
    public static final double DISKON_LANGGANAN = 0.20;

    /** Durasi minimal (bulan) agar berhak mendapat diskon langganan. */
    public static final int BATAS_BULAN_DISKON = 12;

    private final int durasiBulan;

    /**
     * Membuat langganan baru.
     *
     * @param kode        kode unik produk
     * @param nama        nama produk
     * @param hargaDasar  harga dasar per bulan dalam rupiah
     * @param ukuranMb    ukuran berkas dalam MB
     * @param durasiBulan lama langganan dalam bulan, harus positif
     * @throws IllegalArgumentException jika data dasar tidak valid atau durasi tidak positif
     */
    public Langganan(String kode, String nama, double hargaDasar, double ukuranMb, int durasiBulan) {
        super(kode, nama, hargaDasar, ukuranMb);
        if (durasiBulan <= 0) {
            throw new IllegalArgumentException("Durasi harus positif: " + durasiBulan);
        }
        this.durasiBulan = durasiBulan;
    }

    /**
     * Menghitung harga akhir: harga dasar dikali durasi, dengan diskon langganan
     * jika durasi minimal {@value #BATAS_BULAN_DISKON} bulan. Diskon digital tidak dipakai,
     * sehingga method milik ProdukDigital sengaja tidak dipanggil lewat super.
     *
     * @return harga akhir dalam rupiah
     */
    @Override
    public double hitungHargaAkhir() {
        double total = getHargaDasar() * durasiBulan;
        if (durasiBulan >= BATAS_BULAN_DISKON) {
            total *= 1 - DISKON_LANGGANAN;
        }
        return total;
    }

    /**
     * Mengembalikan keterangan jenis dan durasi langganan.
     *
     * @return teks seperti "langganan 12 bulan"
     */
    @Override
    public String deskripsi() {
        return "langganan " + durasiBulan + " bulan";
    }
}
