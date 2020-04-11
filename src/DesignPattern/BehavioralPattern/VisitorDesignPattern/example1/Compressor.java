package DesignPattern.BehavioralPattern.VisitorDesignPattern.example1;

/**
 * author: WentaoKing
 * created on: 2020/4/9
 * description: 文件压缩类
 */
public class Compressor implements Visitor {

    @Override
    public void visit(PdfFile pdfFile) {
        System.out.println(" compress pdf file" + pdfFile.filePath);
    }

    @Override
    public void visit(PptFile pptFile) {
        System.out.println(" compress ppt file" + pptFile.filePath);
    }

    @Override
    public void visit(WordFile wordFile) {
        System.out.println(" compress word file" + wordFile.filePath);
    }

}
