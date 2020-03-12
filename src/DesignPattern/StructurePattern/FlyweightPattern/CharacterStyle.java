package DesignPattern.StructurePattern.FlyweightPattern;

import java.awt.*;

/**
 * author: WentaoKing
 * created on: 2020/3/12
 * description: 字体格式
 */
public class CharacterStyle {

    private Font font;
    private int size;
    private int colorRGB;

    public CharacterStyle(Font font, int size, int colorRGB) {
        this.font = font;
        this.size = size;
        this.colorRGB = colorRGB;
    }

    @Override
    public boolean equals(Object obj) {
        CharacterStyle otherStyle = (CharacterStyle) obj;

        return font.equals(otherStyle.font)
                && size == otherStyle.size
                && colorRGB == otherStyle.colorRGB;
    }
}
