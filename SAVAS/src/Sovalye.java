public class Sovalye extends Karakterler {
    // Sovalye sinifi Karakterler sinifini miras alan bir siniftir. Sovalye sinifi subclass ike Karakterler sinifi superclassdir.
    // Karakterler sinifindan farkli olarak Sovalye sinifinin sahip oldugu ozellikler sinif degiskeni olarak tanimlandi.
    private int vurusHakki;
    private Sans sans;
    private String sovalyeTipi;

    public Sovalye(String ad, int id) {
        // Sovalye sinifinin parametreli olarak constructoru tanimlandi.
        super(ad, id); // Miras alinan sınıfın constructoru "super" anahtar kelimesi ile cagirildi.
        this.vurusHakki = 1; // Her sovalyenin vurus hakki 1 olarak tanimlandi.
    }
    // Sinif degiskenlerinin getter ve setter metodlari tanimlandi.

    public int getVurusHakki() {
        return vurusHakki;
    }

    public void setVurusHakki(int vurusHakki) {
        this.vurusHakki = vurusHakki;
    }

    public void vur(Dusman dusman) {
        // Bu metot kiyaslama isleminin gerceklestirildigi kisimdir.Bu islem equals metotu ile yapildi.
        final String dusmanTipi = dusman.getDusmanTipi(); // Dusmanin tipi alindi.

        if (this.getSovalyeTipi().equals(Sabitler.GUCLU_TIP) && dusmanTipi.equals(Sabitler.ZAYIF_TIP)) {
            dusman.setAktif(false); // Eger sovalye guclu ve dusman zayif ise sovalye dusmani yenmis olur 
            // dusmanin aktifligi kaldirilmis olundu.
        }
        if (this.getSovalyeTipi().equals(Sabitler.ZAYIF_TIP) && dusmanTipi.equals(Sabitler.ZAYIF_TIP)) {
            dusman.setAktif(false);// Eger sovalye zayif ve dusman zayif ise yine sovalye dusmani yenmis olur
            // dusmanin aktifligi kaldirilmis olundu.
        }
        if (this.getSovalyeTipi().equals(Sabitler.GUCLU_TIP) && dusmanTipi.equals(Sabitler.GUCLU_TIP)) {
            dusman.setAktif(false); // Eger sovalye guclu ve dusman zayis ise sovalye dusmani yenmis olur
            // dusmanin aktifligi kaldirilmis olundu.
        }
        if (this.getSovalyeTipi().equals(Sabitler.ZAYIF_TIP) && dusmanTipi.equals(Sabitler.GUCLU_TIP)) {
            setAktif(false);// Eger ki sovalye zayif ve dusman guclu ise bu sefer dusman sovalyeyi yenmis olur 
            // sovalyenin aktifligi kaldirilmis olundu.
        }
    }

    public Sans getSans() {
        return sans;
    }

    public void setSans(Sans sans) {
        this.sans = sans;
    }

    public String getSovalyeTipi() {
        return sovalyeTipi;
    }

    public void setSovalyeTipi(String sovalyeTipi) {
        this.sovalyeTipi = sovalyeTipi;
    }

    @Override // toString metodunun ezildigi kisim
    public String toString() { // super. ifadesi ata sinifi ifade etmektedir.
        return super.toString() + ", Vuruş Hakkı: " + vurusHakki +
                ", Şans: " + sans +
                ", Şövalye Tipi: " + sovalyeTipi + '"';
    }
}
