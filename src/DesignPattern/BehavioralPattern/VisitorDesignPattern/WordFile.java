package DesignPattern.BehavioralPattern.VisitorDesignPattern;

/**
 * author: WentaoKing
 * created on: 2020/4/9
 * description: word文件资源
 */
public class WordFile extends ResourceFile {

    public WordFile(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Visitor visitor) {
        System.out.println("visiting word file");
    }

}
