package DesignPattern.StructurePattern.FlyweightPattern;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * author: WentaoKing
 * created on: 2020/3/12
 * description: 编辑器
 */
public class Editor {

    private List<Character> chars = new ArrayList<>();

    public void appendCharacter(char c, Font font,int size,int colorRGB){
        //使用享元对象工厂类复用当前对象
        Character character = new Character(c,CharacterStyleFactory.getStyle(font,size,colorRGB));
        chars.add(character);
    }

}
