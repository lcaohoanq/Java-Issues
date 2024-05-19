package views;

import constants.ResourcesPath;
import controllers.MusicPlayerController;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Hashtable;
import models.Song;
import styles.UIColor;
import styles.UISize;

public class MusicPlayerView extends JFrame {

    private MusicPlayerController musicPlayerController;

    // allow us to use file explorer in our app
    private JFileChooser jFileChooser;

    private JLabel songTitle, songArtist;
    private JPanel playbackBtns;
    private JSlider playbackSlider;
    JLabel songImage;
    JToolBar toolBar;
    JMenuBar menuBar;
    JMenu songMenu;
    JMenuItem createPlaylist;
    JMenuItem loadPlaylist;
    JMenuItem loadSong;
    JMenu playlistMenu;
    File selectedFile;

    public MusicPlayerView(){
        // calls JFrame constructor to configure out gui and set the title heaader to "Music Player"
        super("Music Player");

        // set the width and height
        setSize(UISize.MUSIC_PLAYER_WIDTH, UISize.MUSIC_PLAYER_HEIGHT);

        // end process when app is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // launch the app at the center of the screen
        setLocationRelativeTo(null);

        // prevent the app from being resized
        setResizable(false);

        // set layout to null which allows us to control the (x, y) coordinates of our components
        // and also set the height and width
        setLayout(null);

        // change the frame color
        getContentPane().setBackground(UIColor.FRAME_COLOR);

        musicPlayerController = new MusicPlayerController(this);
        jFileChooser = new JFileChooser();

        // set a default path for file explorer
        jFileChooser.setCurrentDirectory(new File(ResourcesPath.CURRENT_DIRECTORY));

        // filter file chooser to only see .mp3 files
        jFileChooser.setFileFilter(new FileNameExtensionFilter("MP3", "mp3"));

        addGuiComponents();
    }

