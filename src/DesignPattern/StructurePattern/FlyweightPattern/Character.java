package DesignPattern.StructurePattern.FlyweightPattern;

import java.awt.*;

/**
 * author: WentaoKing
 * created on: 2020/3/12
 * description: 文字属性
 */
public class Character {

    private char c;
    private CharacterStyle characterStyle;

    public Character(char c,CharacterStyle characterStyle){
        this.c = c;
        this.characterStyle = characterStyle;
    }

}
