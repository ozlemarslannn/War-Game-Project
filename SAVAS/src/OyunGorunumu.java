
import java.util.ArrayList; // ArrayList sinifinin kullanilabilmesi icin import edilmesi gereklidir.
import java.util.Scanner; // Kullanicidan veri almak icin Scanner sinifinin import edilemsi gereklidir.

public class OyunGorunumu {
    // Sinif degiskenleri tanimlandi.
    private OyunVerisi oyunVerisi; // OyunVerisi sinifindan bir nesne
    private SavasMotoru savasMotoru; // SavasMotoru sinifindan bir nesne
    private int secim;
    private Scanner scanner = new Scanner(System.in);// Kullanicidan veri alinmasi icin

    public OyunGorunumu() {
        // Bu sinifin constructoru SavasMotoru sinifindan nesne olusturur.
        this.savasMotoru = new SavasMotoru();
    }

    public void baslangicEkrani() {
        // Oyunun gorunumu konsol acildiginda birtakim mesajlarin yazdirilmasini saglar.
        // Sabitler sinifinda 'static final' olarak tanimlanan degiskenler System.out.println ile ekrana yazdirildi.
        System.out.println(Sabitler.YILDIZLAR);
        System.out.println(Sabitler.HOS_GELDIN_MESAJI);
        System.out.println(Sabitler.YILDIZLAR);
    }

