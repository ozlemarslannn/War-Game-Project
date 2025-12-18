import java.util.Random; // Rastgele sayilar uretilebilmesi icin import edilmesi gereken siniftir.

public class Sans {
    // Sinif degiskenleri tanimlandi.Bu degiskenler sovalyeler icin sans ozellikleri verilecektir.

    private boolean iyiSans;
    private boolean kotuSans;
    private int sans;

    public Sans() {
        // Sans sinifinin constructoru parametresiz olarak verildi.
        // Bu constructor cagirildiginda rastgele sayilar uretilebilmesi bir nesne uretildi.
        
        Random rastgele = new Random(); // nesne uretildi.
        this.sans = rastgele.nextInt(2); //0-2 rakam uretecek.Bu sayi iyi ve kotu sansi belirleyecektir.
        if (sans == 0) { // eger rastgele uretilen sayi 0 ise kotu sans aktiflesir
            this.kotuSans = true;
            this.iyiSans = false;
        } else {
            this.kotuSans = false; // eger rastgele uretilen sayi 1 ise iyi sans aktiflesir.
            this.iyiSans = true;
        }
    }

    public void sansAta(Sovalye sovalye) {
        // Bu metod Sovalye sinifindan bir nesneyi parametre olarak alir.
        // Alinan nesnenin o siniftaki degisken kullanilarak cagirilir.
        sovalye.setSans(new Sans());
    }

    @Override // metot ezme islemidir.
    public String toString() {
        return "Şans (" +
                "İyi Şans: " + iyiSans +
                ", Kötü Şans: " + kotuSans +
                ", Şans: " + sans +
                ')';
    }
}

