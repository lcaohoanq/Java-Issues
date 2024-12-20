import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JPanel implements ActionListener {

    JLabel label;

    public App() {
        initApp();
    }

    public void initApp() {
        setLayout(new BorderLayout());

        JPanel jPanel_button = new JPanel(new GridLayout(2, 2));
        for (int i = 0; i < 4; i++) {
            JButton jButton = new JButton("" + i);
            jButton.setFont(new Font("Roboto", Font.BOLD, 25));
            jButton.addActionListener(this);
            jPanel_button.add(jButton);
        }

        add(jPanel_button, BorderLayout.CENTER);

        label = new JLabel("---", JLabel.CENTER);
        label.setFont(new Font("Roboto", Font.BOLD, 25));
        add(label, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("0")) {
            label.setText("Clicked button: 0");
        } else if (e.getActionCommand().equals("1")) {
            label.setText("Clicked button: 1");
        } else if (e.getActionCommand().equals("2")) {
            label.setText("Clicked button: 2");
        } else if (e.getActionCommand().equals("3")) {
            label.setText("Clicked button: 3");
        }
    }

}
