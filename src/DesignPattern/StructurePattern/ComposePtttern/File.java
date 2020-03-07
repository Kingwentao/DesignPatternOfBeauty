package DesignPattern.StructurePattern.ComposePtttern;

/**
 * author: WentaoKing
 * created on: 2020/3/7
 * description: 文件类（区分目录）
 */
public class File extends AbFileSystemNode {

    public File(String path) {
        super(path);
    }

    @Override
    public int countNumOfFiles() {
        return 1;
    }

    @Override
    public long countSizeOfFiles() {
        java.io.File file = new java.io.File(path);
        if (!file.exists()) return 0;
        return file.length();
    }
}
