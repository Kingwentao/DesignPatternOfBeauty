package DesignPattern.BehavioralPattern.MementoPattern.normal;

import DesignPattern.BehavioralPattern.MementoPattern.optimization.Snapshot;

/**
 * author: WentaoKing
 * created on: 2020/4/13
 * description: text input
 */
public class InputText {

    private StringBuilder mText = new StringBuilder();

    public String getText() {
        return mText.toString();
    }

    public void append(String input) {
        mText.append(input);
    }

    public void restoreSnapshot(Snapshot snapshot) {
        mText.replace(0, mText.length(), snapshot.getText());
    }

    public Snapshot createSnapshot() {
        return new Snapshot(mText.toString());
    }
}
