package model;

import java.util.StringTokenizer;

public class ThucDonModel {

  private String luaChon_monChinh;
  private String luaChon_monPhu;
  private long tongTien;

  public ThucDonModel() {
    this.luaChon_monChinh = "";
    this.luaChon_monPhu = "";
    this.tongTien = 0;
  }

  public String getLuaChon_monChinh() {
    return luaChon_monChinh;
  }

  public void setLuaChon_monChinh(String luaChon_monChinh) {
    this.luaChon_monChinh = luaChon_monChinh;
  }

  public String getLuaChon_monPhu() {
    return luaChon_monPhu;
  }

  public void setLuaChon_monPhu(String luaChon_monPhu) {
    this.luaChon_monPhu = luaChon_monPhu;
  }

  public long getTongTien() {
    return tongTien;
  }

  public void setTongTien(long tongTien) {
    this.tongTien = tongTien;
  }

  public void tinhTongTien() {
    this.tongTien = 0;
    if (this.luaChon_monChinh.equals("Com")) {
      tongTien += 20000;
      System.out.println("Com");
    } else if (this.luaChon_monChinh.equals("Pho")) {
      tongTien += 25000;
      System.out.println("Pho");
    } else if (this.luaChon_monChinh.equals("Bun")) {
      tongTien += 15000;
      System.out.println("Bun");
    }
    //! split moi mon an phu bang dau ;
    StringTokenizer stk = new StringTokenizer(this.luaChon_monPhu, ";");
    while (stk.hasMoreTokens()) {
      String monAnPhu = stk.nextToken();
      monAnPhu = monAnPhu.trim(); //xoa di dau cach o ben kia di :)))))))
      if (monAnPhu.equals("Ca")) {
        tongTien += 30000;
        System.out.println("Ca");
      } else if (monAnPhu.equals("Ga")) {
        tongTien += 25000;
        System.out.println("Ga");
      } else if (monAnPhu.equals("Bo")) {
        tongTien += 35000;
        System.out.println("Bo");
      } else if (monAnPhu.equals("Heo")) {
        tongTien += 20000;
        System.out.println("Heo");
      }
    }
  }
}
