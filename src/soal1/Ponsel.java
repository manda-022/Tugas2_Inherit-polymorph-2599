package soal1;

/**
 * Merepresentasikan ponsel sebagai perangkat elektronik dengan kapasitas penyimpanan dan kamera.
 * @author Hermanda Saputra
 */
public class Ponsel extends Perangkat {

    private final int kapasitasGb;
    private final int jumlahKamera;

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

    @Override
    public String infoSingkat() {
        return super.infoSingkat() + " | " + kapasitasGb + " GB | " + jumlahKamera + " kamera";
    }
}