    public void anaMenuyuGoster() {
        // Bu metod oyunun ana menusunun gosterilmesini saglar.
        // Sabitler sinifinda 'static final' olarak tanimlanan degiskenler System.out.println ile ekrana yazdirildi.
        System.out.println(Sabitler.ANA_MENU_LISTESI);
        System.out.println(Sabitler.YILDIZLAR);
        menudenSecimYap(); // Menüden secim yapilabilmesi icin sonsuz bir dongu yapisi kuruldu.
        // Bu dongu kullanicinin 7 sayisini secmesi takdirde sonlanacaktir.
        while (true) {
            if (secim == 1) { // Eger kullanici 1 sayisini secerse tüm sovalye havuzu gosterilir.
                sovalyeleriGoster();
            } else if (secim == 2) { // Eger kullanici 2 sayisini secerse aktif sovalye havuzu gosterilir.
                aktifSovalyeleriGoster();
            } else if (secim == 3) { //  Eger kullanici 3 sayisini secerse kullaniciya hangi sovalyeyi sectigi sorulur ve secilan sovalyenin bilgileri ekrana yazdirilir.
                System.out.println(Sabitler.SOVALYE_ID_ISTEME_MESAJI);
                int sovalyeAdi = scanner.nextInt();
                sovalyeyiGoster(sovalyeAdi);
            } else if (secim == 4) {
                // Sovalyeleri degistirme kismi
            } else if (secim == 5) { // Eger kullanici 5 sayisini secerse oyun hakkinda kisa bir bilgilendirme mesaji yazdirilir.
                yardim();
            } else if (secim == 6) { // Eger kullanici 6 sayisini secerse oyun baslatilacaktir.

                ArrayList<Sovalye> aktifSovalyeler = savasMotoru.oyunVerisi.getAktifSovalyeler(); // lokal değişken aktifSovalyeler cagirilir
                ArrayList<Dusman> dusmanlar = savasMotoru.oyunVerisi.getDusmanlar(); // lokal değişken dusmanlar cagirilir

                // Kullanıcıdan daha düzgün input almak için aktif şövalyelerin id'sini belirliyoruz ki input alırken karşılaştırabilelim.
                ArrayList<Integer> aktifSovalyelerinIdsi = aktifSovalyelerIdListesiniTazele(aktifSovalyeler);

                // Kullanıcıdan daha düzgün input almak için düşmanların id'sini belirliyoruz ki input alırken karşılaştırabilelim.
                ArrayList<Integer> dusmanlarinIdsi = dusmanlarIdListesiniTazele(dusmanlar);

                while (aktifSovalyeler.size() > 0) { // Bu dongu aktif sovalye sayisi kadar tekrar eder.
                    // Dusmanlar ve sovalyeler ekranda metotlar sayesinde gosterilir.
                    aktifSovalyeleriGoster();
                    dusmanlariGoster();
                    // Sabitler sinifi kullanilarak ekrana yazilar yazdirilir.
                    System.out.println(Sabitler.SOVALYE_ID_ISTEME_MESAJI);
                    int secilenSovalyeId = scanner.nextInt();
                    boolean tekrarSovalyeIdsiAlinsinMi = false; // Eger alinan sovalye sayisi tekrar alinirsa false cevrilir.
                    // Kullanicidan alinan sovalyenin indisi aktif sovalye indislerinin bulundugu integer arraylistin icinde var mi diye contains metotu kontrol eder.
                    // if kosulu alinan indisin arraylistin icinde bulunmadıgı surece gerceklesir.
                   
                    if (!aktifSovalyelerinIdsi.contains(secilenSovalyeId)) {
                        tekrarSovalyeIdsiAlinsinMi = true; // tekrar kullanicidan indis numarasi alinir.
                    }

                    while (tekrarSovalyeIdsiAlinsinMi) {
                        System.out.println(Sabitler.SOVALYE_ID_TEKRAR_ISTEME_MESAJI);
                        secilenSovalyeId = scanner.nextInt();
                        if (aktifSovalyelerinIdsi.contains(secilenSovalyeId)) { // Eger alinan indis sayisi arraylistin icinde varsa tekrar kullanicidan sayi alinmaz.
                            
                            tekrarSovalyeIdsiAlinsinMi = false; // tekrar sayi alinmaz 
                        }
                    }

                    System.out.println(Sabitler.HEDEFTEKI_DUSMAN_ID_ISTEME_MESAJI);
                    int hedefDusmanId = scanner.nextInt(); // Dusmanin indisi alinir
                    boolean tekrarHedeftekiDusmanIdsiAlinsinMi = false;

                    if (!dusmanlarinIdsi.contains(hedefDusmanId)) { // Yukaridaki sovalye indisi alma islemi dusman indisleri icinde tekrarlanilir.
                        tekrarHedeftekiDusmanIdsiAlinsinMi = true;
                    }

                    while (tekrarHedeftekiDusmanIdsiAlinsinMi) {
                        System.out.println(Sabitler.HEDEFTEKI_DUSMAN_ID_TEKRAR_ISTEME_MESAJI);
                        hedefDusmanId = scanner.nextInt();
                        if (dusmanlarinIdsi.contains(hedefDusmanId)) {
                            tekrarHedeftekiDusmanIdsiAlinsinMi = false;
                        }
                    }

                    Sovalye secilenSovalye = null;
                    Dusman hedeftekiDusman = null;

                    for (int i = 0; i < aktifSovalyeler.size(); i++) { // Arrayliste ki aktif sovalye sayisi kadar devam eder.
                        if (aktifSovalyeler.get(i).getId() == secilenSovalyeId) {
                            secilenSovalye = aktifSovalyeler.get(i); 
                            // secilen sovalye aktif sovalye ise dongu break ile kirilir.
                            break;
                        }
                    }

                    for (int i = 0; i < dusmanlar.size(); i++) { // Dongu dusmanlar arraylistin uzunlugu boyunca devam eder.
                        if (dusmanlar.get(i).getId() == hedefDusmanId) {
                            hedeftekiDusman = dusmanlar.get(i);
                            // secilen dusman ıd numarasi dusmanlar ıd ile ayni ise dongu break ile kirilir.
                            break;
                        }
                    }

                    secilenSovalye.vur(hedeftekiDusman); 
                    // Sovalye sinifinda tanimlanan vur metodu cagirilir ve savas gerceklestirilir.

                    savasMotoru.oyunVerisi.getAktifSovalyeler().remove(secilenSovalye);
                    // savasan sovalye yense de yenilse de arraylisten silinir
                    aktifSovalyeler.remove(secilenSovalye);
                    // Aktif sovalyelerin tutuldugu arraylist tekrardan duzenlenilir.
                    aktifSovalyelerinIdsi = aktifSovalyelerIdListesiniTazele(aktifSovalyeler);

                    if (hedeftekiDusman.isAktif() != true) {// yukarida yapilan islemler dusmanlar icinde gerceklestirilir.
                        savasMotoru.oyunVerisi.getDusmanlar().remove(hedeftekiDusman);
                        dusmanlar.remove(hedeftekiDusman);
                        dusmanlarinIdsi = dusmanlarIdListesiniTazele(dusmanlar);
                        System.out.println(Sabitler.HEDEF_VURULDU_MESAJI);
                    }

                    // Eğer şövalyeler kaybederse "aktifSovalyeSayisi" 0 olacağı için while-loop kırılıp sonlanacak
                    if (aktifSovalyeler.size() == 0) {
                        break;
                    }

                    // Eğer düşmanlar kaybederse bu if'in içerisine girip while-loop kırılıp sonlanacak
                    if (dusmanlar.size() == 0) {
                        break;
                    }
                }
                oyunDurumunuGoster();
            } else if (secim == 7) { // Kullanici 7 sayisini secerse oyundan cıkılacak.
                System.out.println(Sabitler.AYRILIK_MESAJI);
                break;
            } else {
                System.out.println(Sabitler.HATALI_HAMLE_MESAJI);
                // Kullanici uygun olmayan secimde bulunursa bilgi mesaji verilecek
                
            }
            menudenSecimYap(); // tekrardan menu secimi yapilabilmesi icin metot cagirildi.
        }
    }

