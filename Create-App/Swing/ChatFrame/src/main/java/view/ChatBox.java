package view;

import utils.DateTimeUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;

public class ChatBox extends JFrame {

    private final JMenuBar menuBar = new JMenuBar();
    private final JMenu menu1 = new JMenu("FILE");
    private final JMenu menu2 = new JMenu("Help");
    private final JMenuItem menu11 = new JMenuItem("Open");
    private final JMenuItem menu12 = new JMenuItem("Save as");
    private final JMenuItem menu22 = new JMenuItem("About me");
    private final JPanel panel = new JPanel(new FlowLayout());
    private final JLabel label = new JLabel("Enter Text");
    private final JTextField textField = new JTextField(20); // accepts upto 10 characters
    private final JButton btnSend = new JButton("Send");
    private final JTextArea textArea = new JTextArea();
    private final JScrollPane scrollPane = new JScrollPane(textArea);
    private String tmp = "";
    private String url = "";
    String user = "";

    public ChatBox(String user){
        this.user = user;
        // ---------------------------------------------------------------------------------------------------------
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(this.getSize());
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
        init();
        doAction();
    }

    private void init(){
        // Creating the Frame
        this.setTitle("Chat Frame");
        this.setSize(400, 400);

        menuBar.add(menu1);
        menuBar.add(menu2);
        menu1.add(menu11); // File -> Open
        menu1.add(menu12); // File -> Save as
        menu2.add(menu22); // Help -> About me

        panel.add(label);
        panel.add(textField);
        panel.add(btnSend);

        textArea.setEditable(false);

        // Adding Components to the frame.
        this.getContentPane().add(BorderLayout.SOUTH, panel); // bottom chứa panel: textField, btnSend, btnReset
        this.getContentPane().add(BorderLayout.NORTH, menuBar); // top chứa menuBar: File, HELPS
        this.getContentPane().add(BorderLayout.CENTER, scrollPane); // giữa chứa text Area
    }

    void doAction(){
        // sự kiện
        btnSend.addActionListener(new ClickSend());
        textField.addKeyListener(new PressEnter());
        menu11.addActionListener(new OpenFile());
        menu12.addActionListener(new SaveFile());
        menu22.addActionListener(new AboutMe());
    }

    // bấm send là trên app sẽ in ra dòng mình nhập trong textField
    class ClickSend implements ActionListener {
        // why modifier private is not allowed here?

        @Override
        public void actionPerformed(ActionEvent e) {
            String time = DateTimeUtils.getDateTime();
//            textArea.append(textField.getText() + " Sended at: " + time + "\n");
            textArea.append(user + ": " + textField.getText() + "\n");
            textField.setText("");
        }

    }
    private class PressEnter implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
//            btnReset.setEnabled(true);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            // System.out.println("Key pressed code=" + e.getKeyCode() + ", char=" +
            // e.getKeyChar());
            // \n code = 10
            if (e.getKeyCode() == 10) {
                String time = DateTimeUtils.getDateTime();
//                textArea.append(textField.getText() + " Sended at: " + time + "\n");
                textArea.append(user + ": " + textField.getText() + "\n");
                textField.setText("");
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

    }

    private class OpenFile implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // JOptionPane.showMessageDialog(null, "You must choose the .txt file");

            // System.out.println("You must choose the .txt file"); //msg
            JFileChooser fileChooser = new JFileChooser();

            int returnValue = fileChooser.showOpenDialog(null);

            // if (returnValue == JFileChooser.APPROVE_OPTION) {
            // File selectedFile = fileChooser.getSelectedFile();
            // System.out.println(java.awt.Desktop.getDesktop().toString());
            //// try {
            ////// java.awt.Desktop.getDesktop().open(f);//<-- here
            ////
            //// } catch (IOException ex) {
            //// System.out.println("Loi roi");
            //// }
            // }
            // System.out.println(chooser.getDescription(f)); //trả ra tên ok //xíu xử lí
            // lỗi chỗ này
            // if (f.getName().contains("txt")) {
            // try {
            // //tạo 1 hàm đọc file và in ra console
            //
            // readFile(f.getPath());
            // } catch (Exception ex) {
            // System.out.println("Loi roi");
            // }
            // }
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                url = selectedFile.getAbsolutePath();

