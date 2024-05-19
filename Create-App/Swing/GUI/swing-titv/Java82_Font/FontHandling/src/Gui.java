import javax.swing.JFrame;

public class Gui extends JFrame {

    public Gui() {
        add(new App());

        this.setTitle("Font Handling");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Gui();
    }

}
