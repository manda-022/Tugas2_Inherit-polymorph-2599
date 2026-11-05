package soal3;

/**
 * Merepresentasikan satu titik pada bidang dua dimensi.
 */
public class Titik {

    private double x;
    private double y;

    /**
     * Membuat titik di koordinat asal (0, 0).
     */
    public Titik() {
        this(0, 0);
    }

    /**
     * Membuat titik pada koordinat tertentu.
     *
     * @param x koordinat x
     * @param y koordinat y
     */
    public Titik(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Membuat salinan baru dari titik lain (dipakai untuk defensive copy).
     *
     * @param lain titik yang disalin, tidak boleh null
     * @throws IllegalArgumentException jika lain bernilai null
     */
    public Titik(Titik lain) {
        this(validasiTidakNull(lain).x, lain.y);
    }

    private static Titik validasiTidakNull(Titik titik) {
        if (titik == null) {
            throw new IllegalArgumentException("Titik tidak boleh null");
        }
        return titik;
    }

    /**
     * Mengambil koordinat x.
     *
     * @return koordinat x
     */
    public double getX() {
        return x;
    }

    /**
     * Mengubah koordinat x.
     *
     * @param x koordinat x baru
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Mengambil koordinat y.
     *
     * @return koordinat y
     */
    public double getY() {
        return y;
    }

    /**
     * Mengubah koordinat y.
     *
     * @param y koordinat y baru
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Menghitung jarak Euclidean ke titik lain.
     *
     * @param lain titik tujuan, tidak boleh null
     * @return jarak antara titik ini dan titik lain
     * @throws IllegalArgumentException jika lain bernilai null
     */
    public double jarakKe(Titik lain) {
        validasiTidakNull(lain);
        return Math.hypot(lain.x - x, lain.y - y);
    }

    /**
     * Menyusun representasi teks titik.
     *
     * @return teks berformat (x, y)
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
