public class KonsolGorunumu extends OyunGorunumu {
    // Bu sinif OyunGorunumu sinifini miras alir.
    // Miras alma islemi "extends" anahtar kelimesi ile yapilir.

    public static void goster() {
        // Bu metot miras alinan siniftan bir nesne olusturur.
        OyunGorunumu oyunGorunumu = new OyunGorunumu();
        // Olusturulan nesne ile o sinifin metotlarina erisim saglandi.
        oyunGorunumu.baslangicEkrani(); // metotlara erisim gerceklestirildi.
        oyunGorunumu.anaMenuyuGoster(); // metotlara erisim gerceklestirildi.
    }
}
