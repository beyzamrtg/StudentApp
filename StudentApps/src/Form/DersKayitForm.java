package Form;

import Models.Ders;
import Services.FileService;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class DersKayitForm extends JFrame {
    private JTextField tfDersKodu;
    private JTextField tfDersIsmi;
    private JButton btnClear;
    private JButton btnSubmit;
    private JTextField tfDersDonem;
    private JPanel DersKayitForm;
    private JTextField tfOgretimGorevlisi;
    private JTextField tfDersArama;
    private JTable tableDers;
    private JTable tfSearch;
    Ders ders= new Ders();
    String dersKodu= ders.DersKodu;

    String dersIsmi= ders.DersIsmi;
    String dersDonem= ders.DerDonem;


    public DersKayitForm() {
        FileService fileService = new FileService();

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dersKodu=tfDersKodu.getText();
                dersIsmi=tfDersIsmi.getText();
                dersDonem=tfDersDonem.getText();
                FileService.kaydet(dersKodu, dersIsmi, dersDonem);
            }

        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfDersKodu.setText("");
                tfDersIsmi.setText("");
                tfDersDonem.setText("");
                tfOgretimGorevlisi.setText("");
            }
        });


        DefaultTableModel tableDers2 = new DefaultTableModel();
        tableDers2.addColumn("ders kodu");
        tableDers2.addColumn("ders ismi");
        tableDers2.addColumn("ders donem");

        List<String[]> dersler = fileService.dersBilgileriniGetir("src/Data/Ders.txt");

        if (dersler != null) {
            for (String[] ders : dersler) {
                tableDers2.addRow(ders);
            }
        }

        tableDers.setModel(tableDers2);

        setContentPane(DersKayitForm);
        setTitle("DersKayitForm");
        setMinimumSize(new Dimension(600,500));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        tfDersArama.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                String input = tfDersArama.getText().toLowerCase().trim();
                TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(tableDers2);
                tableDers.setRowSorter(rowSorter);

                rowSorter.setRowFilter(RowFilter.regexFilter("(?i).*" + input + ".*"));
            }
        });
    }
    public static void main(String[] args){
        DersKayitForm dersKayitForm = new DersKayitForm();
    }
}