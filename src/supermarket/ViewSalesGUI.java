/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SampritBiswas
 */
public class ViewSalesGUI extends javax.swing.JFrame {

    /**
     * Creates new form ViewSalesGUI
     */
    public ViewSalesGUI() {
        billArray = new GetInfoFromFiles().getBills();
        showItems = new ArrayList<>();
        setVisible(false);
        GetDates get = new GetDates(this);
        get.setVisible(true);
        get.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public void initialize() {
        setVisible(true);
        initComponents();
        addValues();
        salesTable.setAutoCreateRowSorter(true);
        jtable();
    }

    public void jtable() {
        final NewItemGUI newItemGui = new NewItemGUI();

        salesTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                newItemGui.setVisible(false);
                salesTable.clearSelection();
            }
        });

        salesTable.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {

                int row = salesTable.rowAtPoint(e.getPoint());


                if (row > -1) {

                    salesTable.clearSelection();
                    salesTable.setRowSelectionInterval(row, row);
                    salesTable.setSelectionBackground(new Color(255, 54, 54));
                    if (salesTable.getValueAt(row, 0) == null || salesTable.getValueAt(row, 0).toString().equalsIgnoreCase("")) {
                        newItemGui.setVisible(false);
                        return;
                    }

                    newItemGui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    newItemGui.setVisible(true);
                    //newItemGui.setLocation(450, 200);
                    newItemGui.setLocation(e.getX() + 30, e.getY() + 80);
                    newItemGui.hoverID = salesTable.getValueAt(row, 0).toString();
                    newItemGui.price = salesTable.getValueAt(row, 2).toString();
                    newItemGui.addDataSales();
                    newItemGui.submitButton.setVisible(false);

                    if (newItemGui.isVisible() == false) {
                        newItemGui.setVisible(true);
                    }

                } else {
                    salesTable.setSelectionBackground(Color.RED);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        salesTable = new javax.swing.JTable();
        totText = new javax.swing.JTextField();
        typeButton = new javax.swing.JButton();
        manufacturerButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        printButton = new javax.swing.JButton();

        salesTable.setBackground(new java.awt.Color(204, 255, 204));
        salesTable.setModel(model);
        jScrollPane1.setViewportView(salesTable);

        totText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totText.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        typeButton.setText("View by Type");
        typeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        typeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeButtonActionPerformed(evt);
            }
        });

        manufacturerButton.setText("View by Manufacturer");
        manufacturerButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        manufacturerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manufacturerButtonActionPerformed(evt);
            }
        });

        resetButton.setText("Reset");
        resetButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        printButton.setText("Print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(typeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(printButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(totText, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(resetButton)
                                .addGap(30, 30, 30)
                                .addComponent(manufacturerButton)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(totText, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(printButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeButton)
                    .addComponent(manufacturerButton)
                    .addComponent(resetButton))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void typeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeButtonActionPerformed
        String strT = JOptionPane.showInputDialog(null, "Enter the Item Type : ",
                "Item Type", JOptionPane.QUESTION_MESSAGE);
        int i = 0;
        boolean exist = false;
        float tot = 0;

        for (Item item : showItems) {
            if (item.getType().equalsIgnoreCase(strT) == false) {
                continue;
            }
            exist = true;

            if (i >= salesTable.getRowCount()) {
                Object row[] = {"", "", "", ""};
                model.addRow(row);
                rowCount++;

            }

            float profit = item.getSellPrice() - item.getPurchasePrice();
            salesTable.getModel().setValueAt(item.getItemName(), i, 0);
            salesTable.getModel().setValueAt(profit * item.getItemsBought(), i, 3);
            salesTable.getModel().setValueAt(item.getItemsBought(), i, 1);
            salesTable.getModel().setValueAt(profit, i, 2);

            tot += item.getItemsBought() * profit;
            i++;

        }
        totText.setText("Your profit is : " + tot);

        if (exist == false) {
            JOptionPane.showMessageDialog(this, "This Item Type is not in the table!!!");
            return;
        }

        int del = salesTable.getRowCount();
        for (; i < del; i++) {
            salesTable.getModel().setValueAt(null, i, 0);
            salesTable.getModel().setValueAt("", i, 1);
            salesTable.getModel().setValueAt("", i, 2);
            salesTable.getModel().setValueAt("", i, 3);
            ((DefaultTableModel) salesTable.getModel()).removeRow(i);
            del--;
            i--;
        }
    }//GEN-LAST:event_typeButtonActionPerformed

    private void manufacturerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manufacturerButtonActionPerformed
        String strT = JOptionPane.showInputDialog(null, "Enter the Manufacturer : ",
                "Manufacturer", JOptionPane.QUESTION_MESSAGE);
        int i = 0;
        boolean exist = false;
        float tot = 0;

        for (Item item : showItems) {
            if (item.getManufacturer().equalsIgnoreCase(strT) == false) {
                continue;
            }
            exist = true;

            if (i >= salesTable.getRowCount()) {
                Object row[] = {"", "", "", ""};
                model.addRow(row);
                rowCount++;

            }

            float profit = item.getSellPrice() - item.getPurchasePrice();
            salesTable.getModel().setValueAt(item.getItemName(), i, 0);
            salesTable.getModel().setValueAt(profit * item.getItemsBought(), i, 3);
            salesTable.getModel().setValueAt(item.getItemsBought(), i, 1);
            salesTable.getModel().setValueAt(profit, i, 2);

            tot += item.getItemsBought() * profit;
            i++;

        }
        totText.setText("Your profit is : " + tot);

        if (exist == false) {
            JOptionPane.showMessageDialog(this, "This Manufacturer not present in this table!!!");
            return;
        }

        int del = salesTable.getRowCount();
        for (; i < del; i++) {
            salesTable.getModel().setValueAt(null, i, 0);
            salesTable.getModel().setValueAt("", i, 1);
            salesTable.getModel().setValueAt("", i, 2);
            salesTable.getModel().setValueAt("", i, 3);
            ((DefaultTableModel) salesTable.getModel()).removeRow(i);
            del--;
            i--;
        }
    }//GEN-LAST:event_manufacturerButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed

        int del = salesTable.getRowCount();
        for (int i = 0; i < del; i++) {
            salesTable.getModel().setValueAt(null, i, 0);
            salesTable.getModel().setValueAt("", i, 1);
            salesTable.getModel().setValueAt("", i, 2);
            salesTable.getModel().setValueAt("", i, 3);
            ((DefaultTableModel) salesTable.getModel()).removeRow(i);
            del--;
            i--;
        }

        float tot = 0;
        int i = 0;
        for (Item it : showItems) {

            Object row[] = {"", "", "", ""};
            model.addRow(row);
            rowCount++;
            float profit = it.getSellPrice() - it.getPurchasePrice();
            salesTable.getModel().setValueAt(it.getItemName(), i, 0);
            salesTable.getModel().setValueAt(profit * it.getItemsBought(), i, 3);
            salesTable.getModel().setValueAt(it.getItemsBought(), i, 1);
            salesTable.getModel().setValueAt(profit, i, 2);

            tot += it.getItemsBought() * profit;
            i++;

        }

        totText.setText("Your total profit is : " + tot);
    }//GEN-LAST:event_resetButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        try {
            MessageFormat header = new MessageFormat("Sales Statistics");
            MessageFormat h = new MessageFormat("page 1");
            salesTable.print(JTable.PrintMode.FIT_WIDTH, header, h);

        } catch (PrinterException ex) {
            System.out.println("Unable to Print");
        }
    }//GEN-LAST:event_printButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewSalesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewSalesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewSalesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewSalesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewSalesGUI().setVisible(false);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton manufacturerButton;
    private javax.swing.JButton printButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JTable salesTable;
    private javax.swing.JTextField totText;
    private javax.swing.JButton typeButton;
    // End of variables declaration//GEN-END:variables
    Date from, to;
    ArrayList<Bill> billArray;
    ArrayList<Item> showItems;
    String[] gotDates = {"", ""};  //from, to
    int rows = 0;
    Object columnNames[] = {"Items", "Items Sold", "Profit for each item", "Profit"};
    DefaultTableModel model = new DefaultTableModel(columnNames, rows) {
        @Override
        public Class<?> getColumnClass(int column) {
            switch (column) {
                case 0:
                    return String.class;
                case 1:
                    return Integer.class;
                case 2:
                    return Float.class;
                case 3:
                    return Float.class;
                default:
                    return String.class;
            }
        }
    };
    int rowCount = 0;

    private void addValues() {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            from = sdf.parse(gotDates[0]);
            to = sdf.parse(gotDates[1]);
            from.setHours(0);
            from.setMinutes(1);
            to.setHours(23);
            to.setMinutes(59);
            showItems = new ArrayList<>();
            for (Bill b : billArray) {

                for (Item it : b.getBillItem()) {


                    Date date1 = it.getDateSold();
                    System.out.println(date1 + " " + it.getID());

                    if (date1 == null) {
                    } else if (date1.compareTo(from) >= 0 && date1.compareTo(to) <= 0) {
                        showItems.add(it);
                    }

                    /*Date date1 = it.getDateSold();
                     if (date1.getYear() >= from.getYear() && date1.getYear() <= to.getYear()) {
                     if (date1.getMonth() >= from.getMonth() && date1.getMonth() <= to.getMonth()) {
                     if(date1.getDay()>=from.getDay() && date1.getDay()<=to.getDay()){
                     showItems.add(it);
                     }
                     }
                     }*/
                }

            }

        } catch (ParseException ex) {
            Logger.getLogger(ViewSalesGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        Collections.sort(showItems);

        int ci = 0, cj = 0;
        for (Item i : showItems) {
            cj = 0;
            for (Item j : showItems) {

                if (cj >= ci) {
                    continue;
                }
                if (i.getID().compareToIgnoreCase(j.getID()) < 0) {
                    Item temp = showItems.get(ci);
                    showItems.set(ci, showItems.get(cj));
                    showItems.set(cj, temp);
                } else if (i.getID().compareToIgnoreCase(j.getID()) == 0) {
                    if (i.getSellPrice() < j.getSellPrice()) {
                        Item temp = showItems.get(ci);
                        showItems.set(ci, showItems.get(cj));
                        showItems.set(cj, temp);
                    }
                }
                cj++;
            }
            ci++;
        }

        int size = showItems.size();

        int j = 0;
        for (j = 0; j < size - 1; j++) {

            System.out.println(showItems.get(j).getID());
            if (j == size - 2) {
                System.out.println(showItems.get(size - 1).getID());
            }

            if (showItems.get(j).getID().equalsIgnoreCase(showItems.get(j + 1).getID())) {

                if (showItems.get(j).getSellPrice() != showItems.get(j + 1).getSellPrice()) {
                    continue;
                }
                //showItems.get(j).setNoOfItems(showItems.get(j).getItemsBought() + showItems.get(j + 1).getItemsBought());
                showItems.get(j).setItemsBought(showItems.get(j).getItemsBought() + showItems.get(j + 1).getItemsBought());
                showItems.remove(j + 1);
                size = showItems.size();
                j--;
            }

        }
        float tot = 0;
        int i = 0;
        for (Item it : showItems) {

            Object row[] = {"", "", "", ""};
            model.addRow(row);
            rowCount++;
            float profit = it.getSellPrice() - it.getPurchasePrice();
            salesTable.getModel().setValueAt(it.getItemName(), i, 0);
            salesTable.getModel().setValueAt(profit * it.getItemsBought(), i, 3);
            salesTable.getModel().setValueAt(it.getItemsBought(), i, 1);
            salesTable.getModel().setValueAt(profit, i, 2);

            tot += it.getItemsBought() * profit;
            i++;

        }

        totText.setText("Your total profit is : " + tot);
    }
}