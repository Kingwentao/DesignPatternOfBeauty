package DesignPattern.BehavioralPattern.VisitorDesignPattern.example2;

/**
 * author: WentaoKing
 * created on: 2020/4/11
 * description:
 */
public class PPTFile extends ResourceFile {

    public PPTFile(String filePath){
        super(filePath);
    }

    @Override
    public ResourceFileType getType() {
        return ResourceFileType.PPT;
    }
}
