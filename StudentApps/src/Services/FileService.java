package Services;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class FileService {

    public static void kaydet(String dersKodu, String dersIsim, String dersDonem) {
        // Specify the path of the file
        String filePath = "src/Data/Ders.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // Append the input values to the file with proper formatting
            writer.write("Ders Kodu: " + dersKodu + ", Ders Isim: " + dersIsim + ", Ders Donem: " + dersDonem);
            writer.newLine(); // Move to the next line for the next entry
            System.out.println("Veriler dosyaya kaydedildi."); // Optional: Print a message
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately (e.g., log it or show an error message)
        }
    }
    public void kaydet2(String ogrenciNo, String ogrenciAd,String ogrenciSoyad,String ogrenciBolum, String OgrenciDers ) {
        // Specify the path of the file
        String filePath = "src/Data/ogrenci.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // Append the input values to the file
            writer.write("Ogrenci No: " + ogrenciNo + "\tOgrenci Ad: " + ogrenciAd + "\tOgrenci Soyad: " + ogrenciSoyad + "\tOgrenci Bolum: " + ogrenciBolum + "\tOgrenci Ders:" + OgrenciDers);
            writer.newLine(); // Move to the next line for the next entry
            System.out.println("Veriler dosyaya kaydedildi."); // Optional: Print a message
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately (e.g., log it or show an error message)
        }
    }
    public static void kaydet3(String OgretmenNo, String Ad, String Soyad, String Bolum) {
        // Specify the path of the file
        String filePath = "src/Data/OgretimGorevlisi.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // Append the input values to the file with proper formatting
            writer.write("OgretmenNo: " + OgretmenNo + ", Ad: " + Ad + ", Soyad: " + Soyad + ", Bolum: " + Bolum);
            writer.newLine(); // Move to the next line for the next entry
            System.out.println("Veriler dosyaya kaydedildi."); // Optional: Print a message
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately (e.g., log it or show an error message)
        }
    }
    public List<String> getDersIsmiList(String filePath) {
        List<String> dersIsimList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line based on tabs and get the Ders Isim value
                String[] parts = line.split(", ");
                for (String part : parts) {
                    if (part.startsWith("Ders Isim:")) {
                        // Extract and add the Ders Isim value to the list
                        dersIsimList.add(part.substring("Ders Isim: ".length()));
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace(); // Handle the exception appropriately
        }

        return dersIsimList;
    }


    public List<String[]> dersBilgileriniGetir(String dosyaYolu) {
        List<String[]> dersBilgileri = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(dosyaYolu))) {
            String satir;

            while ((satir = br.readLine()) != null) {
                // Boş satırları kontrol et
                if (!satir.trim().isEmpty()) {
                    // Dosya formatına göre parçalama işlemleri
                    String[] bilgiler = satir.split(", ");
                    dersBilgileri.add(bilgiler);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dersBilgileri;
    }



    public static void main(String[] args) {
       FileService fileService = new FileService();
        List<String> dersIsmiList = fileService.getDersIsmiList("src/Data/Ders.txt");

        // Print the Ders Isim values
        System.out.println("Ders Isim Listesi:");
        for (String dersIsim : dersIsmiList) {
            System.out.println(dersIsim);
        }
    }


}