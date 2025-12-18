
import java.util.ArrayList; //  Arraylist sinifini kullanabilmek 

public class OyunVerisi {
    // Bu sinif Arraylist seklinde karakterlerin ve sanslarin olusmasini saglar.

    private ArrayList<Sovalye> sovalyeler;
    private ArrayList<Sovalye> aktifSovalyeler;
    private ArrayList<Dusman> dusmanlar;
    private ArrayList<Dusman> aktifDusmanlar;
    private ArrayList<Sans> sanslar;

    public OyunVerisi() {
        // Parametresiz constructor ile arraylistler referanslara baglanir.
        this.sovalyeler = new ArrayList<Sovalye>();
        this.aktifSovalyeler = new ArrayList<Sovalye>();
        this.dusmanlar = new ArrayList<Dusman>();
        this.aktifDusmanlar = new ArrayList<Dusman>();
        this.sanslar = new ArrayList<Sans>();
    }

    public OyunVerisi(ArrayList<Sovalye> sovalyeler, ArrayList<Sovalye> aktifSovalyeler, ArrayList<Dusman> dusmanlar, ArrayList<Dusman> aktifDusmanlar, ArrayList<Sans> sanslar) {
        // parametreli constructor tanimlamasi
        this.sovalyeler = sovalyeler;
        this.aktifSovalyeler = aktifSovalyeler;
        this.dusmanlar = dusmanlar;
        this.aktifDusmanlar = aktifDusmanlar;
        this.sanslar = sanslar;
    }
    // Arraylistler icin daha onceden tanimlanan siniflar veri tipi olarak kullanildi ve getter metotlari cagirildi.

    public ArrayList<Sovalye> getSovalyeler() {
        return sovalyeler;
    }

    public ArrayList<Sovalye> getAktifSovalyeler() {
        return aktifSovalyeler;
    }

    public ArrayList<Dusman> getDusmanlar() {
        return dusmanlar;
    }

    public ArrayList<Dusman> getAktifDusmanlar() {
        return aktifDusmanlar;
    }

    public ArrayList<Sans> getSanslar() {
        return sanslar;
    }
}
