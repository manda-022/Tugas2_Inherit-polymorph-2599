package soal4;

import java.util.ArrayList;

/**
 * Menyimpan daftar produk belanja (composition) dan menghitung total, struk, serta rekap per jenis.
 */
public class Keranjang {

    private final ArrayList<Produk> daftarProduk = new ArrayList<>();

    /**
     * Menambahkan produk ke keranjang.
     *
     * @param produk produk yang ditambahkan, tidak boleh null
     * @throws IllegalArgumentException jika produk bernilai null
     * @throws IllegalStateException    jika kode produk sudah ada di keranjang
     */
    public void tambah(Produk produk) {
        if (produk == null) {
            throw new IllegalArgumentException("Produk tidak boleh null");
        }
        if (sudahAda(produk.getKode())) {
            throw new IllegalStateException("Kode produk sudah ada di keranjang: " + produk.getKode());
        }
        daftarProduk.add(produk);
    }

    private boolean sudahAda(String kode) {
        for (Produk produk : daftarProduk) {
            if (produk.getKode().equals(kode)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Menghitung total harga akhir seluruh produk. Perilaku tiap produk ditentukan
     * oleh polimorfisme, tanpa instanceof.
     *
     * @return total harga dalam rupiah
     */
    public double hitungTotal() {
        double total = 0;
        for (Produk produk : daftarProduk) {
            total += produk.hitungHargaAkhir();
        }
        return total;
    }

    /**
     * Mencetak struk: satu baris per produk lalu total. Tidak memakai instanceof.
     */
    public void cetakStruk() {
        for (Produk produk : daftarProduk) {
            System.out.println(produk.formatBarisStruk());
        }
        System.out.printf("TOTAL: Rp%.0f%n", hitungTotal());
    }

    /**
     * Mencetak jumlah produk fisik, digital, dan langganan. Langganan dicek lebih dulu
     * karena merupakan subclass ProdukDigital; urutan terbalik akan salah hitung.
     */
    public void hitungPerJenis() {
        int jumlahFisik = 0;
        int jumlahDigital = 0;
        int jumlahLangganan = 0;
        for (Produk produk : daftarProduk) {
            // instanceof sekaligus downcast aman: variabel hanya terbentuk jika tipenya cocok
            if (produk instanceof Langganan langganan) {
                jumlahLangganan++;
            } else if (produk instanceof ProdukDigital digital) {
                jumlahDigital++;
            } else if (produk instanceof ProdukFisik fisik) {
                jumlahFisik++;
            }
        }
        System.out.println("Fisik: " + jumlahFisik + ", Digital: " + jumlahDigital
                + ", Langganan: " + jumlahLangganan);
    }
}
