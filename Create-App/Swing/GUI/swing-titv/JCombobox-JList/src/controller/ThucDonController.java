package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import view.ThucDonView;

public class ThucDonController implements ActionListener {

  private ThucDonView thucDonView;

  public ThucDonController(ThucDonView thucDonView) {
    this.thucDonView = thucDonView;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    //neu nguoi dung khong chon mon an chinh thi sao
    String monChinh = thucDonView.jComboBox_MonChinh.getSelectedItem().toString();
    System.out.println("Mon chinh(controller): " + monChinh);
    Object[] luaCHonMonPhu = thucDonView.jList_MonPhu.getSelectedValuesList().toArray(new String[0]);

    String monPhu = "";
    for(Object item: luaCHonMonPhu){
      System.out.println("Mon phu(controller): " + item);
      monPhu = monPhu+item.toString()+"; ";
    }

    thucDonView.thucDonModel.setLuaChon_monChinh(monChinh);
    thucDonView.thucDonModel.setLuaChon_monPhu(monPhu);
    thucDonView.thucDonModel.tinhTongTien();
    thucDonView.hienThiKetQua();

  }
}
