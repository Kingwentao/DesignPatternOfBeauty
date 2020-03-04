package DesignPattern.StructurePattern.AdapterDesign;

/**
 * author: WentaoKing
 * created on: 2020/3/3
 * description:
 */
public class ASensitiveWordsFilterAdaptor implements ISensitiveWordsFilter {

    private ASensitiveWordsFilter aFilter;

    @Override
    public String filter(String text) {
        String maskedText = aFilter.filterSexyWords(text);
        maskedText = aFilter.filterPoliticalWords(maskedText);
        return maskedText;
    }

}
