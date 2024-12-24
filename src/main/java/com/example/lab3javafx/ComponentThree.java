package com.example.lab3javafx;

import javafx.animation.RotateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class ComponentThree extends Observer {
    private RotateTransition rotateTransition;
    private Pane animationPane; // Панель для отображения анимации
    private int elapsedSeconds = 0;
    private static final int ANIMATION_INTERVAL = 15; // Интервал анимации в секундах

    public ComponentThree(Subject subject, Pane animationPane) {
        this.animationPane = animationPane;
        subject.attach(this);

        // Создаем прямоугольник для анимации
        Rectangle loadingRect = new Rectangle(50, 50, Color.BLUE);
        loadingRect.setArcWidth(15); // Скругление углов
        loadingRect.setArcHeight(15);

        // Устанавливаем прямоугольник по центру панели
        loadingRect.setX(((animationPane.getWidth() - loadingRect.getWidth()) / 4)+300);
        loadingRect.setY((animationPane.getHeight() - loadingRect.getHeight()) / 4);

        // Добавляем прямоугольник на панель
        animationPane.getChildren().add(loadingRect);

        // Создаем RotateTransition для анимации
        rotateTransition = new RotateTransition(Duration.seconds(2), loadingRect);
        rotateTransition.setByAngle(360); // Вращение на 360 градусов
        rotateTransition.setCycleCount(5); // Анимация будет проигрываться один раз
    }

    @Override
    public void update(int state) {
        elapsedSeconds++;
        if (elapsedSeconds % ANIMATION_INTERVAL == 0) {
            // Запускаем анимацию
            rotateTransition.playFromStart();
            System.out.println("Animation started");
        }
    }
}