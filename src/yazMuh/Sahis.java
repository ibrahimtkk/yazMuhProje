package yazMuh;

public class Sahis extends Musteri{
    private String dogumYili;

    public Sahis(String musteriAdi, String musteriSoyadi, String eMail, String dogumYili) {
        super(musteriAdi, musteriSoyadi, eMail);
        this.dogumYili = dogumYili;
    }

    public String getDogumYili() {
        return dogumYili;
    }

    public void setDogumYili(String dogumYili) {
        this.dogumYili = dogumYili;
    }

}
