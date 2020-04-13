package DesignPattern.BehavioralPattern.MementoPattern.normal;

/**
 * author: WentaoKing
 * created on: 2020/4/13
 * description:
 */
public class InputText {

    private StringBuilder text = new StringBuilder();

    public String getText(){
        return text.toString();
    }

    public void append(String input){
        text.append(input);
    }

    public void setText(String text){
        this.text.replace(0,text.length(),text);
    }

}
