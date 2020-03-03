package DesignPattern.StructurePattern.AdapterDesign;

/**
 * author: WentaoKing
 * created on: 2020/3/3
 * description:  A敏感词过滤系统提供的接口
 */
public class ASensitiveWordsFilter {

    //text是原始文本，函数输出用***替换敏感词之后的文本
    public String filterSexyWords(String text) {
        // ...
        return "A1";
    }

    public String filterPoliticalWords(String text) {
        // ...
        return "A2";
    }

}
