package mx12b;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class App extends JPanel implements ActionListener {

  JLabel manufacturer = new JLabel("CASIO");
  JButton energy = new JButton();
  JLabel model = new JLabel("MX-12B");

  JTextArea viewerV2 = new JTextArea(3, 50); //height, width

  //    JTextField viewerV1 = new JTextField(50); //height, width
  JPanel topPanel = new JPanel(new BorderLayout()); //để mặc định cũng được

  JPanel midPanel = new JPanel(new FlowLayout());

  JPanel bottomPanel = new JPanel(new GridLayout(6, 5, 5, 5));

  String[] buttonList = {"", "", "", "%", "MU",
      "MC", "MR", "M-", "M+", "/",
      "+/_", "7", "8", "9", "X",
      "|>", "4", "5", "6", "-",
      "C/AC", "1", "2", "3", "+",
      "0", "00", ".", "=", "+"};

  JButton button = null;

  String isDigitCal = Regex.IS_DIGIT_CALCULATOR.getRegex();

  int countFunction = 0; //

  public App() {
    initApp();
  }

  //  Config element zone
  private void config() {
    configEnergy();
    configViewerV2();
  }

  private void configEnergy() {
    energy.setBackground(Color.YELLOW);
  }

  private void configViewerV2() {
    viewerV2.setEditable(false);
    viewerV2.setLineWrap(true);
    viewerV2.setWrapStyleWord(true);
  }
  //  Config element zone

  //init elementZone

  private void initButton() {
    for (String item : buttonList) {
      button = new JButton(item);
      if (item.isEmpty()) {
        button.setEnabled(false);
      }
      if (item.equals(Regex.IS_DIGIT.getRegex())) {
        button.setBackground(Color.GRAY);
        button.setForeground(Color.WHITE);
      }
//      if(item.equals("|>")){
//        String text = viewerV2.getText();
//        if (text.length() > 0) {
//          String updatedText = text.substring(0, text.length() - 1);
//          viewerV2.setText(updatedText);
//        }
//        //"|>" xóa 1 kí tự
//      }
//      if(item.equals("C/AC")){
//        viewerV2.setText("");
//      }

      button.addActionListener(this);
      bottomPanel.add(button); //grid 6x5
    }
  }

  //init elementZone

  private void init() {
    //viet them
    initButton();
  }

  private void layoutManager() {
    topPanel.add(manufacturer, BorderLayout.WEST);
    topPanel.add(energy, BorderLayout.CENTER);
    topPanel.add(model, BorderLayout.EAST);

    //vì việc dùng JTextField mình khó có thể line wrapping được
    midPanel.add(viewerV2);
    setLayout(new BorderLayout());
    add(topPanel, BorderLayout.NORTH);
    add(midPanel, BorderLayout.CENTER);
    add(bottomPanel, BorderLayout.SOUTH);
  }

  private void initApp() {
    config();
    init();
    layoutManager();
  }

  private void isNumber() {

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    JButton btn = (JButton) e.getSource();
    String btnValue = btn.getText();
    handleFunction(btnValue); //nếu mà nhấn các nút chức năng sẽ không có in ra trên viewerV2
    handlePress(btnValue);
    handleExpression();
    handleEqual(btnValue);
    handleClear(btnValue);

    //khi mình nhấn dấu = thì sẽ tính toán và set lại viewerV2 là kết quả và

  }

  private void handlePress(String btnValue) {
//nếu bấm lần đầu thì cho nối bình thường
    //bấm lần thứ 2 sẽ nối rỗng
    System.out.println("Giá trị của btnValue: " + btnValue);
    if (!btnValue.matches(isDigitCal)) {
      //nếu là kí tự không phải số
      countFunction = ++countFunction;
      if (countFunction == 3) {
        countFunction = 0;
        viewerV2.append("");
      } else {
        viewerV2.append(btnValue + " ");
      }
    } else {
      viewerV2.append(btnValue + " ");
    }
  }

  private void handleExpression() {
    String text = viewerV2.getText();
    Pattern pattern = Pattern.compile("(\\d+)\\s*([+\\-*/])\\s*(\\d+)");
    Matcher matcher = pattern.matcher(text);
    System.out.println("Giá trị của viewerV2: " + text);
    System.out.println("Giá trị của matcher: " + matcher);
    if (matcher.find()) {
      String[] result = new String[]{
          matcher.group(1),  // First number
          matcher.group(2),  // Operator
          matcher.group(3)   // Second number
      };

      // Print the array elements
      for (String element : result) {
        System.out.println(element);
      }
    }
  }

  private void handleEqual(String btnValue) {
    if (btnValue.equals("=")) {
      //tính toán
      //tạo ra 3 element lưu 3 phần tử
      //xử lí chuỗi tách ra 3 phần tử có dạng số phép tính số và lưu vào 3 element
//      viewerV2.setText("");//set lại viewerV2

      //set lại viewerV2
      //set lại countFunction
      //set lại countEqual
    }
  }

  private void handleClear(String btnValue) {
    if (btnValue.equals("|>") || btnValue.equals("C/AC")) {
      viewerV2.setText("");
    }
  }

  private void handleFunction(String btnValue) {
    if (!btnValue.equals(Regex.IS_OPERATOR.getRegex()) && !btnValue.equals(
        Regex.IS_DIGIT.getRegex())) {
      viewerV2.append("");
    }
  }

}
