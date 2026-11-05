package soal1;

/**
 * Program uji Soal 1: membuat tiga jenis perangkat lalu mencetak ringkasan, pajak, dan harga promo.
 */
public class TesSoal1 {

    private static final double DISKON_PROMO_PERSEN = 10;

    /**
     * Titik masuk program uji Soal 1.
     *
     * @param args argumen command line (tidak dipakai)
     */
    public static void main(String[] args) {
        Laptop laptop = new Laptop("Asus", 8000000, 24, 16, 14.0);
        Ponsel ponsel = new Ponsel("Samsung", 5000000, 12, 128, 3);
        LaptopGaming laptopGaming = new LaptopGaming("MSI", 15000000, 12, 32, 15.6, "RTX 4060");

        System.out.println(laptop.infoSingkat());
        System.out.println(ponsel.infoSingkat());
        System.out.println(laptopGaming.infoSingkat());
        System.out.printf("Pajak laptop: Rp%.0f%n", laptop.hitungPajak());
        System.out.printf("Promo laptop 10 persen: Rp%.0f%n", laptop.hitungHargaPromo(DISKON_PROMO_PERSEN));

        coba("Harga negatif", () -> new Ponsel("Xiaomi", -1, 12, 64, 2));
        coba("Merek kosong", () -> new Laptop("  ", 1000000, 12, 8, 14.0));
    }

    /**
     * Menjalankan pembuatan objek yang diharapkan gagal, lalu mencetak pesan exception-nya.
     *
     * @param skenario nama skenario uji
     * @param aksi     aksi yang diharapkan melempar IllegalArgumentException
     */
    private static void coba(String skenario, Runnable aksi) {
        try {
            aksi.run();
        } catch (IllegalArgumentException e) {
            System.out.println("Gagal (" + skenario + "): " + e.getMessage());
        }
    }
}
