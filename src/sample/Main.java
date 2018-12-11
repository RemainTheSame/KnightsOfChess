package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
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
        //Scene newGame = new Scene(root, 1080,720);
        primaryStage.setScene(mainMenu);

        //Create and add canvas to root group
        Canvas canvas = new Canvas(1080, 720);
        Pane mainPane = new Pane();
        //root.getChildren().add(canvas);
        root.getChildren().add(mainPane);

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


        //Text setup for canvas
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Font mainFont = Font.font(50);
        gc.setFont(mainFont);
        Text newGame = new Text("New Game");
        Text quitGame = new Text( "Quit");
        Font textFont = new Font(50);
        newGame.setFont(textFont);
        quitGame.setFont(textFont);
        //TextFlow newFlow = new TextFlow(newGame);
        //TextFlow quitFlow = new TextFlow(quitGame);
        //quitFlow.setLayoutX(200);
        //quitFlow.setLayoutY(300);
        //newFlow.setLayoutX(200);
        //newFlow.setLayoutY(200);
        //mainPane.getChildren().addAll(newFlow, quitFlow);

        Label quitLabel = new Label("Quit");
        Label newLabel = new Label("New Game");

        mainPane.getChildren().addAll(quitLabel, newLabel);
        quitLabel.setLayoutX(200);
        newLabel.setLayoutX(300);
        newLabel.setLayoutY(300);
        quitLabel.setLayoutY(200);



        /*
        //gc text
        gc.fillText(newGame.getText(),100,100);
        gc.fillText(quitGame.getText(), 100, 200);
        */


        //Mouse click options
        mainMenu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //Check if mouse click is within a objects area
                //if(targetData.containsPoint(x,y))...

                if(newLabel.contains(event.getX(), event.getY())){
                    System.out.println("New Game pressed");
                }
                if(quitLabel.contains(event.getX(), event.getY())){
                    System.out.println("Quit pressed");
                }
            }
        });

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
