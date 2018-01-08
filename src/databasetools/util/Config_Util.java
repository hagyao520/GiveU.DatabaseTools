package databasetools.util;

import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Config_Util {
    
    private static Logger LOG = LoggerFactory.getLogger(Config_Util.class);
    
    public static String getProperty(String key, String config){
        if(key == null || "".equals(key)){
            LOG.error("请传入正确的key信息");
            return null;
        }
            
        if(config == null || "".equals(config)){
            LOG.error("请传人正确的配置文件信息");
            return null;
        }
        return loadConfig(config).getProperty(key);
    }

    private static Properties loadConfig(String config){
        Properties p = new Properties();
        InputStream in = Config_Util.class.getClassLoader().getResourceAsStream(config);
        try {
            if(in == null)
                throw new Exception();
            p.load(in);
        } catch (Exception e) {
            LOG.error("配置文件加载失败", e.fillInStackTrace());
        }
        return p;
    }
    
    public static void main(String[] args) {
        String value = Config_Util.getProperty("image.maxSize", Constants.CONFIG_COMMON);
        System.out.println(value);
    }
}
