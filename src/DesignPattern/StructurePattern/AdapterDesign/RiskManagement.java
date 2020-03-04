package DesignPattern.StructurePattern.AdapterDesign;

import java.util.ArrayList;
import java.util.List;

/**
 * author: WentaoKing
 * created on: 2020/3/4
 * description: 扩展性更好，更加符合开闭原则，如果添加一个新的敏感词过滤系统
 * 这个类完全不需要改动；而且基于接口而非实现编程，代码的可测试性更好。
 */
public class RiskManagement  {

    private List<ISensitiveWordsFilter> filters = new ArrayList<>();

    public void addSensitiveWordFilters(ISensitiveWordsFilter filter){
        filters.add(filter);
    }

    public String filterSensitiveWordsFilter(String text){
        String makeText = text;
        for (ISensitiveWordsFilter filter: filters){
            makeText = filter.filter(text);
        }
        return makeText;
    }
}
