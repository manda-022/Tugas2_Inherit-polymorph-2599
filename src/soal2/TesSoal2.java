package soal2;

/**
 * Program uji Soal 2 Bagian A. Program ini SENGAJA berhenti dengan ClassCastException
 * pada downcast terakhir, supaya perilaku error tersebut bisa diamati langsung.
 * Perbaikan dengan instanceof ada di {@link TesSoal2Lanjutan}.
 */
public class TesSoal2 {

    /**
     * Titik masuk program uji Soal 2 Bagian A.
     *
     * @param args argumen command line (tidak dipakai)
     */
    public static void main(String[] args) {
        Hewan h = new Kucing("Tom");
        h.makan();
        h.suara();
        // h.panjat(); // error kompilasi: tipe statis Hewan tidak punya panjat()
        Kucing k = (Kucing) h;
        k.panjat();

        Hewan h2 = new Hewan("Generik");
        Kucing k2 = (Kucing) h2; // ClassCastException: objek aslinya Hewan, bukan Kucing
        k2.panjat();
    }
}
