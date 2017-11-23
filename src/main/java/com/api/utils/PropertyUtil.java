package com.api.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyUtil
{
    private static Map<String, String> propertiesMap = new HashMap<String, String>();

    private static Log logger = LogFactory.getLog(PropertyUtil.class);

    public static void processProperties(Properties props)
    {

        propertiesMap = new HashMap<String, String>();
        for (Object key : props.keySet())
        {
            String keyStr = key.toString();

            try
            {
                //PropertiesLoaderUtils的默认编码是ISO-8859-1,在这里转码一下
                propertiesMap.put(keyStr, new String(props.getProperty(keyStr).getBytes("UTF-8"), "utf-8"));
            }
            catch (UnsupportedEncodingException e)
            {
                logger.error(e.getMessage());
            }
            catch (java.lang.Exception e)
            {
                logger.error(e.getMessage());
            }

        }

    }

    public static void loadAllProperties()
    {
        try
        {

            Properties properties = PropertiesLoaderUtils.loadAllProperties("ResultCodeDesc.properties");
            processProperties(properties);
        }
        catch (IOException e)
        {
            logger.error(e.getMessage());
        }
    }

    public static String getProperty(String name)
    {
        return propertiesMap.get(name).toString();
    }
}
