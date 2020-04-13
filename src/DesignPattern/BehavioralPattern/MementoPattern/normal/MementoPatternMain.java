package DesignPattern.BehavioralPattern.MementoPattern.normal;

import java.util.Scanner;

/**
 * author: WentaoKing
 * created on: 2020/4/13
 * description: 备忘录模式入口
 */
public class MementoPatternMain {
    public static void main(String[] args) {
        InputText inputText = new InputText();
        SnapshotHolder snapshotHolder = new SnapshotHolder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.equals(":list")) {
                System.out.println(inputText.getText());
            } else if (input.equals(":undo")) {
                InputText snapshot = snapshotHolder.popSnapshot();
                inputText.setText(snapshot.getText());
            } else {
                snapshotHolder.pushSnapshot(inputText);
                inputText.append(input);
            }
        }
    }
}
