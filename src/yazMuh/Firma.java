package yazMuh;

import java.util.ArrayList;

public class Firma {
    private ArrayList<HaberKaynaklari> haberKaynaklari;
    private ArrayList<Musteri> birMusteri;

    public Firma(ArrayList<HaberKaynaklari> haberKaynaklari, ArrayList<Musteri> birMusteri) {
        this.haberKaynaklari = haberKaynaklari;
        this.birMusteri = birMusteri;
    }

    public String raporla(Musteri birMusteri){
        String bilgiler = "Burada müşteri ile alakalı bilgiler var";
        return bilgiler;
    }

    public boolean haberKaynagiEkle(HaberKaynaklari yeniHaberKaynagi){
        if ( haberKaynaklari.contains(yeniHaberKaynagi) ){
            System.out.println("Böyle bir haber kaynağı zaten var aq");
            return false;
        }
        else{
            haberKaynaklari.add(yeniHaberKaynagi);
            return true;
        }
    }

    public void fiyatlandirma(Musteri birMusteri){
        if (birMusteri.getOzelRapor()==false){
            birMusteri.setFiyat(1000);
        }
        else{
            birMusteri.setFiyat(90000);
        }
    }
}
