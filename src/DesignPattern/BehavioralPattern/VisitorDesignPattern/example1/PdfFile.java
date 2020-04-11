package DesignPattern.BehavioralPattern.VisitorDesignPattern.example1;

/**
 * author: WentaoKing
 * created on: 2020/4/9
 * description: pdf文件资源
 */
public class PdfFile extends ResourceFile {

    public PdfFile(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Visitor visitor) {
        System.out.println("visiting pdf file");
    }
}
