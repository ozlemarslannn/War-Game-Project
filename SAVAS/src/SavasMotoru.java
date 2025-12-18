
import java.util.ArrayList; // Arraylist sinifinin kullanilabilmesi icin import edildi.
import java.util.Random; // Rastgele sayi uretilebilmesi icin import edildi.
import java.util.Scanner; // Kullanicidan input almak icin import edildi.

public class SavasMotoru {
    // Bu constructor icinde sovalye sayisi sabit olarak verildi.
    // Aktif sovalye sayisi 5 olarak alindi.
    // Sovalyelerin id numaralari sabit 100 olarak atandi daha sonra her bir yeni sovalye uretildiginde bu sayi rastgele olarak degistirlidi.

    private static final int SOVALYE_SAYISI = 10;
    private static int AKTIFLESTIRILECEK_SOVALYE_SAYISI = 5;
    private static int COUNTER = 100;
    private static boolean OZEL_ISIM_KULLANILSIN_MI = false; // eger bunu true ya cevirirsen sovalye ve dusman isimlerini kullanicinin girmesini saglar.
    private String isim = "";

    // nesneler uretildi.
    Scanner scanner = new Scanner(System.in);
    OyunVerisi oyunVerisi = new OyunVerisi();
    Random rastgele = new Random();

    public SavasMotoru() {
        // metotlar uygun parametede cagirildi
        // Constructor tanimlamasi yapildi.
        sovalyeleriUret(oyunVerisi, scanner, rastgele);
        dusmanlariUret(oyunVerisi, scanner, rastgele);
    }

    public OyunVerisi getOyunVerisi() {
        return oyunVerisi;
    }

    public void sovalyeleriUret(OyunVerisi oyunVerisi, Scanner scanner, Random rastgele) {
        try { // hata yakalama mekanizmasi kuruldu. İslemler bu mekanizma icinde yapilacaktir.
            Sovalye sovalye = null;
            // Sovalyelerin ozellikleri isimleri olusturuldu.
            // Dongu yukarida tanimlanan 10 sovalye sayisi kadar ilerler.
            for (int i = 0; i < SOVALYE_SAYISI; i++) {
                if (rastgele.nextInt(2) == 1) { // If random number is 1, then it should be GUCLU_TIP
                    if (OZEL_ISIM_KULLANILSIN_MI) {
                        System.out.println(Sabitler.SOVALYE_KARAKTER + Sabitler.ISIM_ISTEME_MESAJI);
                        isim = scanner.nextLine();
                    } else {
                        isim = Sabitler.SOVALYE_KARAKTER;
                    }
                    sovalye = new GucluSovalye(isim, COUNTER++); // yeni bir sovalye olusturuldugunda sovalye id numarasi 1 arttirilir.
                    sovalye.setSovalyeTipi(Sabitler.GUCLU_TIP);
                } else { // zayif tipli sovalye icin
                    if (OZEL_ISIM_KULLANILSIN_MI) {
                        System.out.println(Sabitler.SOVALYE_KARAKTER + Sabitler.ISIM_ISTEME_MESAJI);
                        isim = scanner.nextLine();
                    } else {
                        isim = Sabitler.SOVALYE_KARAKTER;
                    }
                    sovalye = new ZayifSovalye(isim, COUNTER++);
                    sovalye.setSovalyeTipi(Sabitler.ZAYIF_TIP);
                }
                sovalye.setSans(new Sans());
                if (Sabitler.DEBUG_MOD) {// yazilan kodun adim adim calismani kontrol edebilmek icin debug kullanilidi.
                    System.out.println("Üretilen şövalye => " + sovalye.toString());
                }
                oyunVerisi.getSovalyeler().add(sovalye);
            }
        } catch (Exception exception) {//  hatayi yakalama kismi 
            if (Sabitler.DEBUG_MOD) {
                System.out.println(exception);// ekrana hata mesajini yazdirir.
            }
        }

        try {
            ArrayList<Sovalye> gucluSovalyeler = new ArrayList<Sovalye>();
            ArrayList<Sovalye> zayifSovalyeler = new ArrayList<Sovalye>();

            // Kim güçlü, kim güçsüz anlamak için listeleri dolduruyoruz
           
            for (int i = 0; i < oyunVerisi.getSovalyeler().size(); i++) {
                if (oyunVerisi.getSovalyeler().get(i).getSovalyeTipi().equals(Sabitler.GUCLU_TIP)) {
                    Sovalye gucluSovalye = oyunVerisi.getSovalyeler().get(i);
                    gucluSovalyeler.add(gucluSovalye);
                }
                if (oyunVerisi.getSovalyeler().get(i).getSovalyeTipi().equals(Sabitler.ZAYIF_TIP)) {
                    Sovalye zayifSovalye = oyunVerisi.getSovalyeler().get(i);
                    zayifSovalyeler.add(zayifSovalye);
                }
            }

            // maksimum 2 tane guclu sovalye olusmasi icin asagidaki islem yapildi.
            int kacTaneGucluOlacak = rastgele.nextInt(2) + 1;
            int kacTaneZayifOlacak = AKTIFLESTIRILECEK_SOVALYE_SAYISI - kacTaneGucluOlacak;
            int gucluSovalyelerinSayisi = gucluSovalyeler.size();
            int zayifSovalyelerinSayisi = zayifSovalyeler.size();

            if (Sabitler.DEBUG_MOD) { // tum sovalyelerin guclu olmamasi icin 
                System.out.println("Kaç tane güçlü olacak? => " + kacTaneGucluOlacak);
                System.out.println("Kaç tane zayıf olacak? => " + kacTaneZayifOlacak);
                System.out.println("Güçlü şövalyelerin sayısı nedir? => " + gucluSovalyelerinSayisi);
                System.out.println("Zayıf şövalyelerin sayısı nedir? => " + zayifSovalyelerinSayisi);
            }

            while (kacTaneGucluOlacak > 0) {
                int rastgeleSayi = rastgele.nextInt(gucluSovalyelerinSayisi);
                Sovalye sovalye = gucluSovalyeler.get(rastgeleSayi);
                if (!sovalye.isAktif()) { // rastgele alinan sovalye aktif degilmi diye kontrol eder
                    sovalye.setAktif(true); // eger degilse onu aktiflestirir.
                    oyunVerisi.getAktifSovalyeler().add(sovalye);
                    kacTaneGucluOlacak--;
                }
            }

            while (kacTaneZayifOlacak > 0) {
                int rastgeleSayi = rastgele.nextInt(zayifSovalyelerinSayisi);
                Sovalye sovalye = zayifSovalyeler.get(rastgeleSayi);
                if (!sovalye.isAktif()) { // zayif sovalye aktif mi diye kontrol eder.
                    sovalye.setAktif(true); // eger aktif degilse aktiflestirir.
                    oyunVerisi.getAktifSovalyeler().add(sovalye);
                    kacTaneZayifOlacak--; // tamaminin zayif sovalye olmamasi ıcın zayif sovalye sayisi azaltilir.
                }
            }

        } catch (Exception exception) { // hata yakalama kismi
            System.out.println("Bazı şeyler galiba ters gitti :(");
        }
    }

