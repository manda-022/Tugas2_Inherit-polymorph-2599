package soal2;

/**
 * Kelas dasar untuk demonstrasi bahaya memanggil method yang bisa di-override dari dalam constructor.
 */
public class A {

    /**
     * Membuat objek A. Constructor ini memanggil {@link #init()} yang bisa di-override,
     * sehingga versi subclass bisa berjalan sebelum field subclass terisi.
     */
    public A() {
        System.out.println("A dibuat");
        init();
    }

    /**
     * Mencetak pesan inisialisasi milik A.
     */
    public void init() {
        System.out.println("init A");
    }
}
