package Form;

import Models.Ogrenci;
import Services.FileService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class OgrenciKayitForm  extends JFrame{
    private JTextField tfOgrenciAd;
    private JTextField tfOgrenciSoyad;
    private JTextField tfOgrenciNo;
    private JComboBox cbOgrenciDers;
    private JButton btnClear;
    private JButton btnSubmit;
    private JButton btnDersGoster;
    private JPanel OgrenciKayitForm;
    Ogrenci ogrenci = new Ogrenci();
    String ogrenciNo= ogrenci.OgrenciNo;
    String ogrenciAd= ogrenci.OgrenciAdi;
    String ogrenciSoyad= ogrenci.OgrenciSoyadi;
    String DersGoster = ogrenci.DersGoster;
    String ogrenciDers = ogrenci.OgrenciDers;


    public OgrenciKayitForm() {
        FileService fileService = new FileService();
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfOgrenciAd.setText("");
                tfOgrenciNo.setText("");
                tfOgrenciSoyad.setText("");
                cbOgrenciDers.setSelectedIndex(-1);
            }
        });
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ogrenciNo = tfOgrenciNo.getText();
                String ogrenciAd = tfOgrenciAd.getText();
                String ogrenciSoyad = tfOgrenciSoyad.getText();
                String ogrenciBolum = "";
                String OgrenciDers = (String) cbOgrenciDers.getSelectedItem();

                System.out.println("Öğrenci Adı: " + ogrenciAd + ", Soyadı: " + ogrenciSoyad + ", Öğrenci No: " + ogrenciNo);

                // Call kaydet2 with the provided parameters
                fileService.kaydet2(ogrenciNo, ogrenciAd, ogrenciSoyad, ogrenciBolum, OgrenciDers);
            }
        });


        btnDersGoster.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbOgrenciDers.removeAllItems();
                List<String> derslist = fileService.getDersIsmiList("src/Data/Ders.txt");

                if (derslist != null) {
                    for (String ders : derslist) {
                        cbOgrenciDers.addItem(ders);
                    }

                }
                else {
                    System.out.println("Ders listesi bulunamadı.");
                }
            }
        });

        setContentPane(OgrenciKayitForm);
        setTitle("OgrenciKayitForm");
        setMinimumSize(new Dimension(600,500));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args){
        OgrenciKayitForm ogrenciKayitForm = new OgrenciKayitForm();
    }
}