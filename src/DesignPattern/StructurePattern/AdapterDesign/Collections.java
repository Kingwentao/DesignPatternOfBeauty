package DesignPattern.StructurePattern.AdapterDesign;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * author: WentaoKing
 * created on: 2020/3/5
 * description: 兼容老版本接口
 */
public class Collections {
    public static Enumeration enumeration(final Collection c){
        return new Enumeration(){

            //暂时保留 Enumeration 类，并将其实现替换为直接调用 Iterator
            Iterator i = c.iterator();

            @Override
            public boolean hasMoreElements() {
                return i.hasNext();
            }

            @Override
            public Object nextElement() {
                return i.next();
            }
        };
    }
}
