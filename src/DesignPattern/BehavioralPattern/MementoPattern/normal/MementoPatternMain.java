package DesignPattern.BehavioralPattern.MementoPattern.normal;

import DesignPattern.BehavioralPattern.MementoPattern.optimization.Snapshot;

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
                Snapshot snapshot = snapshotHolder.popSnapshot();
                inputText.restoreSnapshot(snapshot);
            } else {
                snapshotHolder.pushSnapshot(inputText.createSnapshot());
                inputText.append(input);
            }
        }
    }
}


/**
 * ### 如何优化内存和时间消耗
 * 假设每当有数据改动，我们都需要生成一个备份，以备之后恢复。如果需要备份的数据很大，这样高频率的备份，不管是对存储（内存或者硬盘）的消耗，还是对时间的消耗，
 * 都可能是无法接受的。想要解决这个问题，我们一般会采用“低频率全量备份”和“高频率增量备份”相结合的方法。
 * 全量备份就不用讲了，它跟我们上面的例子类似，就是把所有的数据“拍个快照”保存下来。所谓“增量备份”，指的是记录每次操作或数据变动。
 *
 *
 * 当我们需要恢复到某一时间点的备份的时候，如果这一时间点有做全量备份，我们直接拿来恢复就可以了。如果这一时间点没有对应的全量备份，
 * 我们就先找到最近的一次全量备份，然后用它来恢复，之后执行此次全量备份跟这一时间点之间的所有增量备份，
 * 也就是对应的操作或者数据变动。这样就能减少全量备份的数量和频率，减少对时间、内存的消耗
 *
 *
 *
 *
 **/