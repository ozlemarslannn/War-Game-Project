public class Dusman extends Karakterler {
    // Dusman sinifi Karakterler sinifinin yavru sinifdir.Karakterler sinifi alindi.

    private String dusmanTipi; // Dusman sinifina ozgu olan degisken 

    public Dusman(String ad, int id) {
        // Dusman sinifinin parametreli constructoru 
        // super anahtar kelimesi ile ata sinifinin constructorune erisim saglandi.
        super(ad, id);
    }
    // Sinif degiskenlerinin getter ve setter metotlari tanimlandi.

    public String getDusmanTipi() {
        return dusmanTipi;
    }

    public void setDusmanTipi(String dusmanTipi) {
        this.dusmanTipi = dusmanTipi;
    }

    @Override // ezme islemi gerceklestirildi.
    public String toString() {
        return super.toString() + " Düşman Tipi: " + dusmanTipi;
    }
}
