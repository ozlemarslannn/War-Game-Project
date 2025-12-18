public class Sabitler {
    // Sabitler sinifinin tanimlanmasinin sebebi: kod karisikligi onlemek icin bazi String ifadelerini final olarak tanimlandi.
    // Degiskenlerin static olarak tanimlanmasinin sebebi ise sinifadi.degsikenismi seklinde diger siniflardan bu degiskenlere erisebilmek icindir.

    public static final boolean DEBUG_MOD = false; // Ekranda loglari(her bir islemin nasil ilerledigi ve hatalari daha kolay bulabilmek icin) gormek istersek bunu true'ya cekmeliyiz!

    public static final String YILDIZLAR = "*****************";
    public static final String HOS_GELDIN_MESAJI = "Oyuna hoş geldiniz.";
    public static final String ANA_MENU_LISTESI = "ANA MENÜ " +
            "\n\t 1. Tüm şövalyeleri göster" +
            "\n\t 2. Aktif olan tüm şövalyeri göster" +
            "\n\t 3. Adı girilen şövalye bilgilerini göster" +
            "\n\t 4. Adı girilen şövalyeyi değiştir" +
            "\n\t 5. Yardım" +
            "\n\t 6. Oyunu başlat" +
            "\n\t 7. Oyundan çık!";
    public static final String SECIM_YAP_MESAJI = "Lütfen bir seçim yapınız.";
    public static final String AYRILIK_MESAJI = "Çıkış yapmayı tercih ettiniz. Güle güle!";
    public static final String HATALI_HAMLE_MESAJI = "Hatalı bir seçim yaptınız. Lütfen tekrar deneyiniz.";
    public static final String ISIM_ISTEME_MESAJI = " için bir isim giriniz:";
    public static final String DUSMAN_KARAKTER = "Düşman";
    public static final String SOVALYE_KARAKTER = "Şövalye";
    public static final String GUCLU_TIP = "Güçlü";
    public static final String ZAYIF_TIP = "Zayıf";
    public static final String SOVALYE_ID_ISTEME_MESAJI = "Kullanacağınız şövalyenin numarasını giriniz: ";
    public static final String SOVALYE_ID_TEKRAR_ISTEME_MESAJI = "Yanlış bir tercih yaptınız! Kullanacağınız şövalyenin numarasını giriniz: ";
    public static final String HEDEFTEKI_DUSMAN_ID_ISTEME_MESAJI = "Hedefteki düşmanın numarasını giriniz: ";
    public static final String HEDEFTEKI_DUSMAN_ID_TEKRAR_ISTEME_MESAJI = "Yanlış bir tercih yaptınız! Hedefteki düşmanın numarasını giriniz: ";
    public static final String HEDEF_VURULDU_MESAJI = "Hedef vuruldu. \nDüşman yok edildi.";
    public static final String OYUNU_KAYBETTINIZ_MESAJI = "Oyunu kaybettiniz. Düşmanlar kazandı.";
    public static final String OYUNU_KAZANDINIZ_MESAJI = "Oyunu kazandınız. Tebrikler!";
    public static final String YARDIM_MESAJI = "Bu bir yaşam mücadelesi verme oyunudur. " +
            "Oyunda güçlü ve zayıf şövalyer ; zayıf ve güçlü düşmanlara " +
            "karşı mücadele etmektedirler.\n Dogru hamlelerde bulunarak " +
            "tüm düşmanları yok edebilirisin. \n Biz sana güveniyoruz. " +
            "Eğer oyunu başlatmak istersen 6 numaralı seçeneği seçmelisin." +
            "Bol şanslar.\n Seninle birlikte bu mücadeleyi vermek isteriz " +
            "ama çıkmak istersen 7 numaraya basman gerekli. ";
}