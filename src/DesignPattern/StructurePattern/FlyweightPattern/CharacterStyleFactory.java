package DesignPattern.StructurePattern.FlyweightPattern;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * author: WentaoKing
 * created on: 2020/3/12
 * description: 字体格式的工厂类
 */
public class CharacterStyleFactory {

    //存储字体格式的风格
    private static final List<CharacterStyle> styles = new ArrayList<>();

    //查询所要的字体风格，如果存在就返回
    public static CharacterStyle getStyle(Font font, int size, int colorRGB) {

        CharacterStyle newStyle = new CharacterStyle(font, size, colorRGB);
        for (CharacterStyle style: styles){
            if (styles.equals(newStyle)){
                return style;
            }
        }
        styles.add(newStyle);
        return newStyle;
    }
}
