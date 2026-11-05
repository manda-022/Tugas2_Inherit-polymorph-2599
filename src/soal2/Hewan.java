package soal2;

/**
 * Merepresentasikan hewan umum yang punya nama, bisa bersuara, dan bisa makan.
 */
public class Hewan {

    /** Nama hewan; protected agar bisa dipakai subclass. */
    protected String nama;

    /**
     * Membuat hewan baru dan mencetak pesan pembuatan.
     *
     * @param nama nama hewan
     */
    public Hewan(String nama) {
        this.nama = nama;
        System.out.println("Hewan dibuat: " + nama);
    }

    /**
     * Mencetak suara hewan. Subclass dapat meng-override method ini.
     */
    public void suara() {
        System.out.println("...");
    }

    /**
     * Mencetak aktivitas makan, lalu memanggil {@link #suara()}.
     * Suara yang keluar mengikuti tipe dinamis objek (polimorfisme).
     */
    public void makan() {
        System.out.println(nama + " makan");
        suara();
    }
}
