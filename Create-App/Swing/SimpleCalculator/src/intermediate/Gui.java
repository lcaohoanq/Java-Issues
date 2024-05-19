package intermediate;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Gui extends JPanel implements ActionListener {

    JPanel panel_tf = new JPanel(new BorderLayout());
    JPanel panel_buttons = new JPanel(new GridLayout(5,3));
    JButton button;
    JTextArea ta = new JTextArea(3,50);


    // Set a custom font for the JTextArea
    Font fontCustom = new Font("Roboto", Font.PLAIN, 20); // You can adjust the font family, style, and size

    String[] btn = {"1","2","3","4","5","6","7","8","9","0","+","-","*","/","="};
    public Gui(){
        initGUI();
    }
    
    private void initGUI(){
        setLayout(new BorderLayout());
        

//        JTextField tf =  new JTextField(50);
//        panel_tf.add(tf, BorderLayout.CENTER); //tf sẽ vô giữa toàn khung// xíu add vô panel tổng thì set lại NORTH
        JScrollPane scrollPane = new JScrollPane(ta); // Set the horizontal and vertical alignment to right and bottom

        ta.setAlignmentX(Component.RIGHT_ALIGNMENT);
        ta.setAlignmentY(Component.BOTTOM_ALIGNMENT);

        ta.setLineWrap(true);//xuống dòng tự động
        ta.setEditable(false);//không cho chỉnh sửa
        ta.setFont(fontCustom); // Apply the font to the JTextArea
        panel_tf.add(scrollPane, BorderLayout.CENTER);


        //tạo 1 mảng string rồi add vô dần cho nhanh

//        for(int i = 0; i < 15; i ++){
//            JButton button = new JButton(btn[i]);
//            panel_buttons.add(button);
//        }

        //su dung foreach de add cac button vao panel_buttons va duyet
        for(String btnText: btn){
            button = new JButton(btnText);
            button.addActionListener(this);
            panel_buttons.add(button);
        }
        
        add(panel_tf, BorderLayout.NORTH);
        add(panel_buttons, BorderLayout.CENTER);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
//        System.out.println(button.getText());

        //lay text cua button
        String btnText = ((JButton)e.getSource()).getText();
        ta.append(btnText + " ");

    }
}
