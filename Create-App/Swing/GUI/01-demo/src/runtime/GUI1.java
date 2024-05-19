package runtime;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUI1 extends JFrame implements ActionListener {
    
    public GUI1() {
        
        JPanel panel = new JPanel(new FlowLayout()); //tạo một đối tượng tạo layout

//        panel.add(new JLabel("Test Button: "));
//        panel.add(new JButton("Click me!"));
        JLabel label = new JLabel("Number of click: 0");
        panel.add(label);
        
        JButton button = new JButton("Click me!");
        panel.add(button);
        
        this.setContentPane(panel);
        
        button.addActionListener(this);
        
        this.setSize(640, 480);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setVisible(true);
        
    }
    
    public static void main(String[] args) {
        GUI1 program = new GUI1();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "You clicked the button!");
    }
    //ta có thể thấy cách làm này sẽ chỉ sử dụng được 1 action cho cả ứng dụng
    //tăng tính linh hoạt hơn -> sử dụng anonymous class -> GUI2
}

/*
Đối tượng JFrame là một cửa sổ (window) cho phép chúng ta đóng, thay đổi kích thước và có thể đặt các điều khiển. 
Một cửa sổ có thể được khởi tạo trong phương thức khởi tạo của một lớp kế thừa lớp JFrame (ví dụ MainClass)

Các điều khiển không thể đặt trực tiếp đến cửa sổ mà phải được đặt trong đối tượng JPanel. 
Như vậy, muốn thêm các điều khiển như button, text box, combo box, v.v. đến cửa sổ, đầu tiên chúng ta phải tạo một điều khiển JPanel:
 */
