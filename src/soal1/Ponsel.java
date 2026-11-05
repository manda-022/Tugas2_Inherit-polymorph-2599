package soal1;

/**
 * Merepresentasikan ponsel sebagai perangkat elektronik dengan kapasitas penyimpanan dan kamera.
 */
public class Ponsel extends Perangkat {

    private final int kapasitasGb;
    private final int jumlahKamera;

    /**
     * Membuat ponsel baru.
     *
     * @param merek        merek ponsel
     * @param harga        harga ponsel dalam rupiah
     * @param garansiBulan lama garansi dalam bulan
     * @param kapasitasGb  kapasitas penyimpanan dalam GB, harus positif
     * @param jumlahKamera jumlah kamera, tidak boleh negatif
     * @throws IllegalArgumentException jika data dasar tidak valid, kapasitas tidak positif,
     *                                  atau jumlah kamera negatif
     */
    public Ponsel(String merek, double harga, int garansiBulan, int kapasitasGb, int jumlahKamera) {
        super(merek, harga, garansiBulan);
        if (kapasitasGb <= 0) {
            throw new IllegalArgumentException("Kapasitas harus positif: " + kapasitasGb);
        }
        if (jumlahKamera < 0) {
            throw new IllegalArgumentException("Jumlah kamera tidak boleh negatif: " + jumlahKamera);
        }
        this.kapasitasGb = kapasitasGb;
        this.jumlahKamera = jumlahKamera;
    }

    /**
     * Menyusun ringkasan ponsel: data perangkat ditambah kapasitas dan jumlah kamera.
     *
     * @return ringkasan satu baris tentang ponsel
     */
    @Override
    public String infoSingkat() {
        return super.infoSingkat() + " | " + kapasitasGb + " GB | " + jumlahKamera + " kamera";
    }
}
