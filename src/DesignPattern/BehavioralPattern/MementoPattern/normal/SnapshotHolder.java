package DesignPattern.BehavioralPattern.MementoPattern.normal;

import DesignPattern.BehavioralPattern.MementoPattern.optimization.Snapshot;

import java.util.Stack;

/**
 * author: WentaoKing
 * created on: 2020/4/13
 * description: 快照支持类
 */
public class SnapshotHolder {

    private Stack<Snapshot> snapshots = new Stack<>();

    public Snapshot popSnapshot() {
        return snapshots.pop();
    }

    public void pushSnapshot(Snapshot snapshot) {
        snapshots.push(snapshot);
    }

}
