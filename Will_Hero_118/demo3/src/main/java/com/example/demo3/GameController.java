package com.example.demo3;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;



public class GameController implements Initializable{
    @FXML
    private Label location;

    @FXML
    private AnchorPane saveme_tab;


    TranslateTransition trans= new TranslateTransition();

    @FXML
    private Button btn;

    @FXML
    Rectangle rect;
    @FXML
    AnchorPane name;

    private void move(Scene scene, Group objects) {
        final int[] count = {0};
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                TranslateTransition transition=new TranslateTransition();
                transition.setByX(-105);
                transition.setDuration(Duration.seconds(0.1));
                //transition.setCycleCount(Animation.INDEFINITE);
                transition.setNode(objects);
                transition.play();
                count[0]++;
                location.setText(Integer.toString(count[0]));
            }
        });
    }

    public void initialize(URL url, ResourceBundle rb){
        //code
        //rect.setX(50);
        //rect.setY(250);
        //ImageView I=new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\hero.gif",50,50,false,true));
        rect.setFill(new ImagePattern(new Image(Thread.currentThread().getContextClassLoader().getResourceAsStream("hero.gif"),50,50,false,true)));
    }



    private void translate(Rectangle r, boolean reverse, double duration,int count){

        trans.setDuration(Duration.seconds(duration));
        //System.out.println(rect.getX());
        trans.setToY(r.getX()-150);

        trans.setAutoReverse(reverse);
        trans.setCycleCount(count);
        //-1 for indefinite
        trans.setNode(r);
        trans.play();
    }


    @FXML
    private void saveme(){
        //code for save me tab transition


    }


    @FXML
    private void play(ActionEvent event){
        btn.setOpacity(0);
        playernameslide();



        //for button - play onaction event
    }


    private void playernameslide() {


        trans.setDuration(Duration.seconds(0.5));
        System.out.println(111);
        trans.setByY(-500);
        //-1 for indefinite
        trans.setNode(name);
        trans.play();

    }


    @FXML
    private void startgame() {
        name.setOpacity(0);


        translate(rect, true, 0.5, -1);
//button for enter in player name

    }

}