package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import view.ThucDonView;

public class ThucDonController implements ActionListener {

  private ThucDonView thucDonView;

  public ThucDonController(ThucDonView thucDonView) {
    this.thucDonView = thucDonView;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String monChinh = "";
    Enumeration<AbstractButton> buttons_monChinh = thucDonView.buttonGroup_MonChinh.getElements();
    while(buttons_monChinh.hasMoreElements()){
      AbstractButton item = buttons_monChinh.nextElement(); //lay ra
      if(item.isSelected()){
        monChinh = item.getText();
        System.out.println("Mon chinh(controller): " + monChinh);
        break;
      }
    }
    String monPhu = "";
    for(JCheckBox item: thucDonView.list_buttonGroup_MonPhu){
      if(item.isSelected()){
        monPhu = monPhu+item.getText()+"; ";
        System.out.println("Mon phu(controller): " + monPhu);
      }
    }
//    Enumeration<AbstractButton> buttons_monPhu = thucDonView.buttonGroup_MonChinh.getElements();
//    while(buttons_monPhu.hasMoreElements()){
//      AbstractButton item = buttons_monPhu.nextElement(); //lay ra
//      if(item.isSelected()){
//        monPhu = monPhu+item.getText()+"; ";
//        break;
//      }
//    }
    thucDonView.thucDonModel.setLuaChon_monChinh(monChinh);
    thucDonView.thucDonModel.setLuaChon_monPhu(monPhu);
    thucDonView.thucDonModel.tinhTongTien();
    thucDonView.hienThiKetQua();

  }
}
