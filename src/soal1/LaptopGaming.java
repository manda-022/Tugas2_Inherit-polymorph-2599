package soal1;

/**
 * Merepresentasikan laptop gaming, yaitu laptop dengan kartu grafis dan garansi tambahan.
 * @author Hermanda Saputra
 */
public class LaptopGaming extends Laptop {

    private static final int GARANSI_TAMBAHAN_BULAN = 6;

    private final String kartuGrafis;

    public LaptopGaming(String merek, double harga, int garansiBulan, int ramGb,
                        double ukuranLayarInci, String kartuGrafis) {
        super(merek, harga, garansiBulan + GARANSI_TAMBAHAN_BULAN, ramGb, ukuranLayarInci);
        if (kartuGrafis == null || kartuGrafis.trim().isEmpty()) {
            throw new IllegalArgumentException("Kartu grafis tidak boleh kosong");
        }
        this.kartuGrafis = kartuGrafis;
    }

    @Override
    public String infoSingkat() {
        return super.infoSingkat() + " | GPU " + kartuGrafis;
    }
}
