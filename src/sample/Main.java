package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        //Create new group as root node
        Group root = new Group();

        //Sets title and current scene as main menu
        primaryStage.setTitle("Knights Of Chess");
        Scene mainMenu = new Scene(root, 1080, 720);
        //String css = this.getClass().getResource("/Stylesheets/mainstyle.css").toExternalForm();
        mainMenu.getStylesheets().add("/Stylesheets/mainstyle.css");
        //Scene newGame = new Scene(root, 1080,720);
        primaryStage.setScene(mainMenu);

        //Create pane and vertical box
        Pane mainPane = new Pane();
        VBox menuBox = new VBox();

        //Setup labels with font
        //Font menuFont = new Font(50);
        Label quit = new Label("Quit");
        Label newGame = new Label("New Game");
        //quit.setFont(menuFont);
        //newGame.setFont(menuFont);

        //Add stylesheet to labels
        quit.getStyleClass().add("menuLabel");
        newGame.getStyleClass().add("menuLabel");


        //Add listeners to labels
        quit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.exit(0);
            }
        });
        newGame.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("New Game clicked");
            }
        });

        //Configure menuBox
        menuBox.setSpacing(30);
        //Adds the labels
        menuBox.getChildren().addAll(newGame,quit);
        menuBox.setLayoutY(300);
        menuBox.setLayoutX(300);

        //Add menuBox to the Pane
        mainPane.getChildren().add(menuBox);

        //Add mainPane to root group
        root.getChildren().add(mainPane);

        //General onKeyPress and Release
        ArrayList<String> input = new ArrayList<>();

        mainMenu.setOnKeyPressed(
                new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
                        String code = event.getCode().toString();

                        // adds once
                        if(!input.contains(code))
                            input.add(code);
                    }
                }
        );
        mainMenu.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                String code = event.getCode().toString();
                input.remove(code);
            }
        });

        //General mouse click options
        mainMenu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //Check if mouse click is within a objects area
                //if(targetData.containsPoint(x,y))...
            }
        });

        //Game loop setup
        final long startNanoTime = System.nanoTime();
        //Handle occurs 60 times per second
        new AnimationTimer(){
            public void handle(long currentNanoTime){
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;

                //Checks the input list for pressed keys and executes command
                if(input.contains("W")){
                    System.out.println("W being pressed");
                }
                if(input.contains("A")){
                    System.out.println("A being pressed");
                }
            }
        }.start();
        //Show the stage
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);



    }
}
