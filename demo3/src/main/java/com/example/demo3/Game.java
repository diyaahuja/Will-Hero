package com.example.demo3;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.swing.plaf.ColorUIResource;
import java.io.IOException;

public class Game extends Application {

    public static Stage myStage;
    private Group hero;

    @Override
    public void start(Stage stage) throws IOException {
        /*
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);
        stage.setTitle("Will Hero!");
        stage.setScene(scene);
        stage.show();
         */

        myStage=stage;

        Rectangle R=new Rectangle(100,300,50,50);
        R.setFill(javafx.scene.paint.Color.BLUE);

        //Parent root=FXMLLoader.load(HelloApplication.class.getResource("Game.fxml"));

        hero=new Group(R);
        //hero.setTranslateX(200);
        //hero.setTranslateY(220);
        //Timeline T=new Timeline();
        //T.setCycleCount(Timeline.INDEFINITE);
        //T.play();

        stage.setTitle("Will Hero!");
        Scene scene=new Scene(hero,600,500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}