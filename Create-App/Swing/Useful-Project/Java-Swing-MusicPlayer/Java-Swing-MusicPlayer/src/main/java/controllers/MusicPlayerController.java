package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import java.io.*;
import java.util.ArrayList;
import models.Song;
import views.MusicPlayerView;

public class MusicPlayerController extends PlaybackListener implements ActionListener {
    // this will be used to update isPaused more synchronously
    private static final Object playSignal = new Object();

    // need reference so that we can update the gui in this class
    private MusicPlayerView musicPlayerView;

    // we will need a way to store our song's details, so we will be creating a song class
    private Song currentSong;
    public Song getCurrentSong(){
        return currentSong;
    }

    private ArrayList<Song> playlist;

    // we will need to keep track the index we are in the playlist
    private int currentPlaylistIndex;

    // use JLayer library to create an AdvancedPlayer obj which will handle playing the music
    private AdvancedPlayer advancedPlayer;

    // pause boolean flag used to indicate whether the player has been paused
    private boolean isPaused;

    // boolean flag used to tell when the song has finished
    private boolean songFinished;

    private boolean pressedNext, pressedPrev;

    // stores in teh last frame when the playback is finished (used for pausing and resuming)
    private int currentFrame;
    public void setCurrentFrame(int frame){
        currentFrame = frame;
    }

    // track how many milliseconds has passed since playing the song (used for updating the slider)
    private int currentTimeInMilli;
    public void setCurrentTimeInMilli(int timeInMilli){
        currentTimeInMilli = timeInMilli;
    }

    // constructor
    public MusicPlayerController(MusicPlayerView musicPlayerView){
        this.musicPlayerView = musicPlayerView;
    }

    public void loadSong(Song song){
        currentSong = song;
        playlist = null;

        // stop the song if possible
        if(!songFinished)
            stopSong();

        // play the current song if not null
        if(currentSong != null){
            // reset frame
            currentFrame = 0;

            // reset current time in milli
            currentTimeInMilli = 0;

            // update gui
            musicPlayerView.setPlaybackSliderValue(0);

            playCurrentSong();
        }
    }

