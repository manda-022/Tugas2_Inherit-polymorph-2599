package soal1;

/**
 * Merepresentasikan laptop sebagai perangkat elektronik dengan RAM dan ukuran layar.
 * @author Hermanda Saputra
 */
public class Laptop extends Perangkat {

    private static final double PERSEN_PENUH = 100.0;

    private final int ramGb;
    private final double ukuranLayarInci;

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

    public double hitungHargaPromo(double diskonPersen) {
        if (diskonPersen < 0 || diskonPersen > PERSEN_PENUH) {
            throw new IllegalArgumentException("Diskon harus 0 sampai 100 persen: " + diskonPersen);
        }
        return harga - (harga * diskonPersen / PERSEN_PENUH);
    }

    @Override
    public String infoSingkat() {
        return super.infoSingkat() + " | RAM " + ramGb + " GB | layar " + ukuranLayarInci + " inci";
    }
}
