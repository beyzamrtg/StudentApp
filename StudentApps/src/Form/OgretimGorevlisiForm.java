package Form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Models.OgretimGorevlisi;
import java.util.List;
import Services.FileService;

public class OgretimGorevlisiForm extends JFrame {

    private JTextField tfOgretmenNo;
    private JTextField tfAd;
    private JTextField tfSoyad;
    private JButton btnClear;
    private JButton btnSubmit;
    private JTextField tfBolum;
    private JPanel OgretimGorevlisiForm;

    OgretimGorevlisi ogretimGorevlisi = new OgretimGorevlisi();
    String OgretmenNo = ogretimGorevlisi.OgretmenNo;
    String Ad = ogretimGorevlisi.Ad;
    String Soyad = ogretimGorevlisi.Soyad;
    String Bolum = ogretimGorevlisi.Bolum;


    public OgretimGorevlisiForm() {
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String OgretmenNo = tfOgretmenNo.getText();
                String Ad = tfAd.getText();
                String Soyad = tfSoyad.getText();
                String Bolum = tfBolum.getText();

                System.out.println("OgretmenNo: " + OgretmenNo + ", Ad: " + Ad + ", Soyad: " + Soyad + ",Bolum:" + Bolum);

                // Call kaydet2 with the provided parameters
                FileService.kaydet3(OgretmenNo, Ad, Soyad, Bolum);
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfOgretmenNo.setText("");
                tfAd.setText("");
                tfSoyad.setText("");
                tfBolum.setText("");
            }
        });
        setContentPane(OgretimGorevlisiForm);
        setTitle("OgretimGorevlisiForm");
        setMinimumSize(new Dimension(600, 500));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        OgretimGorevlisiForm ogretimGorevlisiForm = new OgretimGorevlisiForm();
    }
}
