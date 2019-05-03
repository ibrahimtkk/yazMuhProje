package yazMuh;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args){

        ArrayList<Musteri> musteriList = new ArrayList<Musteri>();
        ArrayList<HaberKaynaklari> haberKaynaklariList = new ArrayList<HaberKaynaklari>();
        ArrayList<String> haberlerList = new ArrayList<String>();
        Firma firma = new Firma(haberKaynaklariList, musteriList);
        ArrayList<String> basligiBulunanHaberler = new ArrayList<>();

        Sirket sirket1 = new Sirket("Beşiktaş","Fikret", "Orman", "mesiktasimMampiyon@gmail.com",  "Spor", 1903);

        Sahis sahis1 = new Sahis("Recep Tayyip", "Erdoğan", "fik", "1999");
        haberlerList = haberBasligiDondur(sirket1);


        // Standart tarife için yorum satırını aç
        /*

            if ( sirket1.getOzelRapor()==false ){
                standartRaporla(sirket1);
            }

            haberlerList = haberBasligiDondur(sahis1);

            if ( sahis1.getOzelRapor()==false ){
                standartRaporla(sahis1);
            }

        */

        Sirket sirket2 = new Sirket("Beşiktaş","Fikret", "Orman", "mesiktasimMampiyon@gmail.com",  "Spor", 1903);
        sirket2.setOzelRapor(true);
        Sahis sahis2 = new Sahis("Recep Tayyip", "Erdoğan", "fik", "1999");
        sahis2.setOzelRapor(true);
        haberlerList = haberBasligiDondur(sahis1);
        if ( sirket2.getOzelRapor()==true ){
            ozelRaporla(sirket2);
        }

        haberlerList = haberBasligiDondur(sahis1);

        if ( sahis2.getOzelRapor()==true ){
            ozelRaporla(sahis2);
        }


    }





    public static ArrayList<String> haberBasligiDondur(Musteri musteri){
        String aranacak;
        ArrayList<String> haberBasliklari = new ArrayList<String>();
        if(musteri instanceof Sirket){
            aranacak = ((Sirket) musteri).getSirketAdi();
        }
        else{
            aranacak = musteri.getMusteriAdi() + " " + musteri.getMusteriSoyadi();
        }
        File f = new File("C:\\Users\\ibrahim\\Desktop\\Karisik\\Dersler\\3-Bahar\\Yaz Müh\\proje");
        File[] files = f.listFiles();
        for (File file : files) {
            File[] haberKaynakCesitleri = file.listFiles();
            //System.out.println(haberKaynakCesitleri[0].getName());
            for (File haberKaynakCesidi: haberKaynakCesitleri){
                File[] kaynak = haberKaynakCesidi.listFiles();
                for (File fi: kaynak){
                    if (fi.getName().contains(aranacak)){
                        System.out.println(fi.toString());
                        haberBasliklari.add(fi.toString());
                    }
                }
            }
        }
        return haberBasliklari;
    }

    public static String standartRaporla(Musteri musteri){
        ArrayList<String> adresler = new ArrayList<>();
        adresler = haberBasligiDondur(musteri);
        String aranacak, yayinOrgani="";
        if(musteri instanceof Sirket){
            aranacak = ((Sirket) musteri).getSirketAdi();
        }
        else{
            aranacak = musteri.getMusteriAdi() + " " + musteri.getMusteriSoyadi();
        }

        String satir, tarih, metin="";
        for (String adres: adresler) {
            try {
                System.out.println("adres: " + adres);
                metin = "";
                satir = "";
                BufferedReader oku = new BufferedReader(new FileReader(adres));
                satir = oku.readLine();
                metin += satir + "\n";
                metin += "----------------------------------------------------------\n";
                if (adres.contains("İnternet")) {
                    yayinOrgani = "İnternet";
                }
                if (adres.contains("Gazete")) {
                    yayinOrgani = "Gazete";
                }
                if (adres.contains("Radyo")) {
                    yayinOrgani = "Radyo";
                }
                //System.out.println(metin);
                tarih = satir;
                if (tarih != null) {
                    System.out.println("tarih " + tarih);
                    String gun = tarih.substring(0, 2);
                    String ay = tarih.substring(3, 5);
                    String hafta = Integer.toString((Integer.parseInt(gun) - 1) / 7 + 1);


                    while (satir != null) {
                        satir = oku.readLine();
                        //System.out.println("satir: "+satir);
                        metin += satir + "\n";
                    }
                    oku.close();
                    BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\ibrahim\\Desktop\\Karisik\\Dersler\\3-Bahar\\Yaz Müh\\" + tarih + aranacak + yayinOrgani + ".txt", true));
                    writer.newLine();
                    writer.write(metin);
                    writer.close();

                    BufferedWriter writer1 = new BufferedWriter(new FileWriter("C:\\Users\\ibrahim\\Desktop\\Karisik\\Dersler\\3-Bahar\\Yaz Müh\\" + ay + ".ay " + hafta + ".hafta " + aranacak + yayinOrgani + ".txt", true));
                    writer1.newLine();
                    writer1.write(metin);
                    writer1.close();

                    BufferedWriter writer2 = new BufferedWriter(new FileWriter("C:\\Users\\ibrahim\\Desktop\\Karisik\\Dersler\\3-Bahar\\Yaz Müh\\" + ay + ".ay " + aranacak + yayinOrgani + ".txt", true));
                    writer2.newLine();
                    writer2.write(metin);
                    writer2.close();
                }
            }
            catch (IOException iox){
                System.out.println("hata");
            }
        }
        return "eren";
    }

    public static String ozelRaporla(Musteri musteri){
        ArrayList<String> adresler = new ArrayList<>();
        adresler = haberBasligiDondur(musteri);
        String aranacak, yayinOrgani="";
        if(musteri instanceof Sirket){
            aranacak = ((Sirket) musteri).getSirketAdi();
        }
        else{
            aranacak = musteri.getMusteriAdi() + " " + musteri.getMusteriSoyadi();
        }

        String satir, tarih, metin="";
        for (String adres: adresler) {
            try {
                System.out.println("adres: " + adres);
                metin = "";
                satir = "";
                BufferedReader oku = new BufferedReader(new FileReader(adres));
                satir = oku.readLine();
                metin += "----------------------------------------------------------\n";
                metin += satir + "\n";
                if (adres.contains("İnternet")) {
                    yayinOrgani = "İnternet";
                }
                if (adres.contains("Gazete")) {
                    yayinOrgani = "Gazete";
                }
                if (adres.contains("Radyo")) {
                    yayinOrgani = "Radyo";
                }
                //System.out.println(metin);
                tarih = satir;
                if (tarih != null) {
                    satir = oku.readLine();
                    String hour = satir;
                    metin += hour+"\n";
                    String saat = hour.substring(0,2);
                    String dakika = hour.substring(3,5);
                    System.out.println("tarih " + tarih);
                    String gun = tarih.substring(0, 2);
                    String ay = tarih.substring(3, 5);
                    String hafta = Integer.toString((Integer.parseInt(gun) - 1) / 7 + 1);


                    while (satir != null) {
                        satir = oku.readLine();
                        //System.out.println("satir: "+satir);
                        metin += satir + "\n";
                    }
                    oku.close();
                    BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\ibrahim\\Desktop\\Karisik\\Dersler\\3-Bahar\\Yaz Müh\\" + tarih + aranacak + yayinOrgani + ".txt", true));
                    writer.newLine();
                    writer.write(metin);
                    writer.close();

                    BufferedWriter writer1 = new BufferedWriter(new FileWriter("C:\\Users\\ibrahim\\Desktop\\Karisik\\Dersler\\3-Bahar\\Yaz Müh\\" + ay + ".ay " + hafta + ".hafta " + aranacak + yayinOrgani + ".txt", true));
                    writer1.newLine();
                    writer1.write(metin);
                    writer1.close();

                    BufferedWriter writer2 = new BufferedWriter(new FileWriter("C:\\Users\\ibrahim\\Desktop\\Karisik\\Dersler\\3-Bahar\\Yaz Müh\\" + ay + ".ay " + aranacak + yayinOrgani + ".txt", true));
                    writer2.newLine();
                    writer2.write(metin);
                    writer2.close();

                    BufferedWriter writer3 = new BufferedWriter(new FileWriter("C:\\Users\\ibrahim\\Desktop\\Karisik\\Dersler\\3-Bahar\\Yaz Müh\\" + tarih + " saat- " + saat+ "." + dakika + aranacak + yayinOrgani + ".txt", true));
                    writer3.newLine();
                    writer3.write(metin);
                    writer3.close();
                }
            }
            catch (IOException iox){
                System.out.println(iox.toString());
            }
        }
        return "eren";
    }

}
