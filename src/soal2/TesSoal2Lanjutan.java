package soal2;

/**
 * Program uji Soal 2 Bagian A (versi perbaikan dengan instanceof), Bagian B, dan Bagian C.
 */
public class TesSoal2Lanjutan {

    /**
     * Titik masuk program uji lanjutan Soal 2.
     *
     * @param args argumen command line (tidak dipakai)
     */
    public static void main(String[] args) {
        System.out.println("=== Bagian A (perbaikan instanceof) ===");
        jalankanBagianAPerbaikan();
        System.out.println("=== Bagian B ===");
        new B();
        System.out.println("=== Bagian C ===");
        jalankanBagianC();
    }

    /**
     * Mendemonstrasikan downcast aman pada h2 tanpa mengubah tipe variabelnya.
     */
    private static void jalankanBagianAPerbaikan() {
        Hewan h2 = new Hewan("Generik");
        if (h2 instanceof Kucing) {
            Kucing k2 = (Kucing) h2;
            k2.panjat();
        } else {
            System.out.println("h2 bukan Kucing, downcast dibatalkan");
        }
    }

    /**
     * Mendemonstrasikan polimorfisme pada Lingkaran dan Titik.
     */
    private static void jalankanBagianC() {
        Lingkaran l1 = new Lingkaran(5);
        Titik l2 = new Titik();
        Lingkaran l3 = new Titik();
        System.out.println(l1.luas());
        System.out.println(l2.luas());
        System.out.println(l3.luas());
    }
}
