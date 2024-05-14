import javax.swing.*;
import views.MusicPlayerView;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new MusicPlayerView().setVisible(true);

//                models.Song song = new models.Song("src/assets/Wind Riders - Asher Fulero.mp3");
//                System.out.println(song.getSongTitle());
//                System.out.println(song.getSongArtist());
            }
        });
    }
}
