package com.example.lab3javafx;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class ComponentTwo extends Observer {
    private MediaPlayer mediaPlayer;
    private long restartInterval; // Время через которое перезапускать видео
    private MediaView mediaView;
    private int elapsedSeconds = 0;

    public ComponentTwo(Subject subject, String videoPath, long restartInterval, MediaView mediaView) {
        this.restartInterval = restartInterval;
        this.mediaView = mediaView;
        subject.attach(this);

        Media media = new Media(videoPath);
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);

        mediaPlayer.play();
    }

    @Override
    public void update(int state) {
        elapsedSeconds++;
        if (elapsedSeconds % this.restartInterval == 0) {
            mediaPlayer.stop();
            mediaPlayer.play();
            System.out.println("update");
        }
    }

    public void play() {
        mediaPlayer.play();
    }

    public void pause() {
        mediaPlayer.pause();
    }

    public void setVolume(double volume) {
        mediaPlayer.setVolume(volume);
    }
}