package com.example.skipsnakebit;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Player {
    private Circle gamePiece;
    int xPosition;
    int yPosition;
    int currentPiecePosition;

    static GameBoard gameBoard=new GameBoard();
    Player(int tileSize, Color pieceColor){
        this.currentPiecePosition=1;
        this.xPosition=gameBoard.getXValue(currentPiecePosition);
        this.yPosition=gameBoard.getYValue(currentPiecePosition);


        gamePiece=new Circle(tileSize/2);
        gamePiece.setFill(pieceColor);
        gamePiece.setTranslateX(this.xPosition);
        gamePiece.setTranslateY(this.yPosition);
    }

    //    public void reStarting(Player player,int currentPiecePosition){
//        if(currentPiecePosition==1){
//            player.xPosition=gameBoard.getXValue(1);
//            player.yPosition=gameBoard.getYValue(1);
//
//            gamePiece.setTranslateX(player.xPosition);
//            gamePiece.setTranslateY(player.yPosition);
//        }
//    }
    public String checkWinning(int Position){
        String check = "";
        if(Position==100){
//            snakeLadder.gameStart=false;
//            snakeLadder.turnOnePlayer=false;
//            snakeLadder.turnTwoPlayer=false;
            check="WON";
            currentPiecePosition=1;
            //  gamePiece.setTranslateX();
        }
        return check;
    }


    public void movePlayer(int diceValue){
        if(currentPiecePosition+diceValue<=100){
            currentPiecePosition+=diceValue;
            translatePlayer();
        }
    }

    private void translatePlayer(){
        this.xPosition=gameBoard.getXValue(this.currentPiecePosition);
        this.yPosition=gameBoard.getYValue(this.currentPiecePosition);

        gamePiece.setTranslateX(this.xPosition);
        gamePiece.setTranslateY(this.yPosition);
    }
    public void playerAtSnakeOrLadder(){
        int newPosition=gameBoard.playerPositionAtSnakeOrLadder(this.currentPiecePosition);
        if(newPosition!=-1){
            this.currentPiecePosition=newPosition;
            translatePlayer();
        }
    }
    public Circle getGamePiece(){
        return this.gamePiece;
    }
}
