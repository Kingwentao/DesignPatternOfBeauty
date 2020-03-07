package DesignPattern.StructurePattern.ComposePtttern;

import java.util.ArrayList;
import java.util.List;

/**
 * author: WentaoKing
 * created on: 2020/3/7
 * description: 文件中的目录
 */
public class Directory extends AbFileSystemNode {

    private List<AbFileSystemNode> subNodes = new ArrayList<>();

    Directory(String path) {
        super(path);
    }

    @Override
    public int countNumOfFiles() {
        int numOfFiles = 0;
        for (AbFileSystemNode fileOrDir : subNodes) {
            numOfFiles += fileOrDir.countNumOfFiles();
        }
        return numOfFiles;
    }

    //计算文件大小
    @Override
    public long countSizeOfFiles() {
        long sizeofFiles = 0;
        for (AbFileSystemNode fileOrDir : subNodes) {
            sizeofFiles += fileOrDir.countSizeOfFiles();
        }
        return sizeofFiles;
    }

    public void addSubNode(AbFileSystemNode fileOrDir) {
        subNodes.add(fileOrDir);
    }

    public void removeSubNode(AbFileSystemNode fileOrDir){
        int size = subNodes.size();
        int i = 0;
        for (;i<size;++i){
            if (subNodes.get(i).getPath().equalsIgnoreCase(fileOrDir.getPath())){
                break;
            }
        }
        if (i<size){
            subNodes.remove(i);
        }
    }
}
