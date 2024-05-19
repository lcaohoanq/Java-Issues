import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AccountView extends JPanel implements ActionListener, KeyListener {

  ArrayList<Account> accountList = new ArrayList<>();
  String url = "D:\\PERSONAL\\java\\PROJECT\\GUI\\AccountStorage\\src\\account.txt";

  Pattern accountPattern = Pattern.compile("^\\[Account\\{type='\\w+',\\susername='\\w+',\\spassword='\\w+'\\}\\]$");
  private JPanel namePanel = new JPanel(new FlowLayout());
  private JLabel name = new JLabel("Account Storage");
  private JLabel accountType = new JLabel("Account Type");

  private JLabel usernameLabel = new JLabel("Username");
  private JLabel passwordLabel = new JLabel("Password");

  public static JTextField accountTypeField = new JTextField(15);

  public static JTextField usernameField = new JTextField(15);
  public static JTextField passwordField = new JTextField(15);

  private JButton submitButton = new JButton("Submit");
  private JButton writeButton = new JButton("Write");

  private JPanel container = new JPanel();

  private JPanel accountTypePanel = new JPanel(new FlowLayout());

  // layout username
  private JPanel usernamePanel = new JPanel(new FlowLayout());
  // layout password
  private JPanel passwordPanel = new JPanel(new FlowLayout());
  // layout button
  private JPanel buttonPanel = new JPanel(new FlowLayout());

  private Dimension dimension = new Dimension(80, 20);

  public AccountView() {
    initForm();
    readFile(url);
  }

  private void initForm() {
    setLayout(new BorderLayout());
    name.setFont(new Font("Arial", Font.BOLD, 15));

    accountTypePanel.add(accountType);
    accountTypePanel.add(accountTypeField);

    namePanel.add(name);

    usernamePanel.add(usernameLabel);
    usernamePanel.add(usernameField);

    passwordPanel.add(passwordLabel);
    passwordPanel.add(passwordField);

    submitButton.setBorder(new EmptyBorder(10, 10, 10, 10));
    submitButton.setBackground(Color.GREEN);
    submitButton.setForeground(Color.BLACK);
    submitButton.setPreferredSize(dimension);
    writeButton.setBorder(new EmptyBorder(10, 10, 10, 10));
    writeButton.setBackground(Color.RED);
    writeButton.setForeground(Color.WHITE);
    writeButton.setPreferredSize(dimension);
    buttonPanel.add(submitButton);
    buttonPanel.add(writeButton);

    container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
    container.add(name);
    container.add(accountTypePanel);
    container.add(usernamePanel);
    container.add(passwordPanel);
    container.add(buttonPanel);

    add(container, BorderLayout.CENTER);

    submitButton.addActionListener(new SubmitHandler());
    passwordField.addKeyListener(this);
//    submitButton.addActionListener(this);
    writeButton.addActionListener(new WriteHandler());
  }
  private boolean isEmptyField(String username, String password, String accountType) {
    return username.isEmpty() || password.isEmpty() || accountType.isEmpty();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    readFile(url);
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {
    if(e.getKeyCode() == 10){
      new SubmitHandler();
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {

  }

  public class WriteHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      String username = AccountView.usernameField.getText();
      String password = AccountView.passwordField.getText();
      String accountType = AccountView.accountTypeField.getText();
      String url = "D:\\PERSONAL\\java\\PROJECT\\GUI\\AccountStorage\\src\\account.txt";

      if (isEmptyField(username, password, accountType)) {
        Message.IS_EMPTY_FIELD();
      } else {
        Message.IS_WRITE_FILE_SUCCESS(url);
        writeFile(url);
      }
    }
    private boolean writeFile(String url) {
      if (accountList.isEmpty()) {
        Message.IS_NOTHING_TO_WRITE();
        return false;
      } else {
        BufferedWriter bufferedWriter = null;
        try {
          File file = new File(url);
          if (!file.exists()) {
            file.createNewFile();
          }
          FileWriter fileWriter = new FileWriter(file);
          bufferedWriter = new BufferedWriter(fileWriter);
//        bufferedWriter.write("Hello World");
          bufferedWriter.write(accountList.toString());
          bufferedWriter.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return true;
    }
  }
  private boolean readFile(String url){
    BufferedReader bufferedReader = null;
    try{
      FileReader fileReader = new FileReader(new File(url));
      bufferedReader = new BufferedReader(fileReader);
      String line;
      Pattern pattern = Pattern.compile("^\\[Account\\{type='(\\w+)',\\susername='(\\w+)',\\spassword='(\\w+)'\\}\\]$");
      //Account{type='facebook', username='abc', password='123'}
      //! xài capturing group mới dùng group được -> dấu ngoặc tron
      while((line=bufferedReader.readLine()) != null){
        Matcher matcher = pattern.matcher(line);
        if(matcher.find()){
          String type = matcher.group(1);
          String username = matcher.group(2);
          String password = matcher.group(3);
//          System.out.println("Group 1: " + type + " Group 2: " + username + " Group 3: " + password);

          Account account = new Account(type, username, password);
          accountList.add(account);

          System.out.println(accountList.toString());

        }
      }
      while(bufferedReader.readLine() != null){
        System.out.println(bufferedReader.readLine());
      }

    }catch (IOException e){
      e.printStackTrace();
    }
    return true;
  }
  public class SubmitHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      String username = AccountView.usernameField.getText();
      String password = AccountView.passwordField.getText();
      String accountType = AccountView.accountTypeField.getText();
      Account account = null;

      if (isEmptyField(username, password, accountType)) {
        Message.IS_EMPTY_FIELD();
      } else {
        account = new Account(accountType, username, password);
        accountList.add(account);
        System.out.println(accountList);
      }
    }

  }
}













