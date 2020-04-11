package DesignPattern.BehavioralPattern.VisitorDesignPattern.example1;

/**
 * author: WentaoKing
 * created on: 2020/4/9
 * description: 资源文件抽象
 */
public abstract class ResourceFile {

    protected String filePath;

    public ResourceFile(String filePath){
        this.filePath = filePath;
    }

    abstract public void accept(Visitor visitor);
}
