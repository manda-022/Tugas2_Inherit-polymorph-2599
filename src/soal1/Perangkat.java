package soal1;

/**
 * Merepresentasikan satu perangkat elektronik yang dijual di toko.
 * Kelas ini menyimpan data dasar perangkat dan memastikan setiap
 * nilai yang disimpan lolos validasi.
 * @author Hermanda Saputra
 */
public class Perangkat {

    public static final double TARIF_PAJAK = 0.10;

    private final String merek;
    private final int garansiBulan;

    protected double harga;

    public Perangkat(String merek, double harga, int garansiBulan) {
        if (merek == null || merek.trim().isEmpty()) {
            throw new IllegalArgumentException("Merek tidak boleh kosong");
        }
        if (harga < 0) {
            throw new IllegalArgumentException("Harga tidak boleh negatif: " + harga);
        }
        if (garansiBulan < 0) {
            throw new IllegalArgumentException("Garansi tidak boleh negatif: " + garansiBulan);
        }
        this.merek = merek;
        this.harga = harga;
        this.garansiBulan = garansiBulan;
    }

    public String getMerek() {
        return merek;
    }

    public int getGaransiBulan() {
        return garansiBulan;
    }

    public double hitungPajak() {
        return harga * TARIF_PAJAK;
    }

    public String infoSingkat() {
        return merek + " | garansi " + garansiBulan + " bulan";
    }
}
