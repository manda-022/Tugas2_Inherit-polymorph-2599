package soal1;

/**
 * Merepresentasikan laptop sebagai perangkat elektronik dengan RAM dan ukuran layar.
 */
public class Laptop extends Perangkat {

    private static final double PERSEN_PENUH = 100.0;

    private final int ramGb;
    private final double ukuranLayarInci;

    /**
     * Membuat laptop baru.
     *
     * @param merek           merek laptop
     * @param harga           harga laptop dalam rupiah
     * @param garansiBulan    lama garansi dalam bulan
     * @param ramGb           kapasitas RAM dalam GB, harus positif
     * @param ukuranLayarInci ukuran layar dalam inci, harus positif
     * @throws IllegalArgumentException jika data dasar tidak valid, RAM atau layar tidak positif
     */
    public Laptop(String merek, double harga, int garansiBulan, int ramGb, double ukuranLayarInci) {
        super(merek, harga, garansiBulan);
        if (ramGb <= 0) {
            throw new IllegalArgumentException("RAM harus positif: " + ramGb);
        }
        if (ukuranLayarInci <= 0) {
            throw new IllegalArgumentException("Ukuran layar harus positif: " + ukuranLayarInci);
        }
        this.ramGb = ramGb;
        this.ukuranLayarInci = ukuranLayarInci;
    }

    /**
     * Menghitung harga laptop setelah diskon. Atribut harga diakses langsung
     * karena berstatus protected di superclass.
     *
     * @param diskonPersen besar diskon dalam persen, antara 0 sampai 100
     * @return harga setelah diskon dalam rupiah
     * @throws IllegalArgumentException jika diskon di luar rentang 0 sampai 100
     */
    public double hitungHargaPromo(double diskonPersen) {
        if (diskonPersen < 0 || diskonPersen > PERSEN_PENUH) {
            throw new IllegalArgumentException("Diskon harus 0 sampai 100 persen: " + diskonPersen);
        }
        return harga - (harga * diskonPersen / PERSEN_PENUH);
    }

    /**
     * Menyusun ringkasan laptop: data perangkat ditambah RAM dan ukuran layar.
     *
     * @return ringkasan satu baris tentang laptop
     */
    @Override
    public String infoSingkat() {
        return super.infoSingkat() + " | RAM " + ramGb + " GB | layar " + ukuranLayarInci + " inci";
    }
}
