package com.example.demo3;
import javafx.animation.*;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.paint.ImagePattern;
import javafx.scene.image.Image;
import javafx.scene.image.*;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.scene.Group;
import javafx.scene.paint.Color;


public class Game extends Application {

    @FXML
    private static Rectangle rect;
    Group root = new Group();

    @FXML
    private Label location;

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

    private Group add_coins(double x) {
        Group coins=new Group();
        ImageView coin1 = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\main\\resources\\Coin.jpg", 50, 50, false, true));
        ImageView coin2 = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\main\\resources\\Coin.jpg", 50, 50, false, true));
        ImageView coin3 = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\main\\resources\\Coin.jpg", 50, 50, false, true));
        coins.getChildren().add(coin1);
        coin1.setX(x);
        coin2.setX(coin1.getX()+60);
        coin3.setX(coin2.getX()+60);
        coins.getChildren().add(coin2);
        coins.getChildren().add(coin3);
        coins.setLayoutY(100);
        return coins;
    }


    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("Game.fxml"));
        ImageView background=new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\main\\clouds.jpg",900,630,false,true));

        location=new Label("0");
        location.setLayoutX(450);
        location.setLayoutY(50);

        location.setTextFill(Color.BLACK);

        location.setFont(Font.font("Palatino Linotype Bold",30));
        location.setStyle("-fx-font-weight: bold");




        //Rectangle rect=new Rectangle();
        // Image img = new Image("src/main/java/com/example/demo3/hero.jpg");
        // rect.setFill(new ImagePattern(img));

        HashMap<Double,String> objs=new HashMap<>();

        /*
        for(int i=4;i<102;i++) {
            objs.put(i*100,300);
        }
        */

        Group objects=new Group();

        double k=10;

        Random random=new Random();

            for (int i = 0; i < 27; i++) {
                ImageView platform = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\platforms.gif", 300, 100, false, true));
                //ImageView platform=new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\main\\images\\Islands"+(i+1)+".png"));

                if(i!=0) {
                    int r1 = random.nextInt(3);
                    if (r1 == 0) {
                        //platform.setScaleX(1.25);
                        platform.setY(350);
                    } else if (r1 == 1) {
                        platform.setY(300);
                    } else {
                        platform.setY(400);
                    }
                }
                else platform.setY(350);

                platform.setX(k);
                //k+=600+(50*j);
                objects.getChildren().add(platform);
                objs.put(platform.getX(), "platform" + (i + 1));

                ImageView tree1 = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\Tree4.png", 150, 200, false, true));
                tree1.setX(k + 130);
                tree1.setY(platform.getY() - 200);
                objects.getChildren().add(tree1);
                objs.put(platform.getX(), "tree1" + (i + 1));

                ImageView tree2 = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\Tree2.png", 30, 75, false, true));
                tree2.setX(k+20);
                tree2.setY(platform.getY() - 75);
                objects.getChildren().add(tree2);
                objs.put(platform.getX(), "tree2" + (i + 1));

                if(i!=0) {

                    int r2 = random.nextInt(4);

                    if (i % 4 == 0) {

                        ImageView windmill = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\windmill.gif", 175, 200, false, true));
                        windmill.setX(k + 130);
                        windmill.setY(platform.getY() - 200);
                        objects.getChildren().add(windmill);
                        objs.put(platform.getX(), "windmill" + (i + 1));
                        tree1.setOpacity(0);
                        tree2.setOpacity(0);
                        if (i % 12 == 0) {
                            windmill.setX(k + 160);
                        }
                        if ((r2 == 1 || r2==0) && i % 12 == 0) {
                            windmill.setY(platform.getY() - 210);
                        }
                        //Group coins=add_coins(platform.getX());
                        objects.getChildren().add(add_coins(platform.getX()));
                    }
                        //int r2=0;
                        if (r2 == 0) {
                            tree2.setOpacity(0);
                            if (i % 12 == 0) {
                                platform.setScaleX(1.5);
                                platform.setScaleY(1.25);

                                ImageView green_orc = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\green orc.jpg", 50, 50, false, true));
                                green_orc.setX(k + 10);
                                green_orc.setY(platform.getY() - 60);
                                objects.getChildren().add(green_orc);
                                objs.put(platform.getX(), "green_orc" + (i + 1));
                            } else {
                                ImageView green_orc = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\green orc.jpg", 50, 50, false, true));
                                green_orc.setX(k + 80);
                                green_orc.setY(platform.getY() - 50);
                                objects.getChildren().add(green_orc);
                                objs.put(platform.getX(), "green_orc" + (i + 1));
                            }
                        } else if (r2 == 1) {

                            tree2.setOpacity(0);

                            if (i % 12 == 0) {
                                platform.setScaleX(1.5);
                                platform.setScaleY(1.25);


                                ImageView red_orc = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\redorc.jpg", 50, 50, false, true));
                                red_orc.setX(k + 10);
                                red_orc.setY(platform.getY() - 60);
                                objects.getChildren().add(red_orc);
                                objs.put(platform.getX(), "red_orc" + (i + 1));
                            } else {
                                ImageView red_orc = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\redorc.jpg", 50, 50, false, true));
                                red_orc.setX(k + 80);
                                red_orc.setY(platform.getY() - 50);
                                objects.getChildren().add(red_orc);
                                objs.put(platform.getX(), "red_orc" + (i + 1));
                            }
                        } else if (r2 == 3 && i % 3 != 0) {
                            ImageView coin_chest = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\coin chest.jpg", 100, 75, false, true));
                            coin_chest.setX(k + 150);
                            coin_chest.setY(platform.getY() - 75);
                            objects.getChildren().add(coin_chest);
                            objs.put(platform.getX(), "coin_chest" + (i + 1));

                            tree1.setOpacity(0);
                            if (i % 4 == 0) {
                                coin_chest.setX(k + 110);
                            }
                        }
                        if (i % 3 == 0) {
                            ImageView weapon_chest = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\weapon chest.gif", 100, 75, false, true));
                            weapon_chest.setX(k + 160);
                            weapon_chest.setY(platform.getY() - 75);
                            objects.getChildren().add(weapon_chest);
                            objs.put(platform.getX(), "weapon_chest" + (i + 1));

                            tree1.setOpacity(0);
                            if (i % 12 == 0) {
                                weapon_chest.setX(k + 110);
                            }
                            if (i % 12 == 0 && (r2 == 1 || r2==0)) {
                                weapon_chest.setY(platform.getY() - 85);
                            }
                        }

                }
                k = platform.getLayoutBounds().getMaxX() + 100;
            }

        ImageView platform = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\platforms.gif", 1200, 100, false, true));
        platform.setLayoutX(10710);
        platform.setY(350);
        objects.getChildren().add(platform);
        objs.put(platform.getX(), "boss_platform");

        ImageView boss_orc = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\OrcBoss.png", 200, 200, false, true));
        boss_orc.setX(11235);
        boss_orc.setY(platform.getY()-200);
        objects.getChildren().add(boss_orc);
        objs.put(platform.getX(), "orc_boss");


        Group A=new Group();
        A.getChildren().add(background);
        A.getChildren().add(location);
        A.getChildren().add(objects);
        A.getChildren().add(fxmlLoader.load());

        /*
        rect.setHeight(50);
        rect.setWidth(50);

        //StackPane root=new StackPane();
        //root.getChildren().add(rect);

        ImageView I=new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\hero.gif",50,50,false,true));
        //ImageView I=new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\hero.jpg"));
        //root.getChildren().add(I);

        Group B=new Group(rect,I);
        //Group A = new Group(fxmlLoader.load(),B);
        A.getChildren().add(B);


        B.relocate(50,250);

        TranslateTransition trans= new TranslateTransition();
        trans.setDuration(Duration.seconds(0.5));
        trans.setToY(-200);

        trans.setAutoReverse(true);
        trans.setCycleCount(Animation.INDEFINITE);
        trans.setNode(B);
        trans.play();
        */
        Scene scene=new Scene(A,900,630);

        move(scene,objects);

        stage.setScene(scene);
        stage.setTitle("Will Hero!");
        stage.setResizable(false);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}

