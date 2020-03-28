package DesignPattern.BehavioralPattern.ChainOfResponsibilityPattern.example1;

import java.util.ArrayList;
import java.util.List;

/**
 * author: WentaoKing
 * created on: 2020/3/28
 * description: 敏感词汇过滤器 链式处理
 */
public class SensitiveWordFilterChain {

    private List<SensitiveWordFilter> filters = new ArrayList<>();

    public void addFilter(SensitiveWordFilter filter){
        filters.add(filter);
    }

    // return true if content doesn't contain sensitive words.
    public boolean filter(Content content){
        for (SensitiveWordFilter filter : filters){
            if (filter.doFilter(content)){
                return false;
            }
        }
        return true;
    }


}
