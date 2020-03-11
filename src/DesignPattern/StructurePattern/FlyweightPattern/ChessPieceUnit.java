package DesignPattern.StructurePattern.FlyweightPattern;

/**
 * author: WentaoKing
 * created on: 2020/3/11
 * description: 棋子的相似对象抽出来，设计成单独的类
 */
public class ChessPieceUnit {
    private int id;
    private String text;
    private Color color;

    public ChessPieceUnit(int id, String text, Color color) {
        this.id = id;
        this.text = text;
        this.color = color;
    }

    public static enum Color {RED, BLACK}
}
