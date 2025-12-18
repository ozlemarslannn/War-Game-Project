
public class Karakterler {
    // Sinif degişkenleri tanımlandi.Bu degiskenler sovalye ve dusmanlarda ortak olarak bulunan ozelliklerdir.

    private String ad; 
    private int id; // Karakterlere atanann id numaralari 
    private boolean aktif; // Oyun baslatildiginda bazi karakterlerin aktiflesmesi icin 

    public Karakterler(String ad, int id) {
        // Constructor tanimlandi.  
        this.ad = ad;
        this.id = id;
    }
    // Sinif degiskenlerinin getter ve setter metotlari tanimlandi.
    

    public boolean isAktif() {
        return aktif;
    }

    public void setAktif(boolean aktif) {
        this.aktif = aktif;
    }

    public String getAd() {
        return ad;
    }

    public int getId() {
        return id;
    }

    @Override
    // toString metodunun ezme islemi gerceklestirildi.
    public String toString() {
        // Karakterler sinifinin degiskenleri return edilerek ekrana yazdirildi.
        return "Ad: " + ad + ", Id:" + id + " , Aktif: " + aktif;
    }
}
