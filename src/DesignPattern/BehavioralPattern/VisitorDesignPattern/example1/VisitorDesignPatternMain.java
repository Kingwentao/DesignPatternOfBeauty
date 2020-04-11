package DesignPattern.BehavioralPattern.VisitorDesignPattern.example1;

import java.util.ArrayList;
import java.util.List;

/**
 * author: WentaoKing
 * created on: 2020/4/9
 * description:
 */
public class VisitorDesignPatternMain {

    public static void main(String[] args) {
        Extractor extractor = new Extractor();
        List<ResourceFile> resourceFiles = listAllResourceFiles();
        for (ResourceFile resourceFile: resourceFiles){
            resourceFile.accept(extractor);
        }
    }

    private static List<ResourceFile> listAllResourceFiles(){
        List<ResourceFile> resourceFiles = new ArrayList<>();
        resourceFiles.add(new PdfFile("a.pdf"));
        resourceFiles.add(new WordFile("b.word"));
        resourceFiles.add(new PptFile("c.ppt"));
        return resourceFiles;
    }
}