    private void addGuiComponents(){
        // add toolbar
        addToolbar();

        // load record image
        songImage = new JLabel(loadImage(ResourcesPath.SONG_IMAGE));
        songImage.setBounds(0, 50, getWidth() - 20, 225);
        add(songImage);

        // song title
        songTitle = new JLabel("Song Title");
        songTitle.setBounds(0, 285, getWidth() - 10, 30);
        songTitle.setFont(new Font("Dialog", Font.BOLD, 24));
        songTitle.setForeground(UIColor.TEXT_COLOR);
        songTitle.setHorizontalAlignment(SwingConstants.CENTER);
        add(songTitle);

        // song artist
        songArtist = new JLabel("Artist");
        songArtist.setBounds(0, 315, getWidth() - 10, 30);
        songArtist.setFont(new Font("Dialog", Font.PLAIN, 24));
        songArtist.setForeground(UIColor.TEXT_COLOR);
        songArtist.setHorizontalAlignment(SwingConstants.CENTER);
        add(songArtist);

        // playback slider
        playbackSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        playbackSlider.setBounds(getWidth()/2 - 300/2, 365, 300, 40);
        playbackSlider.setBackground(null);
        playbackSlider.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // when the user is holding the tick we want to the pause the song
                musicPlayerController.pauseSong();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // when the user drops the tick
                JSlider source = (JSlider) e.getSource();

                // get the frame value from where the user wants to playback to
                int frame = source.getValue();

                // update the current frame in the music player to this frame
                musicPlayerController.setCurrentFrame(frame);

                // update current time in milli as well
                musicPlayerController.setCurrentTimeInMilli((int) (frame / (2.08 * musicPlayerController.getCurrentSong().getFrameRatePerMilliseconds())));

                // resume the song
                musicPlayerController.playCurrentSong();

                // toggle on pause button and toggle off play button
                enablePauseButtonDisablePlayButton();
            }
        });
        add(playbackSlider);

        // playback buttons (i.e. previous, play, next)
        addPlaybackBtns();
    }

    private void addToolbar(){
        toolBar = new JToolBar();
        toolBar.setBounds(0, 0, getWidth(), 20);

        // prevent toolbar from being moved
        toolBar.setFloatable(false);

        // add drop down menu
        menuBar = new JMenuBar();
        toolBar.add(menuBar);

        // now we will add a song menu where we will place the loading song option
        songMenu = new JMenu("Song");
        menuBar.add(songMenu);

        // add the "load song" item in the songMenu
        loadSong = new JMenuItem("Load Song");
        loadSong.addActionListener(e -> {
            // an integer is returned to us to let us know what the user did
            int result = jFileChooser.showOpenDialog(MusicPlayerView.this);
            selectedFile = jFileChooser.getSelectedFile();

            // this means that we are also checking to see if the user pressed the "open" button
            if(result == JFileChooser.APPROVE_OPTION && selectedFile != null){
                // create a song obj based on selected file
                Song song = new Song(selectedFile.getPath());

                // load song in music player
                musicPlayerController.loadSong(song);

                // update song title and artist
                updateSongTitleAndArtist(song);

                // update playback slider
                updatePlaybackSlider(song);

                // toggle on pause button and toggle off play button
                enablePauseButtonDisablePlayButton();
            }
        });
        songMenu.add(loadSong);

        // now we will add the playlist menu
        playlistMenu = new JMenu("Playlist");
        menuBar.add(playlistMenu);

        // then add the items to the playlist menu
        createPlaylist = new JMenuItem("Create Playlist");
        createPlaylist.addActionListener(e -> {
            // load music playlist dialog
            new MusicPlaylistDialog(MusicPlayerView.this).setVisible(true);
        });
        playlistMenu.add(createPlaylist);

        loadPlaylist = new JMenuItem("Load Playlist");
        loadPlaylist.addActionListener(e -> {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setFileFilter(new FileNameExtensionFilter("Playlist", "txt"));
            jFileChooser.setCurrentDirectory(new File(ResourcesPath.CURRENT_DIRECTORY));

            int result = jFileChooser.showOpenDialog(MusicPlayerView.this);
            selectedFile = jFileChooser.getSelectedFile();

            if(result == JFileChooser.APPROVE_OPTION && selectedFile != null){
                // stop the music
                musicPlayerController.stopSong();

                // load playlist
                musicPlayerController.loadPlaylist(selectedFile);
            }
        });
        playlistMenu.add(loadPlaylist);

        add(toolBar);
    }

    private void addPlaybackBtns(){
        playbackBtns = new JPanel();
        playbackBtns.setBounds(0, 435, getWidth() - 10, 80);
        playbackBtns.setBackground(null);

        // previous button
        JButton prevButton = new JButton(loadImage(ResourcesPath.PREVIOUS_BUTTON));
        prevButton.setBorderPainted(false);
        prevButton.setBackground(null);
        prevButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        prevButton.addActionListener(e -> {
            // go to the previous song
            musicPlayerController.prevSong();
        });
        playbackBtns.add(prevButton);

        // play button
        JButton playButton = new JButton(loadImage(ResourcesPath.PLAY_BUTTON));
        playButton.setBorderPainted(false);
        playButton.setBackground(null);
        playButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        playButton.addActionListener(e -> {
            // toggle off play button and toggle on pause button
            enablePauseButtonDisablePlayButton();

            // play or resume song
            musicPlayerController.playCurrentSong();
        });
        playbackBtns.add(playButton);

        // pause button
        JButton pauseButton = new JButton(loadImage(ResourcesPath.PAUSE_BUTTON));
        pauseButton.setBorderPainted(false);
        pauseButton.setBackground(null);
        pauseButton.setVisible(false);
        pauseButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pauseButton.addActionListener(e -> {
            // toggle off pause button and toggle on play button
            enablePlayButtonDisablePauseButton();

            // pause the song
            musicPlayerController.pauseSong();
        });
        playbackBtns.add(pauseButton);

        // next button
        JButton nextButton = new JButton(loadImage(ResourcesPath.NEXT_BUTTON));
        nextButton.setBorderPainted(false);
        nextButton.setBackground(null);
        nextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        nextButton.addActionListener(e -> {
            // go to the next song
            musicPlayerController.nextSong();
        });
        playbackBtns.add(nextButton);

        add(playbackBtns);
    }

    // this will be used to update our slider from the music player class
    public void setPlaybackSliderValue(int frame){
        playbackSlider.setValue(frame);
    }

    public void updateSongTitleAndArtist(Song song){
        songTitle.setText(song.getSongTitle());
        songArtist.setText(song.getSongArtist());
    }

    public void updatePlaybackSlider(Song song){
        // update max count for slider
        playbackSlider.setMaximum(song.getMp3File().getFrameCount());

        // create the song length label
        Hashtable<Integer, JLabel> labelTable = new Hashtable<>();

        // beginning will be 00:00
        JLabel labelBeginning = new JLabel("00:00");
        labelBeginning.setFont(new Font("Dialog", Font.BOLD, 18));
        labelBeginning.setForeground(UIColor.TEXT_COLOR);

        // end will vary depending on the song
        JLabel labelEnd =  new JLabel(song.getSongLength());
        labelEnd.setFont(new Font("Dialog", Font.BOLD, 18));
        labelEnd.setForeground(UIColor.TEXT_COLOR);

        labelTable.put(0, labelBeginning);
        labelTable.put(song.getMp3File().getFrameCount(), labelEnd);

        playbackSlider.setLabelTable(labelTable);
        playbackSlider.setPaintLabels(true);
    }

    public void enablePauseButtonDisablePlayButton(){
        // retrieve reference to play button from playbackBtns panel
        JButton playButton = (JButton) playbackBtns.getComponent(1);
        JButton pauseButton = (JButton) playbackBtns.getComponent(2);

        // turn off play button
        playButton.setVisible(false);
        playButton.setEnabled(false);

        // turn on pause button
        pauseButton.setVisible(true);
        pauseButton.setEnabled(true);
    }

    public void enablePlayButtonDisablePauseButton(){
        // retrieve reference to play button from playbackBtns panel
        JButton playButton = (JButton) playbackBtns.getComponent(1);
        JButton pauseButton = (JButton) playbackBtns.getComponent(2);

        // turn on play button
        playButton.setVisible(true);
        playButton.setEnabled(true);

        // turn off pause button
        pauseButton.setVisible(false);
        pauseButton.setEnabled(false);
    }

    private ImageIcon loadImage(String imagePath){
        try{
            // read the image file from the given path
            BufferedImage image = ImageIO.read(getClass().getResource(imagePath));

            // returns an image icon so that our component can render the image
            return new ImageIcon(image);
        }catch(Exception e){
            System.out.println(e.getMessage() + " " + imagePath);
        }

        // could not find resource
        return null;
    }
}









