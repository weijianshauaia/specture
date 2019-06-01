package cn.edu.pku.util;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtils {

	public static Map<String, String> readDetails() {
		Map<String, String> map = new HashMap<String, String>();
		try {
			InputStream in = PropertiesUtils.class.getClassLoader().getResourceAsStream("config.properties");
			Properties p = new Properties();
			p.load(in);
			map.put("name", p.getProperty("name"));
			map.put("version", p.getProperty("version"));
			map.put("link", p.getProperty("link"));
			map.put("link2", p.getProperty("link2"));
			map.put("link3", p.getProperty("link3"));
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return map;
	}

	public static List<String> readFormats() {
		List<String> formats = null;
		try {
			InputStream in = PropertiesUtils.class.getClassLoader().getResourceAsStream("config.properties");
			Properties p = new Properties();
			p.load(in);
			formats = Arrays.asList(p.getProperty("formats").split(","));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return formats;
	}

	public static Map<String, String> readConfig() {
		Map<String, String> map = new HashMap<String, String>();
		try {
			InputStream in = PropertiesUtils.class.getClassLoader().getResourceAsStream("config.properties");
			Properties p = new Properties();
			p.load(in);
			map.put("debug", p.getProperty("debug"));
			map.put("encrypt", p.getProperty("encrypt"));
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return map;
	}
}
