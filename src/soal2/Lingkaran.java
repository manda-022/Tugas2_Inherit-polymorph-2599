package soal2;

/**
 * Merepresentasikan lingkaran dengan jari-jari tertentu.
 */
public class Lingkaran {

    private static final double FAKTOR_KELILING = 2;

    private final double jariJari;

    /**
     * Membuat lingkaran baru.
     *
     * @param jariJari jari-jari lingkaran, tidak boleh negatif
     * @throws IllegalArgumentException jika jari-jari negatif
     */
    public Lingkaran(double jariJari) {
        if (jariJari < 0) {
            throw new IllegalArgumentException("Jari-jari tidak boleh negatif: " + jariJari);
        }
        this.jariJari = jariJari;
    }

    /**
     * Mengambil jari-jari lingkaran.
     *
     * @return jari-jari lingkaran
     */
    public double getJariJari() {
        return jariJari;
    }

    /**
     * Menghitung luas lingkaran.
     *
     * @return luas lingkaran
     */
    public double luas() {
        return Math.PI * jariJari * jariJari;
    }

    /**
     * Menghitung keliling lingkaran.
     *
     * @return keliling lingkaran
     */
    public double keliling() {
        return FAKTOR_KELILING * Math.PI * jariJari;
    }
}
