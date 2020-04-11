package DesignPattern.BehavioralPattern.VisitorDesignPattern.example1;

/**
 * author: WentaoKing
 * created on: 2020/4/9
 * description: ppt文件资源
 */
public class PptFile extends ResourceFile {

    public PptFile(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Visitor visitor) {
        System.out.println("visiting ppt file");
    }
}
