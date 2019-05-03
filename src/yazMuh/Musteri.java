package yazMuh;

public abstract class Musteri{
    public String musteriAdi="", musteriSoyadi="", eMail="", adres="", irtibatNo = "";
    public Boolean ozelRapor=false;
    public int fiyat;

    public Musteri(String musteriAdi, String musteriSoyadi, String eMail) {
        this.musteriAdi = musteriAdi;
        this.musteriSoyadi = musteriSoyadi;
        this.eMail = eMail;
    }

    public String getMusteriAdi() {
        return musteriAdi;
    }

    public void setMusteriAdi(String musteriAdi) {
        this.musteriAdi = musteriAdi;
    }

    public String getMusteriSoyadi() {
        return musteriSoyadi;
    }

    public void setMusteriSoyadi(String musteriSoyadi) {
        this.musteriSoyadi = musteriSoyadi;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getIrtibatNo() {
        return irtibatNo;
    }

    public void setIrtibatNo(String irtibatNo) {
        this.irtibatNo = irtibatNo;
    }

    public Boolean getOzelRapor() {
        return ozelRapor;
    }

    public void setOzelRapor(Boolean ozelRapor) {
        this.ozelRapor = ozelRapor;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }
}