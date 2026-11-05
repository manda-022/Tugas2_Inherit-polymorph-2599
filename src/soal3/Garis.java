package soal3;

/**
 * Merepresentasikan garis lurus yang tersusun dari dua objek {@link Titik} (composition).
 * Titik yang diterima dan dikembalikan selalu disalin (defensive copy) agar isi Garis
 * tidak berubah oleh objek di luar kelas ini.
 */
public class Garis {

    private Titik awal;
    private Titik akhir;

    /**
     * Membuat garis dari dua titik. Kedua titik disalin sehingga perubahan pada
     * objek asli tidak memengaruhi garis.
     *
     * @param awal  titik awal, tidak boleh null
     * @param akhir titik akhir, tidak boleh null
     * @throws IllegalArgumentException jika salah satu titik bernilai null
     */
    public Garis(Titik awal, Titik akhir) {
        this.awal = new Titik(awal);
        this.akhir = new Titik(akhir);
    }

    /**
     * Membuat garis dari koordinat dua titik. Memanfaatkan constructor utama lewat this(...).
     *
     * @param x1 koordinat x titik awal
     * @param y1 koordinat y titik awal
     * @param x2 koordinat x titik akhir
     * @param y2 koordinat y titik akhir
     */
    public Garis(double x1, double y1, double x2, double y2) {
        this(new Titik(x1, y1), new Titik(x2, y2));
    }

    /**
     * Mengambil salinan titik awal.
     *
     * @return salinan titik awal
     */
    public Titik getAwal() {
        return new Titik(awal);
    }

    /**
     * Mengganti titik awal dengan salinan dari titik yang diberikan.
     *
     * @param awal titik awal baru, tidak boleh null
     * @throws IllegalArgumentException jika awal bernilai null
     */
    public void setAwal(Titik awal) {
        this.awal = new Titik(awal);
    }

    /**
     * Mengambil salinan titik akhir.
     *
     * @return salinan titik akhir
     */
    public Titik getAkhir() {
        return new Titik(akhir);
    }

    /**
     * Mengganti titik akhir dengan salinan dari titik yang diberikan.
     *
     * @param akhir titik akhir baru, tidak boleh null
     * @throws IllegalArgumentException jika akhir bernilai null
     */
    public void setAkhir(Titik akhir) {
        this.akhir = new Titik(akhir);
    }

    /**
     * Menghitung panjang garis dengan memanggil {@link Titik#jarakKe(Titik)}.
     *
     * @return panjang garis
     */
    public double getPanjang() {
        return awal.jarakKe(akhir);
    }

    /**
     * Menyusun representasi teks garis.
     *
     * @return teks berformat (x1, y1) - (x2, y2)
     */
    @Override
    public String toString() {
        return awal + " - " + akhir;
    }
}
