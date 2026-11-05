package soal2;

/**
 * Merepresentasikan kucing, yaitu hewan yang bersuara "meong" dan bisa memanjat.
 */
public class Kucing extends Hewan {

    /**
     * Membuat kucing baru dan mencetak pesan pembuatan.
     *
     * @param nama nama kucing
     */
    public Kucing(String nama) {
        super(nama);
        System.out.println("Kucing dibuat");
    }

    /**
     * Mencetak suara kucing.
     */
    @Override
    public void suara() {
        System.out.println("meong");
    }

    /**
     * Mencetak aktivitas memanjat. Method ini hanya dimiliki Kucing, tidak ada di Hewan.
     */
    public void panjat() {
        System.out.println(nama + " memanjat");
    }
}
