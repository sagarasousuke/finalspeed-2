package net.fs.client;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressCellRenderer<T> implements ListCellRenderer<T> {

    JPanel panel = null;

    JLabel addressLabel;

    Color color_normal = new Color(255, 255, 255);

    Color color_selected = new Color(210, 233, 255);

    JButton button_remove;

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
                                                  boolean cellHasFocus) {
        if (panel == null) {
            init();
        }
        updateData(list, value, index, isSelected, cellHasFocus);
        return panel;
    }

    void init() {
        panel = new JPanel();
        panel.setLayout(new MigLayout("insets 0 5 0 0", "[grow,fill]rel[right]", "[]0[]"));
        panel.setOpaque(true);
        panel.setBackground(color_normal);
        addressLabel = new JLabel("");
        panel.add(addressLabel, "");
        addressLabel.setOpaque(false);

        button_remove = new JButton("x");
        //panel.add(button_remove,"align right");
        button_remove.setOpaque(false);
        button_remove.setContentAreaFilled(false);
        button_remove.setBorderPainted(false);
        button_remove.setMargin(new Insets(0, 10, 0, 10));
        button_remove.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e);
            }
        });

    }

    void updateData(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        addressLabel.setText(value.toString());
        if (isSelected) {
            panel.setBackground(color_selected);
        } else {
            panel.setBackground(color_normal);
        }
    }

}
