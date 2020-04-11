package DesignPattern.BehavioralPattern.VisitorDesignPattern.example2;

/**
 * author: WentaoKing
 * created on: 2020/4/11
 * description: word提取器
 */
public class WORDExtractor implements Extractor2 {

    @Override
    public void extract2txt(ResourceFile resourceFile) {
        System.out.println("提取word");
    }
}
