package view;

import constant.Message;
import controller.ThucDonController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import model.ThucDonModel;

public class ThucDonView extends JFrame {

  public ThucDonModel thucDonModel;
  JPanel jPanel_TieuDe, jPanel_MonChinh, jPanel_MonPhu, jPanel_LuaChon, jPanel_ThanhToan;
  JLabel header;
  public ButtonGroup buttonGroup_MonChinh, buttonGroup_MonPhu;
  JRadioButton jRadioButton_Com, jRadioButton_Pho, jRadioButton_Bun;
  JCheckBox jCheckBox_Ca, jCheckBox_Ga, jCheckBox_Bo, jCheckBox_Heo;
  JLabel jLabel_ThongTin;
  JButton jButton_ThanhToan;
  Font font = new Font("Arial", Font.BOLD, 20);
  public ArrayList<JCheckBox> list_buttonGroup_MonPhu;

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
    jPanel_MonChinh.setLayout(new GridLayout(1, 3));
    //! JRadio Button
    jRadioButton_Com = new JRadioButton("Com");
    jRadioButton_Com.setFont(font);
    jRadioButton_Pho = new JRadioButton("Pho");
    jRadioButton_Pho.setFont(font);
    jRadioButton_Bun = new JRadioButton("Bun");
    jRadioButton_Bun.setFont(font);

    //Chi chon mot trong cac mon chinh khi dung JRadioButton
    //TODO nhom lai thanh mot khu vuc
    buttonGroup_MonChinh = new ButtonGroup();
    buttonGroup_MonChinh.add(jRadioButton_Com);
    buttonGroup_MonChinh.add(jRadioButton_Pho);
    buttonGroup_MonChinh.add(jRadioButton_Bun);
    //! Viec lam nay chi mang tinh y nghia rang chi duoc lua chon 1 trong cac mon chinh, thuoc ve JRadioButton
    //! Khong the add truc tiep vao JPanel

    //TODO Ta chi co the add tung thang mot
    jPanel_MonChinh.add(jRadioButton_Com);
    jPanel_MonChinh.add(jRadioButton_Pho);
    jPanel_MonChinh.add(jRadioButton_Bun);

    //TODO Mon phu
    jPanel_MonPhu = new JPanel();
    //? Mon phu co the chon nhieu mon, nen ta dung JCheckBox
    jPanel_MonPhu.setLayout(new GridLayout(2, 2));
    jCheckBox_Ca = new JCheckBox("Ca");
    jCheckBox_Ca.setFont(font);
    jCheckBox_Ga = new JCheckBox("Ga");
    jCheckBox_Ga.setFont(font);
    jCheckBox_Bo = new JCheckBox("Bo");
    jCheckBox_Bo.setFont(font);
    jCheckBox_Heo = new JCheckBox("Heo");
    jCheckBox_Heo.setFont(font);
    jPanel_MonPhu.add(jCheckBox_Ca);
    jPanel_MonPhu.add(jCheckBox_Ga);
    jPanel_MonPhu.add(jCheckBox_Bo);
    jPanel_MonPhu.add(jCheckBox_Heo);
    list_buttonGroup_MonPhu = new ArrayList<JCheckBox>();
    list_buttonGroup_MonPhu.add(jCheckBox_Ca);
    list_buttonGroup_MonPhu.add(jCheckBox_Ga);
    list_buttonGroup_MonPhu.add(jCheckBox_Bo);
    list_buttonGroup_MonPhu.add(jCheckBox_Heo);

    //TODO JPanel Lua chon
    jPanel_LuaChon = new JPanel();
    jPanel_LuaChon.setLayout(new GridLayout(2, 1));
    jPanel_LuaChon.add(jPanel_MonChinh);
    jPanel_LuaChon.add(jPanel_MonPhu);
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

