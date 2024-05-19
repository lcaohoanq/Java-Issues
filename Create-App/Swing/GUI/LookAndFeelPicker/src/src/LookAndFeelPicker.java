/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

/**
 *
 * @author Admin
 */
import java.awt.BorderLayout;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class LookAndFeelPicker extends JFrame 
{
    
    public LookAndFeelPicker(JFrame target)
    {
        setTitle("Style Picker");
        InitControls(target);
        pack();
        setVisible(true);
    }
    
    
    private void InitControls(JFrame target)
    {
        //Panels
        JPanel pnlContent = new JPanel();
        pnlContent.setLayout(new BorderLayout());
        getContentPane().add(pnlContent);
        
        //Labels
        JLabel lblInstructions = new JLabel("Please select a style:");
        pnlContent.add(lblInstructions, BorderLayout.PAGE_START);
        
        //List
        DefaultListModel dlmListData = new DefaultListModel();
        JList lstStyles = new JList(dlmListData);
        LookAndFeelInfo[] lafInfo = UIManager.getInstalledLookAndFeels();
        for(LookAndFeelInfo laf : lafInfo)
        {
            dlmListData.addElement(laf.getName());
        }
        lstStyles.addListSelectionListener(new StyleSelectionHandler(target));
        pnlContent.add(lstStyles, BorderLayout.CENTER);
    }
}

class StyleSelectionHandler implements ListSelectionListener
{
    private JFrame jfrFrameToUpdate;
    
    public StyleSelectionHandler(JFrame mainFrame)
    {
        jfrFrameToUpdate = mainFrame;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) 
    { 
        JList lstStyles = (JList)e.getSource();
        if(!lstStyles.isSelectionEmpty())
        {
            try {
                UIManager.setLookAndFeel(
                  UIManager.getInstalledLookAndFeels()[lstStyles.getSelectedIndex()].getClassName());
                SwingUtilities.updateComponentTreeUI(jfrFrameToUpdate);
            } catch (ClassNotFoundException | InstantiationException
                    | IllegalAccessException | UnsupportedLookAndFeelException e1) {
                System.out.println(e1.getMessage());
            }
        }
    }
}
