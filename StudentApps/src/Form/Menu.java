package Form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JPanel menuPanel;
    private JButton btnDers;
    private JButton btnOgrenci;
    private JButton btnOgretmenGorevlisi;

    public Menu() {
        btnDers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DersKayitForm dersKayitForm = new DersKayitForm();
                dersKayitForm.setVisible(true);
                dispose();
            }
        });

        btnOgrenci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OgrenciKayitForm ogrenciKayitForm = new OgrenciKayitForm();
                ogrenciKayitForm.setVisible(true);
                dispose();
            }
        });

        btnOgretmenGorevlisi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OgretimGorevlisiForm ogretimGorevlisiForm = new OgretimGorevlisiForm();
                ogretimGorevlisiForm.setVisible(true);
                dispose();
            }
        });
        setContentPane(menuPanel);
        setTitle("Menu");
        setMinimumSize(new Dimension(600, 500));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args){
        Menu menuForm = new Menu();
    }
}