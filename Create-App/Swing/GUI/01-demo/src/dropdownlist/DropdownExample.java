package dropdownlist;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DropdownExample {

  public static void main(String[] args) {
    // Create a JFrame
    JFrame frame = new JFrame("Dropdown Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 200);

    // Create a default ComboBoxModel
    DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
    comboBoxModel.addElement("Option 1");
    comboBoxModel.addElement("Option 2");
    comboBoxModel.addElement("Option 3");

    // Create a JComboBox with the ComboBoxModel
    JComboBox<String> comboBox = new JComboBox<>(comboBoxModel);

    // Create a JLabel to display the selected item
    JLabel selectedLabel = new JLabel("Selected: ");

    // Add an ActionListener to the JComboBox to handle item selection
    comboBox.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String selectedOption = (String) comboBox.getSelectedItem();
        selectedLabel.setText("Selected: " + selectedOption);
      }
    });

    // Create a JPanel to hold the components
    JPanel panel = new JPanel();
    panel.add(comboBox);
    panel.add(selectedLabel);

    // Add the panel to the frame
    frame.getContentPane().add(panel);

    // Set the frame visibility
    frame.setVisible(true);
  }
}

