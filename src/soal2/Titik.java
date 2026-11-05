package soal2;

/**
 * Titik sebagai subclass {@link Lingkaran} dengan jari-jari 0.
 * Dipakai untuk membahas apakah relasi is-a ini masuk akal secara desain.
 */
public class Titik extends Lingkaran {

    private static final double JARI_JARI_TITIK = 0;
    private static final double UKURAN_TITIK = 0.0;

    /**
     * Membuat titik, yaitu lingkaran berjari-jari 0.
     */
    public Titik() {
        super(JARI_JARI_TITIK);
    }

    /**
     * Mengembalikan luas titik.
     *
     * @return selalu 0.0
     */
    @Override
    public double luas() {
        return UKURAN_TITIK;
    }

    /**
     * Mengembalikan keliling titik.
     *
     * @return selalu 0.0
     */
    @Override
    public double keliling() {
        return UKURAN_TITIK;
    }
}
