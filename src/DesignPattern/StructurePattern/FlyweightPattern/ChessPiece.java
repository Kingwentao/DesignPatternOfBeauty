package DesignPattern.StructurePattern.FlyweightPattern;

/**
 * author: WentaoKing
 * created on: 2020/3/11
 * description: 棋子
 */
public class ChessPiece {

    private ChessPieceUnit chessPieceUnit;

    private int positionX;
    private int positionY;

    public ChessPiece(ChessPieceUnit chessPieceUnit, int positionX, int positionY) {
        this.chessPieceUnit = chessPieceUnit;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public static enum Color { RED, BLACK }
}