/*
package com.example.demo3;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable{
    @FXML
    private Label welcomeText;

    @FXML
    Rectangle rect;

    public void initialize(URL url, ResourceBundle rb){
        //code
    }



    private void translate(Rectangle r, boolean reverse, int duration,int count){
        TranslateTransition trans= new TranslateTransition();
        trans.setDuration(Duration.seconds(duration));
        trans.setToY(-200);

        trans.setAutoReverse(reverse);
        trans.setCycleCount(count);
        //-1 for indefinite
        trans.setNode(r);
        trans.play();
    }
    @FXML
    private void play(ActionEvent event){
        translate(rect, true, 1, -1);
        //for button - onaction event
    }

}

FXML PART:

<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.layout.AnchorPane?>
<?import javafx.scene.shape.Rectangle?>

<AnchorPane prefHeight="500.0" prefWidth="600.0" style="-fx-background-color: #87CEEB;" xmlns="http://javafx.com/javafx/17" xmlns:fx="http://javafx.com/fxml/1" fx:controller="com.example.demo3.Game">
   <children>
      <Rectangle fx:id="rect" arcHeight="5.0" arcWidth="5.0" fill="DODGERBLUE" height="83.0" layoutX="86.0" layoutY="292.0" stroke="BLACK" strokeType="INSIDE" width="99.0" />
   </children>
</AnchorPane>

 */