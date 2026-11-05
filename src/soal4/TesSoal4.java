package soal4;

/**
 * Program uji Soal 4: mengisi keranjang, mencetak struk, rekap per jenis, dan menguji kode duplikat.
 */
public class TesSoal4 {

    /**
     * Titik masuk program uji Soal 4.
     *
     * @param args argumen command line (tidak dipakai)
     */
    public static void main(String[] args) {
        Keranjang keranjang = new Keranjang();
        keranjang.tambah(new ProdukFisik("F01", "Keyboard Mekanik", 500000, 1.5));
        keranjang.tambah(new ProdukDigital("D01", "Ebook Java", 100000, 20));
        keranjang.tambah(new Langganan("L01", "Kelas Online", 150000, 20, 12));
        keranjang.cetakStruk();
        keranjang.hitungPerJenis();

        try {
            keranjang.tambah(new ProdukFisik("F01", "Mouse", 100000, 0.2));
        } catch (IllegalStateException e) {
            System.out.println("Gagal: " + e.getMessage());
        }

        try {
            new ProdukDigital("D02", "", 50000, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Gagal: " + e.getMessage());
        }
    }
}
