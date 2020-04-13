package DesignPattern.BehavioralPattern.MementoPattern.normal;

import java.util.Stack;

/**
 * author: WentaoKing
 * created on: 2020/4/13
 * description: 快照支持类
 */
public class SnapshotHolder {

    private Stack<InputText> snapshots = new Stack<>();

    public InputText popSnapshot() {
        return snapshots.pop();
    }

    public void pushSnapshot(InputText inputText) {
        InputText deepClonedInputText = new InputText();
        deepClonedInputText.setText(inputText.getText());
        snapshots.push(deepClonedInputText);
    }


}