                try {
                    System.out.println("File Content: ");
                    tmp = readFile(url);
                    // JOptionPane.showMessageDialog(null, "File Read Successfully");
                    textArea.append(tmp);
//                    btnReset.setEnabled(true);
                } catch (Exception ex) {
                    System.out.println("File loi roi");
                }

            }
        }
    }

    private String readFile(String url) throws Exception {
        BufferedReader bufferedReader = null;
        String tmp = "";
        try {
            Reader reader = new FileReader(new File(url));
            bufferedReader = new BufferedReader(reader);

            String str;
            while ((str = bufferedReader.readLine()) != null) {
                tmp = tmp.concat(str).concat("\n");
                System.out.println(str);
            }

            System.out.println("File Read Successfully");

        } catch (Exception e) {
            throw new Exception("File loi roi");
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        return tmp;
    }

    // nâng cấp thêm tính năng
    // chọn directory nơi lưu file
    private boolean writeFile(String url) throws IOException {
        // nếu người dùng chưa bấm Open -> chưa mở file thì dữ liệu không truyền lên
        // được 2 biến này
        if (this.url.equals("") || this.tmp.equals("")) {

            return false;
        }
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        String urlOut = "D:\\PERSONAL\\java\\GUI\\03-ChatFrame\\src\\output\\openFile.txt";
        try {
            Reader reader = new FileReader(new File(url));
            bufferedReader = new BufferedReader(reader);

            Writer writer = new FileWriter(new File(urlOut));
            bufferedWriter = new BufferedWriter(writer);

            String str;
            while ((str = bufferedReader.readLine()) != null) {
                bufferedWriter.write(str);
            }

            writer.flush();// đợi save xong mới đóng
            JOptionPane.showMessageDialog(null, "File Writed Successfull At: " + urlOut);
            return true;
        } catch (Exception e) {
            System.out.println("Loi save file" + e);
            return false;
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        }
    }

    // hành động write file này khi ta nhập thông tin vào textField và nhấn send
    private boolean writeFile() throws IOException {
        String str = textArea.getText();

        System.out.println("Noi dung cua content: " + str);

        if (str.equals("")) {
            JOptionPane.showMessageDialog(null, "Nothing to save, Enter Text first");
            return false;
        }
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        String urlOut = "D:\\PERSONAL\\java\\GUI\\03-ChatFrame\\src\\output\\pressSend.txt";

        try {

            Reader reader = new StringReader(str);

            Writer writer = new FileWriter(new File(urlOut));

            bufferedReader = new BufferedReader(reader);

            bufferedWriter = new BufferedWriter(writer);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                writer.write(line);
                writer.write("\n");
            }
            writer.flush();// đợi save xong mới đóng
            JOptionPane.showMessageDialog(null, "File Writed Successfull At: " + urlOut);
            return true;
        } catch (Exception e) {
            System.out.println("Loi doc content Text Area");
            return false;
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }

        }

    }

    // save as: ghi file
    // có 2 trường hợp xảy ra
    // 1. mình load file vô rồi sẽ ghi ra -> nếu readFile sẽ có dữ liệu trên tmp và
    // path: url, đơm vô cái url này ghi ra một file ở destination nào đó (cố định)
    // 2. mình tạo một đoạn bằng send .. rồi ghi ra -> collect dữ liệu trong ta, cầm
    // cái đó ghi ra một file.txt (cái này không có url) mình sẽ dùng overload
    private class SaveFile implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String path = url;
                boolean isNotTextArea = textArea.getText().equals(""); // file này trống
                boolean isNotPath = path.equals(""); // path này trống
                if (isNotTextArea && isNotPath) {
                    JOptionPane.showMessageDialog(null, "You need to Open File or Enter Text first!");
                    // có 2 trường hợp, 1 là phải open file - 2 là viết gì đó vô
                } else if (isNotPath && !isNotTextArea) {
                    // nếu ta đọc file thì cũng quăng vô ta ->
                    // send -> quăng vô ta, nó sẽ bắt thằng này trước -> không ổn
                    // cách khác để xét: khi send ta không có url, và open file thì sẽ có url để
                    // identifier
                    writeFile();
                } else if (!isNotPath && !isNotTextArea) {
                    writeFile(path);
                }

            } catch (IOException ie) {
                System.out.println("Loi ghi file o Save File");
            }

        }

    }

    private class AboutMe implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "SIMPLE CHAT FRAME\n"
                    + "This is my first simple project when learning Java Swing, hope you guys enjoy ^^\n"
                    + "Author: lcaohoanq\n"
                    + "Github: https://github.com/lcaohoanq");
        }
    }

}
