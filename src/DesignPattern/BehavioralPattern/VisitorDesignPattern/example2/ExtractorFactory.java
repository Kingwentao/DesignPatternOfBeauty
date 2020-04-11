package DesignPattern.BehavioralPattern.VisitorDesignPattern.example2;

import DesignPattern.BehavioralPattern.VisitorDesignPattern.example1.Extractor;

import java.util.HashMap;
import java.util.Map;

/**
 * author: WentaoKing
 * created on: 2020/4/11
 * description: 提取器创建工厂
 */
public class ExtractorFactory {

    private static final Map<ResourceFileType, Extractor2> extractors = new HashMap<>();

    static {
        extractors.put(ResourceFileType.PDF, new PDFExtractor());
        extractors.put(ResourceFileType.PPT, new PPTExtractor());
        extractors.put(ResourceFileType.WORD, new WORDExtractor());
    }

    public static Extractor2 getExtractor(ResourceFileType type) {
        return extractors.get(type);
    }
}
