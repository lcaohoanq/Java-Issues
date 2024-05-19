package view;

import constants.Message;
import controller.ThucDonController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import model.ThucDonModel;

public class ThucDonView extends JFrame {

  public ThucDonModel thucDonModel;
  JPanel jPanel_TieuDe, jPanel_MonChinh, jPanel_MonPhu, jPanel_LuaChon, jPanel_ThanhToan;
  JLabel header;
  public ButtonGroup buttonGroup_MonChinh, buttonGroup_MonPhu;
  JLabel jLabel_ThongTin;
  JButton jButton_ThanhToan;
  Font font = new Font("Arial", Font.BOLD, 20);
  public ArrayList<JCheckBox> list_buttonGroup_MonPhu;
  public JComboBox<String> jComboBox_MonChinh;
  public JList<String> jList_MonPhu;
  public ThucDonView() {
    this.thucDonModel = new ThucDonModel();
    init();
  }

  private void init() {
    this.setTitle("Thuc Don");
    this.setSize(600, 600);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());

    header = new JLabel("Thuc Don Nha Hang", JLabel.CENTER);
    header.setForeground(Color.RED);
    header.setFont(font);

    jPanel_TieuDe = new JPanel();
    jPanel_TieuDe.add(header);
    this.add(jPanel_TieuDe, BorderLayout.NORTH);

    jPanel_MonChinh = new JPanel();
    jPanel_MonChinh.setLayout(new FlowLayout());
    String[] cacMonChinh = {"Com", "Pho", "Bun"};
    jComboBox_MonChinh = new JComboBox<String>(cacMonChinh);
    jComboBox_MonChinh.setFont(font);
    jPanel_MonChinh.add(jComboBox_MonChinh);

    //TODO Mon phu
    jPanel_MonPhu = new JPanel();
    //? Mon phu co the chon nhieu mon, nen ta dung JCheckBox
    jPanel_MonPhu.setLayout(new GridLayout(2, 2));

    String[] cacMonPhu = {"Ca", "Ga", "Bo", "Heo"};
    jList_MonPhu = new JList<String>(cacMonPhu);
    jList_MonPhu.setFont(font);
    jPanel_MonPhu.add(jList_MonPhu);
    //Su dung ctrl de chon nhieu mon

    //TODO JPanel Lua chon
    jPanel_LuaChon = new JPanel();
    jPanel_LuaChon.setLayout(new BorderLayout());
    jPanel_LuaChon.add(jPanel_MonChinh,BorderLayout.NORTH);
    jPanel_LuaChon.add(jPanel_MonPhu,BorderLayout.CENTER);
    this.add(jPanel_LuaChon, BorderLayout.CENTER);

    //TODO ActionListener
    ActionListener ac = new ThucDonController(this);

    jPanel_ThanhToan = new JPanel(new GridLayout(1, 2));
    jLabel_ThongTin = new JLabel("Thong Tin");
//    jLabel_ThongTin.setFont(font);
    jButton_ThanhToan = new JButton("Thanh Toan");
    jButton_ThanhToan.setFont(font);
    jButton_ThanhToan.setBackground(Color.GREEN);
    jButton_ThanhToan.addActionListener(ac);
    jPanel_ThanhToan.add(jLabel_ThongTin);
    jPanel_ThanhToan.add(jButton_ThanhToan);
    this.add(jPanel_ThanhToan, BorderLayout.SOUTH);

    this.setVisible(true);
  }
  public void hienThiKetQua(){
    String thongTin = "";
    thongTin += "Mon Chinh: "+this.thucDonModel.getLuaChon_monChinh();
    thongTin += " Mon Phu: "+this.thucDonModel.getLuaChon_monPhu();
    thongTin += " Tong tien: " + String.valueOf(formattingCurrency(this.thucDonModel.getTongTien()) + " VND");
    this.jLabel_ThongTin.setText(thongTin);
    Message.IS_TOTAL_PRICE(thongTin);
  }

  private String formattingCurrency(long result) {
    NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
    return numberFormat.format(result);
  }

}

