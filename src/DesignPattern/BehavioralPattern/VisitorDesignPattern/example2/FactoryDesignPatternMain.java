package DesignPattern.BehavioralPattern.VisitorDesignPattern.example2;

import java.util.ArrayList;
import java.util.List;

/**
 * author: WentaoKing
 * created on: 2020/4/11
 * description:将访问者设计模式的案例用工厂设计模式实现
 */
public class FactoryDesignPatternMain {
    public static void main(String[] args) {
        List<ResourceFile> resourceFiles = listAllResourceFiles();
        for (ResourceFile resourceFile : resourceFiles) {
            Extractor2 extractor = ExtractorFactory.getExtractor(resourceFile.getType());
            extractor.extract2txt(resourceFile);
        }
    }


    private static List<ResourceFile> listAllResourceFiles() {
        List<ResourceFile> resourceFiles = new ArrayList<>();
        resourceFiles.add(new PDFFile("a.pdf"));
        resourceFiles.add(new WORDFile("b.word"));
        resourceFiles.add(new PPTFile("c.ppt"));
        return resourceFiles;
    }

}
