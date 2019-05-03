package yazMuh;

public class Sirket extends Musteri{
    private String calismaAlani, sirketAdi;
    private int kurulusYili;


    public Sirket(String sirketAdi, String musteriAdi, String musteriSoyadi, String eMail, String calismaAlani, int kurulusYili) {
        super(musteriAdi, musteriSoyadi, eMail);
        this.calismaAlani = calismaAlani;
        this.sirketAdi = sirketAdi;
        this.kurulusYili = kurulusYili;
    }

    public String getSirketAdi() {
        return sirketAdi;
    }

    public void setSirketAdi(String sirketAdi) {
        this.sirketAdi = sirketAdi;
    }

    public String getCalismaAlani() {
        return calismaAlani;
    }

    public void setCalismaAlani(String calismaAlani) {
        this.calismaAlani = calismaAlani;
    }

    public int getKurulusYili() {
        return kurulusYili;
    }

    public void setKurulusYili(int kurulusYili) {
        this.kurulusYili = kurulusYili;
    }

    public boolean isOzelRapor() {
        return ozelRapor;
    }

    public void setOzelRapor(boolean ozelRapor) {
        this.ozelRapor = ozelRapor;
    }
}
