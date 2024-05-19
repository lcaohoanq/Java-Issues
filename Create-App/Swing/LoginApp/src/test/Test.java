package test;

import view.LoginFormView;

public class Test {

  public static void main(String[] args) {
    try {
      new LoginFormView();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
