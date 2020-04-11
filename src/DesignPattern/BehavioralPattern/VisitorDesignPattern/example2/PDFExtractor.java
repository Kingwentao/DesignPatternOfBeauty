package DesignPattern.BehavioralPattern.VisitorDesignPattern.example2;


/**
 * author: WentaoKing
 * created on: 2020/4/11
 * description: pdf提取器
 */
public class PDFExtractor implements Extractor2 {

    @Override
    public void extract2txt(ResourceFile resourceFile) {
        System.out.println("提取pdf");
    }
}
