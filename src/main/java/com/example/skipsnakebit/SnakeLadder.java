package com.example.skipsnakebit;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeLadder extends Application {
    public final int tileSize=40;
       int width=10;
       int height =10;
       int  yLine=430;
       int diceValue;
       Label randResult;
       boolean gameStart=true,turnOnePlayer=true,turnTwoPlayer=false;
       Group tileGroup = new Group();

       Player playerOne,playerTwo;
    public Pane createContent(){
        Pane root = new Pane();
        root.setPrefSize(width*tileSize,height*tileSize+80);
        root.getChildren().addAll(tileGroup);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                Tile tile=new Tile(tileSize,tileSize);
                tile.setTranslateX(j*tileSize);
                tile.setTranslateY(i*tileSize);
                tileGroup.getChildren().addAll(tile);

            }
        }//create three button and a label;
         randResult=new Label("start the game");
        randResult.setTranslateX(150);
        randResult.setTranslateY(yLine-20);


        Button playerOneButton=new Button("Player One");
        playerOneButton.setTranslateX(20);
        playerOneButton.setTranslateY(yLine);
        playerOneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (gameStart == true) {
                    if(turnOnePlayer==true){
                        getDiceValue();
                        playerOne.movePlayer(diceValue);
                        playerOne.playerAtSnakeOrLadder();
                        turnOnePlayer=false;
                        turnTwoPlayer=true;
                    }
                }

            }
        });

        Button playerTwoButton=new Button("Player Two");
        playerTwoButton.setTranslateX(300);
        playerTwoButton.setTranslateY(yLine);
        playerTwoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (gameStart == true) {
                    if(turnTwoPlayer==true){
                        getDiceValue();
                        playerTwo.movePlayer(diceValue);
                        playerTwo.playerAtSnakeOrLadder();
                        turnTwoPlayer=false;
                        turnOnePlayer=true;
                    }
                }

            }
        });


         Button startGame=new Button("Start Game");
         startGame.setTranslateX(150);
         startGame.setTranslateY(yLine);

        playerOne=new Player(tileSize, Color.BLACK);
        playerTwo=new Player(tileSize-10,Color.WHITE);

        Image img=new Image("C:\\Users\\SURENDRA YADAV\\SKIPSnakebit\\src\\snakeboard.jpg");
        ImageView boardImage=new ImageView();
        boardImage.setImage(img);
        boardImage.setFitWidth(tileSize*width);
        boardImage.setFitHeight(tileSize*height);

       tileGroup.getChildren().addAll(boardImage,
               randResult,playerOneButton,
               playerTwoButton,startGame,
               playerOne.getGamePiece(),playerTwo.getGamePiece()
       );

        return root;
    }

    //method for random dicevalue
    private void getDiceValue(){
        diceValue=(int)(Math.random()*6+1);
        randResult.setText(Integer.toString(diceValue));
    }
    @Override
    public void start(Stage stage) throws IOException {
      //  FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("SKIPSnakebit");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}