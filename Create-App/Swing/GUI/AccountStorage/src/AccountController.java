import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AccountController implements ActionListener {

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

  private boolean isEmptyField(String username, String password, String accountType) {
    return username.isEmpty() || password.isEmpty() || accountType.isEmpty();
  }

  private void writeFile(String url) {
    BufferedWriter bufferedWriter = null;
    try {
      File file = new File(url);
      if (!file.exists()) {
        file.createNewFile();
      }
      FileWriter fileWriter = new FileWriter(file);
      bufferedWriter = new BufferedWriter(fileWriter);
      bufferedWriter.write("Hello World");
      bufferedWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
