package com.example.lab3javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaView;

import java.nio.file.Paths;

public class HelloController {
    @FXML
    private MediaView mediaView;

    @FXML
    private Label timeLabel;

    @FXML
    private ImageView animationImageView;

    @FXML
    private Slider volumeSlider;
    @FXML
    private Pane animationPane;

    private TimeServer timeServer;
    private ComponentOne componentOne;
    private ComponentTwo componentTwo;
    private ComponentThree componentThree;

    @FXML
    public void initialize() {
        timeServer = new TimeServer();

        componentOne = new ComponentOne(timeServer, timeLabel);

        // Укажите путь к видеофайлу
        String videoPath2 = Paths.get("src/main/resources/com/example/lab3javafx/One year in 40 seconds (1).mp4").toUri().toString();

        componentTwo = new ComponentTwo(timeServer, videoPath2, 10, mediaView);

        // Установка громкости
        volumeSlider.valueProperty().addListener((obs, oldVal, newVal) -> componentTwo.setVolume(newVal.doubleValue()));

        componentThree = new ComponentThree(timeServer, animationPane);
    }

    @FXML
    private void onPlayButtonClick() {
        componentTwo.play();
    }

    @FXML
    private void onPauseButtonClick() {
        componentTwo.pause();
    }

    @FXML
    private void onVolumeChange() {
        double volume = volumeSlider.getValue();
        componentTwo.setVolume(volume);
    }
}