package soal2;

/**
 * Subclass dari {@link A} yang punya field nilai dan meng-override init().
 */
public class B extends A {

    private static final int NILAI_AWAL = 5;

    private int nilai = NILAI_AWAL;

    /**
     * Membuat objek B. Constructor A dijalankan lebih dulu, sebelum field nilai diisi.
     */
    public B() {
        super();
        System.out.println("B dibuat, nilai=" + nilai);
    }

    /**
     * Mencetak pesan inisialisasi milik B beserta nilai saat ini.
     */
    @Override
    public void init() {
        System.out.println("init B, nilai=" + nilai);
    }
}
