package soal1;

/**
 * Merepresentasikan laptop gaming, yaitu laptop dengan kartu grafis dan garansi tambahan.
 */
public class LaptopGaming extends Laptop {

    /** Garansi tambahan khusus laptop gaming, dalam bulan. */
    private static final int GARANSI_TAMBAHAN_BULAN = 6;

    private final String kartuGrafis;

    /**
     * Membuat laptop gaming baru. Garansi yang tersimpan adalah
     * garansiBulan ditambah {@value #GARANSI_TAMBAHAN_BULAN} bulan.
     *
     * @param merek           merek laptop
     * @param harga           harga laptop dalam rupiah
     * @param garansiBulan    garansi dasar dalam bulan, sebelum tambahan
     * @param ramGb           kapasitas RAM dalam GB
     * @param ukuranLayarInci ukuran layar dalam inci
     * @param kartuGrafis     nama kartu grafis, tidak boleh kosong
     * @throws IllegalArgumentException jika data tidak valid atau kartu grafis kosong
     */
    public LaptopGaming(String merek, double harga, int garansiBulan, int ramGb,
                        double ukuranLayarInci, String kartuGrafis) {
        super(merek, harga, garansiBulan + GARANSI_TAMBAHAN_BULAN, ramGb, ukuranLayarInci);
        if (kartuGrafis == null || kartuGrafis.trim().isEmpty()) {
            throw new IllegalArgumentException("Kartu grafis tidak boleh kosong");
        }
        this.kartuGrafis = kartuGrafis;
    }

    /**
     * Menyusun ringkasan laptop gaming: data laptop ditambah kartu grafis.
     *
     * @return ringkasan satu baris tentang laptop gaming
     */
    @Override
    public String infoSingkat() {
        return super.infoSingkat() + " | GPU " + kartuGrafis;
    }
}
