package com.example.lab3javafx;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Signal extends Observer {
    int count;
    int start;
    String file;
    Media sound;
    MediaPlayer mediaPlayer;
    Boolean state;

    public Signal(Subject subject) {
        this.count = 0;
        this.state = false;
        this.start = 0;
        this.file = "";
        this.sound = new Media(new File(file).toURI().toString());
        this.mediaPlayer = new MediaPlayer(sound);
    }

    public void onComp(int count) {
        this.count = count;
        this.state = true;
    }

    public void offComp() {
        this.state = false;
        mediaPlayer.stop();
    }

    public void delComo() {
        mediaPlayer.stop();
    }

    @Override
    public void update(int state) {
        if (this.state) {
            if (state == start + count) {
                mediaPlayer.play();
                start += count;
            }
            if (state == start + 2) {
                mediaPlayer.stop();
                this.state = false;
            }
        }
    }
}