    public void yardim() { // Yardim secenegi secildiginde ekrana yazdirilacak olan mesajin metodu tanimlandi.
        System.out.println(Sabitler.YARDIM_MESAJI);
    }

    public void sovalyeleriGoster() {
        ArrayList<Sovalye> sovalyeler = savasMotoru.oyunVerisi.getSovalyeler();
        for (Sovalye sovalye : sovalyeler) { // for each dongu yapisi kullanildi.
            System.out.println(sovalye.toString());// tum sovalye sinifinda olusan nesneler uzerinde dongu dolsir.
        }
    }

    public void aktifSovalyeleriGoster() {
        // Aktif sovalyelerin tutulup yazdirildigi metot.
        ArrayList<Sovalye> aktifSovalyeler = savasMotoru.oyunVerisi.getAktifSovalyeler();
        for (Sovalye sovalye : aktifSovalyeler) {
            System.out.println(Sabitler.YILDIZLAR);
            System.out.println("Şövalye adı: " + sovalye.getAd());
            System.out.println("Şövalye tipi: " + sovalye.getSovalyeTipi());
            System.out.println("Şövalye id: " + sovalye.getId());
            System.out.println("Şövalye id: " + sovalye.getVurusHakki());
            System.out.println(Sabitler.YILDIZLAR);
        }
    }

    public void dusmanlariGoster() {
        // Dusmanlarin tutulup ekrana yazdirildigi metot.
        ArrayList<Dusman> dusmanlar = savasMotoru.oyunVerisi.getDusmanlar();
        for (Dusman dusman : dusmanlar) {
            System.out.println(Sabitler.YILDIZLAR);
            System.out.println("Düşman adı: " + dusman.getAd() + " " + dusman.getId());
            System.out.println(Sabitler.YILDIZLAR);
        }
    }

    public void menudenSecimYap() {
        // Ana menuden secim yapilmasi icin cagrilan metot.
        System.out.println(Sabitler.SECIM_YAP_MESAJI);
        secim = scanner.nextInt();// kullanicidan sayi alinir ve secim yapitirilir.
    }
    // Sovalyeleri gosterme ekrana yazdirma metotu 

    public void sovalyeyiGoster(int sovalyeKarakterininIdsi) {
        ArrayList<Sovalye> sovalyeler = savasMotoru.oyunVerisi.getSovalyeler();
        for (int i = 0; i < sovalyeler.size(); i++) {
            if (sovalyeler.get(i).getId() == sovalyeKarakterininIdsi) {
                System.out.println(sovalyeler.get(i).toString());
                break;// ayni indes de ise sovalye bulunur ve dongu kirilir.
            }
        }
    }

    public void oyunDurumunuGoster() {
        // Oyun sona geldiginde oyunun sonlandirilmasi mesajini gosterme metotu tanimlandi.
        if (savasMotoru.oyunVerisi.getAktifSovalyeler().size() == 0) {
            System.out.println(Sabitler.OYUNU_KAYBETTINIZ_MESAJI);
        } else {
            System.out.println(Sabitler.OYUNU_KAZANDINIZ_MESAJI);
        }
    }

    public ArrayList<Integer> aktifSovalyelerIdListesiniTazele(ArrayList<Sovalye> aktifSovalyeler) {
        ArrayList<Integer> aktifSovalyelerinIdsi = new ArrayList<Integer>();
        for (int i = 0; i < aktifSovalyeler.size(); i++) {
            int sovalyeId = aktifSovalyeler.get(i).getId();
            aktifSovalyelerinIdsi.add(sovalyeId);
        }
        return aktifSovalyelerinIdsi;
        
        // Dusmanlar listesi duzenlenir.
    }

    public ArrayList<Integer> dusmanlarIdListesiniTazele(ArrayList<Dusman> dusmanlar) {
        ArrayList<Integer> dusmanlarinIdsi = new ArrayList<Integer>();
        for (int i = 0; i < dusmanlar.size(); i++) {
            int dusmanId = dusmanlar.get(i).getId();
            dusmanlarinIdsi.add(dusmanId);
        }
        return dusmanlarinIdsi;
    }

}
