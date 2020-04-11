package DesignPattern.BehavioralPattern.VisitorDesignPattern.example2;

/**
 * author: WentaoKing
 * created on: 2020/4/11
 * description:
 */
public abstract class ResourceFile {

    protected String filePath;
    ResourceFile(String filePath){
        this.filePath = filePath;
    }

    public abstract ResourceFileType getType();
}
