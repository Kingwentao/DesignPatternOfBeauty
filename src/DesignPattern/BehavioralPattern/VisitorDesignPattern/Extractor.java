package DesignPattern.BehavioralPattern.VisitorDesignPattern;

/**
 * author: WentaoKing
 * created on: 2020/4/9
 * description: 文件内容提取者
 */
public class Extractor implements Visitor {

    @Override
    public void visit(PdfFile pdfFile) {
        System.out.println("提取 pdf 文件" + pdfFile.filePath);
    }

    @Override
    public void visit(PptFile pptFile) {
        System.out.println("提取 ppt 文件" + pptFile.filePath);
    }

    @Override
    public void visit(WordFile wordFile) {
        System.out.println("提取 word 文件"+ wordFile.filePath);
    }
}
