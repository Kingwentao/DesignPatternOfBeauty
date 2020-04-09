package DesignPattern.BehavioralPattern.VisitorDesignPattern;

/**
 * author: WentaoKing
 * created on: 2020/4/9
 * description: visitor 接口
 */
public interface Visitor {

    void visit(PdfFile pdfFile);

    void visit(PptFile pptFile);

    void visit(WordFile wordFile);

}