    public void loadPlaylist(File playlistFile){
        playlist = new ArrayList<>();

        // store the paths from the text file into the playlist array list
        try{
            FileReader fileReader = new FileReader(playlistFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // reach each line from the text file and store the text into the songPath variable
            String songPath;
            while((songPath = bufferedReader.readLine()) != null){
                // create song object based on song path
                Song song = new Song(songPath);

                // add to playlist array list
                playlist.add(song);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        if(playlist.size() > 0){
            // reset playback slider
            musicPlayerView.setPlaybackSliderValue(0);
            currentTimeInMilli = 0;

            // update current song to the first song in the playlist
            currentSong = playlist.get(0);

            // start from the beginning frame
            currentFrame = 0;

            // update gui
            musicPlayerView.enablePauseButtonDisablePlayButton();
            musicPlayerView.updateSongTitleAndArtist(currentSong);
            musicPlayerView.updatePlaybackSlider(currentSong);

            // start song
            playCurrentSong();
        }
    }

    public void pauseSong(){
        if(advancedPlayer != null){
            // update isPaused flag
            isPaused = true;

            // then we want to stop the player
            stopSong();
        }
    }

    public void stopSong(){
        if(advancedPlayer != null){
            advancedPlayer.stop();
            advancedPlayer.close();
            advancedPlayer = null;
        }
    }

    public void nextSong(){
        // no need to go to the next song if there is no playlist
        if(playlist == null) return;

        // check to see if we have reached the end of the playlist, if so then don't do anything
        if(currentPlaylistIndex + 1 > playlist.size() - 1) return;

        pressedNext = true;

        // stop the song if possible
        if(!songFinished)
            stopSong();

        // increase current playlist index
        currentPlaylistIndex++;

        // update current song
        currentSong = playlist.get(currentPlaylistIndex);

        // reset frame
        currentFrame = 0;

        // reset current time in milli
        currentTimeInMilli = 0;

        // update gui
        musicPlayerView.enablePauseButtonDisablePlayButton();
        musicPlayerView.updateSongTitleAndArtist(currentSong);
        musicPlayerView.updatePlaybackSlider(currentSong);

        // play the song
        playCurrentSong();
    }

    public void prevSong(){
        // no need to go to the next song if there is no playlist
        if(playlist == null) return;

        // check to see if we can go to the previous song
        if(currentPlaylistIndex - 1 < 0) return;

        pressedPrev = true;

        // stop the song if possible
        if(!songFinished)
            stopSong();

        // decrease current playlist index
        currentPlaylistIndex--;

        // update current song
        currentSong = playlist.get(currentPlaylistIndex);

        // reset frame
        currentFrame = 0;

        // reset current time in milli
        currentTimeInMilli = 0;

        // update gui
        musicPlayerView.enablePauseButtonDisablePlayButton();
        musicPlayerView.updateSongTitleAndArtist(currentSong);
        musicPlayerView.updatePlaybackSlider(currentSong);

        // play the song
        playCurrentSong();
    }

    public void playCurrentSong(){
        if(currentSong == null) return;

        try{
            // read mp3 audio data
            FileInputStream fileInputStream = new FileInputStream(currentSong.getFilePath());
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            // create a new advanced player
            advancedPlayer = new AdvancedPlayer(bufferedInputStream);
            advancedPlayer.setPlayBackListener(this);

            // start music
            startMusicThread();

            // start playback slider thread
            startPlaybackSliderThread();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    // create a thread that will handle playing the music
    private void startMusicThread(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    if(isPaused){
                        synchronized(playSignal){
                            // update flag
                            isPaused = false;

                            // notify the other thread to continue (makes sure that isPaused is updated to false properly)
                            playSignal.notify();
                        }

                        // resume music from last frame
                        advancedPlayer.play(currentFrame, Integer.MAX_VALUE);
                    }else{
                        // play music from the beginning
                        advancedPlayer.play();
                    }
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }).start();
    }

    // create a thread that will handle updating the slider
    private void startPlaybackSliderThread(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                if(isPaused){
                    try{
                        // wait till it gets notified by other thread to continue
                        // makes sure that isPaused boolean flag updates to false before continuing
                        synchronized(playSignal){
                            playSignal.wait();
                        }
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }

                while(!isPaused && !songFinished && !pressedNext && !pressedPrev){
                    try{
                        // increment current time milli
                        currentTimeInMilli++;

                        // calculate into frame value
                        int calculatedFrame = (int) ((double) currentTimeInMilli * 2.08 * currentSong.getFrameRatePerMilliseconds());

                        // update gui
                        musicPlayerView.setPlaybackSliderValue(calculatedFrame);

                        // mimic 1 millisecond using thread.sleep
                        Thread.sleep(1);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        }).start();
    }

    @Override
    public void playbackStarted(PlaybackEvent evt) {
        // this method gets called in the beginning of the song
        System.out.println("Playback Started");
        songFinished = false;
        pressedNext = false;
        pressedPrev = false;
    }

    @Override
    public void playbackFinished(PlaybackEvent evt) {
        // this method gets called when the song finishes or if the player gets closed
        System.out.println("Playback Finished");
        if(isPaused){
            currentFrame += (int) ((double) evt.getFrame() * currentSong.getFrameRatePerMilliseconds());
        }else{
            // if the user pressed next or prev we don't need to execute the rest of the code
            if(pressedNext || pressedPrev) return;

            // when the song ends
            songFinished = true;

            if(playlist == null){
                // update gui
                musicPlayerView.enablePlayButtonDisablePauseButton();
            }else{
                // last song in the playlist
                if(currentPlaylistIndex == playlist.size() - 1){
                    // update gui
                    musicPlayerView.enablePlayButtonDisablePauseButton();
                }else{
                    // go to the next song in the playlist
                    nextSong();
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}




















