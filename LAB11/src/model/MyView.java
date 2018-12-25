package model;

import model.Drug;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;

public class MyView extends JFrame {

    JList listView;

    JPanel listPanel;
    JPanel formPanel;

    private final static String statusHead = " Status: ";
    public MyView() throws HeadlessException {
        JFrame self = this;

        JLabel status = new JLabel(statusHead);
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        listPanel = new JPanel();
        DefaultListModel <Drug> listModel = new DefaultListModel();
        listView = new JList(listModel);
        listPanel.add(listView);
        listModel.addElement(
                new Drug(4, "Otrivin",5,4, "10.01.2019")
        );


        formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        JTextField numberOfPharmacyInput = new JTextField();
        JTextField nameInput = new JTextField();
        JTextField amountOfPackInput = new JTextField();
        JTextField costOfPackInput = new JTextField();
        JTextField dateOfLifeInput = new JTextField();
        JButton submit = new JButton("Submit");
        formPanel.add(new JLabel("number Of Pharmacy:"));
        formPanel.add(numberOfPharmacyInput);
        formPanel.add(new JLabel("name:"));
        formPanel.add(nameInput);
        formPanel.add(new JLabel("amount Of Pack:"));
        formPanel.add(amountOfPackInput);
        formPanel.add(new JLabel("cost Of Pack:"));
        formPanel.add(costOfPackInput);
        formPanel.add(new JLabel("date Of Life:"));
        formPanel.add(dateOfLifeInput);
        formPanel.add(submit);

        submit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numberOfPharmacy = Integer.parseInt(numberOfPharmacyInput.getText());
                String name = nameInput.getText();
                int amountOfPack = Integer.parseInt(amountOfPackInput.getText());
                int costOfPack = Integer.parseInt(costOfPackInput.getText());
                String dateOfLife = dateOfLifeInput.getText();

                listModel.addElement(
                        new Drug(numberOfPharmacy, name, amountOfPack,costOfPack,dateOfLife)
                );
                status.setText(statusHead + "input succeed");
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(listPanel, BorderLayout.NORTH);
        setContentPane(panel);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");

        JMenuItem load = new JMenuItem("Load");
        JMenuItem save = new JMenuItem("Save");

        fileMenu.add(load);
        fileMenu.add(save);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        load.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();

                int result = fileChooser.showOpenDialog(self);
                if (result != JFileChooser.APPROVE_OPTION) {
                    return;
                }

                File file = fileChooser.getSelectedFile();

                try {
                    FileInputStream fis = new FileInputStream(file);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    ArrayList<Drug> loadedInvoices = (ArrayList) ois.readObject();
                    ois.close();
                    fis.close();

                    listModel.clear();
                    for(Drug drug : loadedInvoices) {
                        listModel.addElement(drug);
                    }
                    status.setText(statusHead + "loaded file \"" + file.getName() + '\"');
                } catch (IOException | ClassNotFoundException e1) {
                    e1.printStackTrace();
                    status.setText(statusHead + e1.getMessage());
                }
            }
        });

        save.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();

                int result = fileChooser.showSaveDialog(self);
                if (result != JFileChooser.APPROVE_OPTION) {
                    return;
                }

                File file = fileChooser.getSelectedFile();


                try {
                    FileOutputStream fos = new FileOutputStream(file);
                    ObjectOutputStream oos= new ObjectOutputStream(fos);

                    ArrayList<Drug> invoices = new ArrayList<>();

                    for(int i = 0; i < listModel.size(); ++i) {
                        invoices.add(listModel.get(i));
                    }

                    oos.writeObject(invoices);
                    oos.close();
                    fos.close();
                    status.setText(statusHead + "list saved as \"" + file.getName() + '\"');
                } catch (IOException e1) {
                    e1.printStackTrace();
                    status.setText(statusHead + e1.getMessage());
                }
            }
        });

        JPanel statusPanel = new JPanel();
        statusPanel.add(status);

        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(formPanel, BorderLayout.CENTER);
        southPanel.add(statusPanel, BorderLayout.SOUTH);

        panel.add(southPanel, BorderLayout.SOUTH);

        //Разместим программу по центру
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