    public void dusmanlariUret(OyunVerisi oyunVerisi, Scanner scanner, Random rastgele) {
        int minimum = 3; // en az 3 dusman
        int maksimum = 5; // en fazla 5 dusman 
        int dusmanSayisi = rastgele.nextInt((maksimum - minimum) + 1) + minimum; // rastgele 3 ile 5 arasinda dusman olusacak

        try {
            Dusman dusman = null;
            for (int i = 0; i < dusmanSayisi; i++) {
                if (rastgele.nextInt(2) == 1) { // rastgele uretilen sayi 1 ise guclu dusman 
                    if (OZEL_ISIM_KULLANILSIN_MI) {
                        System.out.println(Sabitler.DUSMAN_KARAKTER + Sabitler.ISIM_ISTEME_MESAJI);
                        isim = scanner.nextLine();
                    } else {
                        isim = Sabitler.DUSMAN_KARAKTER;
                    }
                    dusman = new GucluDusman(isim, COUNTER++);
                    dusman.setDusmanTipi(Sabitler.GUCLU_TIP);
                } else { // degilse zayif dusman olusturulur.
                    if (OZEL_ISIM_KULLANILSIN_MI) {
                        System.out.println(Sabitler.DUSMAN_KARAKTER + Sabitler.ISIM_ISTEME_MESAJI);
                        isim = scanner.nextLine();
                    } else {
                        isim = Sabitler.DUSMAN_KARAKTER;
                    }
                    dusman = new ZayifDusman(isim, COUNTER++); // id numarasi yeni dusman olusturuldukca arttirilir.
                    dusman.setDusmanTipi(Sabitler.ZAYIF_TIP);
                }
                dusman.setAktif(true); // dusman aktiflestirlir.
                if (Sabitler.DEBUG_MOD) {
                    System.out.println("Üretilen düşman => " + dusman.toString());
                }
                oyunVerisi.getDusmanlar().add(dusman); // arrayliste dusman eklenir.
            }
        } catch (Exception exception) { // hata yakalama kismi
            if (Sabitler.DEBUG_MOD) {
                System.out.println(exception); // hata bulundugu takdirde ekrana mesaj bastirilir.
            }
        }
    }
}