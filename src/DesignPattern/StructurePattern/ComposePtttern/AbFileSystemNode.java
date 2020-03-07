package DesignPattern.StructurePattern.ComposePtttern;

/**
 * author: WentaoKing
 * created on: 2020/3/7
 * description: 重构一个文件系统抽象类
 */
public abstract class AbFileSystemNode {
    protected String path;

    AbFileSystemNode(String path) {
        this.path = path;
    }

    public abstract int countNumOfFiles();

    public abstract long countSizeOfFiles();

    public String getPath(){
        return path;
    }
}
