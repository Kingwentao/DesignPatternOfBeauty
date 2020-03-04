package DesignPattern.StructurePattern.AdapterDesign;

/**
 * author: WentaoKing
 * created on: 2020/3/4
 * description:
 */
public class BAdapter implements IA {

    private B b;

    BAdapter(B b){
        this.b = b;
    }

    @Override
    public void fa() {
        b.fb();
    }
}
