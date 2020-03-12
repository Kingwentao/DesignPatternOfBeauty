package DesignPattern.StructurePattern.FlyweightPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * author: WentaoKing
 * created on: 2020/3/11
 * description: 享元模式棋子的工厂类
 */
public class ChessPieceUnitFactory {

    //缓存已经创建过的享元对象，来达到复用的目的。
    private static final Map<Integer, ChessPieceUnit> chessPieces = new HashMap<>();

    static {
        chessPieces.put(1, new ChessPieceUnit(1, "車", ChessPieceUnit.Color.BLACK));
        chessPieces.put(2, new ChessPieceUnit(2, "馬", ChessPieceUnit.Color.BLACK));
        //...省略摆放其他棋子的代码...
    }

    public static ChessPieceUnit getChessPiece(int chessPieceId) {
        return chessPieces.get(chessPieceId);
    }
}
