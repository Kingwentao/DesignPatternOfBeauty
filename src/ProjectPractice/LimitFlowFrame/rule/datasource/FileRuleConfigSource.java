package ProjectPractice.LimitFlowFrame.rule.datasource;

import ProjectPractice.LimitFlowFrame.rule.RuleConfig;
import ProjectPractice.LimitFlowFrame.rule.parser.JsonRuleConfigParser;
import ProjectPractice.LimitFlowFrame.rule.parser.RuleConfigParser;
import ProjectPractice.LimitFlowFrame.rule.parser.YamlRuleConfigParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * author: WentaoKing
 * created on: 2020/6/8
 * description: 给予本地文件的配置类
 */
public class FileRuleConfigSource implements RuleConfigSource {

    public static final String API_LIMIT_CONFIG_NAME = "ratelimiter-rule";
    public static final String YAML_EXTENSION = "yaml";
    public static final String YML_EXTENSION = "yml";
    public static final String JSON_EXTENSION = "json";

    private static final String[] SUPPORT_EXTENSIONS = new String[]{YAML_EXTENSION, YML_EXTENSION, JSON_EXTENSION};
    private static final Map<String, RuleConfigParser> mParserMap = new HashMap<>();

    static {
        mParserMap.put(YAML_EXTENSION, new YamlRuleConfigParser());
        mParserMap.put(YML_EXTENSION, new YamlRuleConfigParser());
        mParserMap.put(JSON_EXTENSION, new JsonRuleConfigParser());
    }


    @Override
    public RuleConfig load() {
        for (String extension : SUPPORT_EXTENSIONS) {
            InputStream in = null;
            try {
                in = getClass().getResourceAsStream("/" + getFileNameByExt(extension));
                if (in != null) {
                    RuleConfigParser parser = mParserMap.get(extension);
                    return parser.parser(in);
                }
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        System.out.println("close file error " + e);
                    }
                }
            }
        }
        return null;
    }

    private String getFileNameByExt(String extension) {
        return API_LIMIT_CONFIG_NAME + "." + extension;
    }
}
